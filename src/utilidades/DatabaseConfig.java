package utilidades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final String PROPERTIES_FILE = "application.properties";
    private static final String URL_PROPERTY = "application.url";
    private static final String USERNAME_PROPERTY = "application.username";
    private static final String PASSWORD_PROPERTY = "application.password";

    public static String getUrl() {
        Properties properties = loadProperties();
        return properties.getProperty(URL_PROPERTY);
    }

    public static String getUsername() {
        Properties properties = loadProperties();
        return properties.getProperty(USERNAME_PROPERTY);
    }

    public static String getPassword() {
        Properties properties = loadProperties();
        return properties.getProperty(PASSWORD_PROPERTY);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = DatabaseConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
