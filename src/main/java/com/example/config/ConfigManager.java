package com.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final String PROPERTIES_PATH = "prod.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream(PROPERTIES_PATH)) {
            if (input == null) {
                throw new RuntimeException(PROPERTIES_PATH + " file not found");
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Config loading error: " + e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return System.getProperty("baseUrl",PROPERTIES.getProperty("base.url"));
    }
}
