package io.github.leeseojune53.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * 생각해보니 Proxy를 먹일 때 각 클래스를 생성할 때 계산하는 것 보다 해당 조건(어노테이션이 있으면 실행 등)을 충족하면 실행되도록하면 생성 부분이 기존처럼 복잡하지 않고 간단해진다.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({
        METHOD,
        TYPE
})
public @interface Transaction {
}
