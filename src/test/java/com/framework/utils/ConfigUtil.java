package com.framework.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    Properties properties;

    public ConfigUtil() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            System.out.println("Unable to load config file : " + e.getMessage());
        }
    }

    public String get(String key){
        return properties.getProperty(key);
    }
}
