package data;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PropertyManager {

    private static Properties properties = new Properties();

    static{
        try {
            Files.walk(Path.of("src/test/resources/properties"))
                    .filter(el -> el.toString().endsWith(".properties"))
                    .forEach(el -> {
                        try {
                            properties.load(new FileReader(el.toFile()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static String get(String propertyKey){
        return properties.get(propertyKey).toString();
    }

}