package tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverTool {
    /**
     * 单例模式
     */
    private static WebDriver driver = createDriver();

    private DriverTool() {

    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver createDriver()  {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://remote.dosoar.com/#/user/login?redirect=%2F");
        driver.manage().window().maximize();//全屏
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//隐式等待
        driver.manage().window().maximize();
        return driver;
    }



}
