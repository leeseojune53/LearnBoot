package io.github.leeseojune53.transaction;

import io.github.leeseojune53.annotation.Transaction;
import io.github.leeseojune53.aop.AopSpec;

import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class TransactionProxy implements AopSpec {

    @Override
    public boolean condition(Method method) {
        if(method.getAnnotation(Transaction.class) != null)
            return true;

        if(method.getClass().getAnnotation(Transaction.class) != null)
            return true;

        return false;

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