package io.github.leeseojune53.proxy;

import io.github.leeseojune53.annotation.Transactional;
import io.github.leeseojune53.aop.AopSpec;

import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class TransactionProxy implements AopSpec {

    @Override
    public boolean condition(Method method) {
        return method.isAnnotationPresent(Transactional.class) ||
                method.getDeclaringClass().isAnnotationPresent(Transactional.class);
    }

    @Override
    public void before() {
        // Transaction 시작
        System.out.println("Transaction Start");
    }

    @Override
    public void after() {
        // Transaction 종료
        System.out.println("Transaction End");
    }

    @Override
    public void error() {
        // Transaction Rollback
        System.out.println("Transaction Rollback");
    }
}
