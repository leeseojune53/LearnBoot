package io.github.leeseojune53.config;

public interface ConfigLoader {
    <T> T get(String key);
}
