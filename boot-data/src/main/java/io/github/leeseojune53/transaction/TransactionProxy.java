package io.github.leeseojune53.transaction;

import io.github.leeseojune53.annotation.Transaction;
import io.github.leeseojune53.aop.AopSpec;
import io.github.leeseojune53.aop.annotation.Aop;

@Aop(Transaction.class)
public class TransactionProxy implements AopSpec {


    @Override
    public void before() {
        // Transaction 시작
    }

    @Override
    public void after() {
        // Transaction 종료
    }

    @Override
    public void error() {
        // Transaction Rollback
    }
}
