package io.github.leeseojune53.bean;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private static final Map<Class<?>, Object> BEANS = new HashMap<>();
    private static final BeanScanner SCANNER = new BeanScanner("io.github.leeseojune53");

    public <T> T getBean(Class<T> clazz) {
        return null;
    }

    /**
     * TODO : Implement this method
     * with injection dependencies
     */
    public void loadBean() {
        SCANNER.scan()
                .forEach(clazz -> {
                    try {
                        BEANS.put(clazz, clazz.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

}
