package io.github.leeseojune53.aop.testsupport;

import io.github.leeseojune53.aop.AopSpec;
import java.lang.reflect.Method;

public class TestAopSpec implements AopSpec {
    @Override
    public boolean condition(Method method) {
        return method.isAnnotationPresent(TestAopAnnotation.class)
                || method.getDeclaringClass().isAnnotationPresent(TestAopAnnotation.class);
    }

    @Override
    public void before() {
        System.out.println("TestAopAnnotation Start");
    }

    @Override
    public void after() {
        System.out.println("TestAopAnnotation End");
    }

    @Override
    public void error() {
        System.out.println("TestAopAnnotation Rollback");
    }
}
