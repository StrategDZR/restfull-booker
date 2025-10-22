package com.example.config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ConfigManager {

    private static final String PROPERTIES_PATH = System.getProperty("env", "prod") + ".properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream(PROPERTIES_PATH)) {
            if (inputStream == null) {
                throw new RuntimeException("Config file not found: " + PROPERTIES_PATH);
            }
            PROPERTIES.load(inputStream);
            log.info("Loaded config from {}", PROPERTIES_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + PROPERTIES_PATH, e);
        }
    }

    private static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }
}
