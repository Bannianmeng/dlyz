package dosoar.Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesInstance {

    /**
     * 饿汉单例模式
     * private 只能被此类访问
     * static  修饰方法，直接通过类名访问。无需创建对象
     * 饿汉单例总结
     * 1、构造函数私有化，且在体面做想做的事情
     * 2、构造函数中的公共函数提取出去
     * 3、提供get方法，把全局函数return出去
     * 4、静态代码块 new 构造函数
     */
    private static Properties properties = new Properties();


    private PropertiesInstance() {
        try {
            InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        new PropertiesInstance();
    }

    public static Properties getProperties(){
        return properties;
    }

}
