package co.edu.uptc.i18nlib;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties = new Properties();

    public void load(String fileName) {
        loadInternal(fileName);
        loadExternal(fileName);
    }

    private void loadInternal(String fileName) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception ignored) {}
    }

    private void loadExternal(String fileName) {
        try (InputStream input = new FileInputStream(fileName)) {
            properties.load(input);
        } catch (Exception ignored) {}
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
