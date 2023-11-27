package tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTool {
    /**
     * 工具类：获取properties文件前置带啊吗
     * 输入：资源键
     * 输出：资源值
     */
    private static Properties properties;
    /**
     * private:私有的，其他类就不能直接访问它，而必须通过该类提供的公共方法来访问。
     * static ：静态的，它将属于整个类，而不是属于某个实例对象。
     */
    static {
        properties  = new Properties();
        InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}
