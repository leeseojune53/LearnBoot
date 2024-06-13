package io.github.leeseojune53.config.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
public @interface Property {
    String value();
}
// Bean이 생성될 때 어떻게 주입할지 고민.
// BeanScanner에서 생성할 때 주입해야할지?
// 또는 BeanSanner에서 생성할 때 생성된 bean을 후처리를 위해 다른 클래스에게 넘겨줄지?
