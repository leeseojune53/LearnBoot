package io.github.leeseojune53.bean;

import io.github.leeseojune53.aop.BaseAopSpec;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class ApplicationContext {

    private static final Map<Class<?>, Object> BEANS = new HashMap<>();
    private static final BeanScanner SCANNER = new BeanScanner("io.github.leeseojune53");

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz) {
        return (T) Optional.ofNullable(BEANS.get(clazz))
                .orElseThrow(() -> new IllegalArgumentException("Bean not found."));
    }

    public void loadBean() {
        var beanTypes = SCANNER.scan();
        generateRecursion(beanTypes, beanTypes.size(), 0);
    }

    private void generateRecursion(Set<Class<?>> retrySet, int beanCount, int attempt) {
        var newRetrySet = new HashSet<Class<?>>();

        if (attempt > beanCount) throw new RuntimeException("Circular dependency detected." + retrySet.toString());

        retrySet.forEach(it -> {
            try {
                BEANS.put(it, generateBean(it, BEANS));
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | RuntimeException e) {
                newRetrySet.add(it);
            }
        });

        if (!newRetrySet.isEmpty()) generateRecursion(newRetrySet, beanCount, attempt + 1);
    }

    private Object generateBean(Class<?> clazz, Map<Class<?>, Object> beans)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        var buddy = new ByteBuddy()
                .subclass(clazz)
                .method(ElementMatchers.any())
                .intercept(MethodDelegation.to(BaseAopSpec.class))
                .make()
                .load(clazz.getClassLoader())
                .getLoaded();

        if (buddy.getDeclaredConstructors().length == 0 || buddy.getDeclaredConstructors().length > 1)
            throw new RuntimeException("Constructor must be only one.");

        var constructor = buddy.getDeclaredConstructors()[0];

        var constructorParameterSize = constructor.getParameters().length;

        var arguments = Arrays.stream(constructor.getParameters())
                .map(it -> beans.getOrDefault(it.getType(), null))
                .filter(Objects::nonNull)
                .toArray();

        if (constructorParameterSize != arguments.length)
            throw new RuntimeException("Constructor parameter size and arguments size must be same.");

        return constructor.newInstance(arguments);
    }
}
