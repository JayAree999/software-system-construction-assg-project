package io.muzoo.ssc.webapp.config;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationLoader {

    //read config.properties from disk
    public static ConfigProperties load() {
        String configFilename = "config.properties";
        try (FileInputStream fin = new FileInputStream(configFilename)) {
            Properties prop = new Properties();
            prop.load(fin);

            String driverClassName = prop.getProperty("database.driverClassName");
            String connectionUrl = prop.getProperty("database.connectionUrl");
            String username = prop.getProperty("database.username");
            String password = prop.getProperty("database.password");

            ConfigProperties configProperties = new ConfigProperties();
            configProperties.setDatabaseDriverClassName(driverClassName);
            configProperties.setDatabaseConnectionUrl(connectionUrl);
            configProperties.setDatabaseUsername(username);
            configProperties.setDatabasePassword(password);

            return configProperties;

        } catch (Exception e) {
            return null;
        }
    }
}


