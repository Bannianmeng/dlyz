package tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTool {
    public static void fun1(){
        Properties properties = new Properties();
        InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("pred_type"));
    }
}
