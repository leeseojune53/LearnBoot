package io.github.leeseojune53.config;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YamlLoader {

    public void asdf() {
        InputStream input = null;
        try {
            input = new FileInputStream("src/test/resources/specification/example2_28.yaml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Yaml yaml = new Yaml();
        for (Object data : yaml.loadAll(input)) {
            System.out.println(data);
        }
    }

}
