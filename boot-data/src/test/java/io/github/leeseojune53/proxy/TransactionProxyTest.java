package io.github.leeseojune53.proxy;

import io.github.leeseojune53.bean.ApplicationContext;
import io.github.leeseojune53.proxy.testsupport.TransactionService;
import io.github.leeseojune53.session.SessionManager;
import io.github.leeseojune53.transaction.Transaction;
import org.junit.jupiter.api.Test;


class TransactionProxyTest {


    @Test
    void testWithTransaction() {
        // TODO Test 시 DI 받는거 고민해야함

        SessionManager.clean();
        var applicationContext = new ApplicationContext();
        applicationContext.loadBean();
        var testClass = applicationContext.get(TransactionService.class);

        testClass.transactionAndDoSomething();

    }

    @Test
    void testWithoutTransaction() {
        // TODO Test 시 DI 받는거 고민해야함

        SessionManager.clean();
        var applicationContext = new ApplicationContext();
        applicationContext.loadBean();
        var testClass = applicationContext.get(TransactionService.class);

        testClass.doSomething();
    }

}