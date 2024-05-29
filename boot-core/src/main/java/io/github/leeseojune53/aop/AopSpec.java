package io.github.leeseojune53.aop;

import java.lang.reflect.Method;

public interface AopSpec {
    boolean condition(Method method);
    void before();
    void after();
    void error();
}
