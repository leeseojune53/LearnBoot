package io.github.leeseojune53.aop;

import java.lang.reflect.Method;
import java.util.List;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;
import net.bytebuddy.implementation.bind.annotation.This;
import org.reflections.Reflections;

public class BaseAopSpec {

    private static final List<? extends AopSpec> aopSpecs = new Reflections("io.github.leeseojune53")
            .getSubTypesOf(AopSpec.class).stream()
                    .map(aClass -> {
                        try {
                            return aClass.getConstructor().newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .toList();

    @RuntimeType
    public static Object intercept(
            @This Object self, @Origin Method method, @AllArguments Object[] args, @SuperMethod Method superMethod) {
        var aopSpecs = BaseAopSpec.aopSpecs.stream()
                .filter(aopSpec -> aopSpec.condition(method))
                .toList();
        aopSpecs.forEach(AopSpec::before);

        Object result;
        try {
            result = superMethod.invoke(self, args);
        } catch (Exception e) {
            aopSpecs.reversed().forEach(AopSpec::error);
            throw new RuntimeException(e);
        }

        aopSpecs.reversed().forEach(AopSpec::after);
        return result;
    }
}
