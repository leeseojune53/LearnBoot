package io.github.leeseojune53.aop;

import io.github.leeseojune53.aop.testsupport.TestBeanClass;
import io.github.leeseojune53.bean.ApplicationContext;
import org.junit.jupiter.api.Test;


class BaseAopSpecTest {

    @Test
    public void asdf() {
        var applicationContext = new ApplicationContext();
        applicationContext.loadBean();
        var testBean = applicationContext.get(TestBeanClass.class);

        testBean.doSomething();
    }

}