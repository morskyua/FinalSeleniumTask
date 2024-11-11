package org.epam.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static PropertyReader propertyReader;
    private Properties properties;

    private PropertyReader() {
    }

    public static PropertyReader getPropertyReader(String path) {
        if (propertyReader == null) {
            propertyReader = new PropertyReader();
            propertyReader.readProperties(path);
        }
        return propertyReader;
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    private void readProperties(String path) {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
