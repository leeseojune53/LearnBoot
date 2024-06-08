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
    public String get(String key) {
        if (configs.isEmpty()) {
            load();
        }
        System.out.println(configs.get("test"));
        return (String) configs.get(key);
        // TODO config에 중첩된 구조를 어떻게 가져올 수 있을지.. Map<String, Map<String, Map<String, String>>>.... 이런 형식은 아닌것같은데
    }
}
