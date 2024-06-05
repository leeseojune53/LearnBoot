package io.github.leeseojune53.proxy.testsupport;

import io.github.leeseojune53.annotation.Transactional;
import io.github.leeseojune53.bean.annotation.Bean;

@Bean
public class TransactionService {

    @Transactional
    public void transactionAndDoSomething() {
        System.out.println("TransactionService.transactionAndDoSomething");
    }

    public void doSomething() {
        System.out.println("TransactionService.doSomething");
    }
}
