package io.github.leeseojune53;

import io.github.leeseojune53.config.YamlLoader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        (new YamlLoader()).get("test.go.url");
    }
}
