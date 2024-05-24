package io.github.leeseojune53.bean;

import io.github.leeseojune53.bean.annotation.Bean;
import org.reflections.Reflections;

import java.util.Set;

/**
 * If a class is annotated with {@code @Bean}, it will be scanned by the {@link BeanScanner}.
 * @see Bean
 */
public class BeanScanner {

    private final String basePackage;

    public BeanScanner(String basePackage) {
        this.basePackage = basePackage;
    }

    public Set<Class<?>> scan() {
        System.out.println("Scanning " + basePackage + " for beans");
        var reflections = new Reflections(basePackage);
        return reflections.getTypesAnnotatedWith(Bean.class);
    }


}