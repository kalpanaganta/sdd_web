package com.sdd.home.page;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private static Properties properties;
    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = SDDConstants.LOCAL_DIR + SDDConstants.PROPERTIES_FILE_PATH;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static String getDriverPath() {
        return SDDConstants.LOCAL_DIR + properties.getProperty("chrome.driver");
    }

}
