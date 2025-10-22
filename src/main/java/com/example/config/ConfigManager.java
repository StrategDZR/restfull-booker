package com.example.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ConfigManager {

    private static final String PROPERTIES_PATH = System.getProperty("env", "prod") + ".properties";
    private static Properties properties;

    @SneakyThrows
    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream inputStream = ConfigManager.class
                    .getClassLoader()
                    .getResourceAsStream(PROPERTIES_PATH)) {
                if (inputStream == null) {
                    throw new RuntimeException("Config file not found: " + PROPERTIES_PATH);
                }
                properties.load(inputStream);
                log.info("Loaded config from {}", PROPERTIES_PATH);
            }
        }
        return properties;
    }

    public static String get(String key) {
        return getProperties().getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }
}
