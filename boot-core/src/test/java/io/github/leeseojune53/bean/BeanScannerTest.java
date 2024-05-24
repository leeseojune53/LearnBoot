package io.github.leeseojune53.bean;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.leeseojune53.bean.testsupport.TestBeanClass;
import io.github.leeseojune53.bean.testsupport.TestCustomBeanClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeanScannerTest {

    @DisplayName("If a class is annotated with @Bean, it will be scanned by the BeanScanner.")
    @Test
    void scanSuccess() {
        // given
        var scanner = new BeanScanner("io.github.leeseojune53");

        // when
        var result = scanner.scan();

        // then
        assertThat(result.isEmpty()).isFalse();
        assertThat(result).contains(TestBeanClass.class, TestCustomBeanClass.class);
    }
}
