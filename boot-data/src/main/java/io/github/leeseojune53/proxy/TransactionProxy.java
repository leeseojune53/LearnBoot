package io.github.leeseojune53.proxy;

import io.github.leeseojune53.annotation.Transactional;
import io.github.leeseojune53.aop.AopSpec;
import io.github.leeseojune53.session.SessionManager;

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
        SessionManager.getTransaction().begin();
        System.out.println("Transaction Start");
    }

    @Override
    public void after() {
        // Transaction 종료
        SessionManager.getTransaction().commit();
        System.out.println("Transaction End");
    }

    @Override
    public void error() {
        // Transaction Rollback
        SessionManager.getTransaction().rollback();
        System.out.println("Transaction Rollback");
    }
}
