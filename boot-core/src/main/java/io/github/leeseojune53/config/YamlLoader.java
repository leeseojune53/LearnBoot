package io.github.leeseojune53.config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class YamlLoader implements ConfigLoader {

    private final String name = "application.yaml";
    private Map<String, Object> configs = Collections.emptyMap();

    private void load() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name);
        configs =  Collections.unmodifiableMap(yaml.load(inputStream));
    }

    @Override
    public String get(String key) {
        if(configs.isEmpty()) {
            load();
        }
        System.out.println(configs.get("test"));
        return (String) configs.get(key);
    }
}
