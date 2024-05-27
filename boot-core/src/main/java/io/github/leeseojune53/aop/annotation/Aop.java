package io.github.leeseojune53.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Aop {
    Class<?> value();
}
