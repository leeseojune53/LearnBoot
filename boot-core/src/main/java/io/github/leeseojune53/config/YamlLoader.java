package io.github.leeseojune53.config;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class YamlLoader implements ConfigLoader {

    private final String name = "application.yaml";
    private Map<String, Object> configs = Collections.emptyMap();

    private void load() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name);
        configs = Collections.unmodifiableMap(yaml.load(inputStream));
    }

    // TODO @Property로 Yaml 설정 값 가져올 수 있게 하기.


    @Override
    public <T> T get(String key) {
        if (configs.isEmpty()) {
            load();
        }

        var keys = key.split("\\.");

        Map<String, Object> temp = configs;
        for (int i = 0; i < keys.length - 1; i++) {
            temp = (Map<String, Object>) temp.get(keys[i]);
        }

        return (T) configs.get(key);
    }

}
