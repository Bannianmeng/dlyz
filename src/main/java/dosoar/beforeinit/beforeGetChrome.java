package dosoar.beforeinit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class beforeGetChrome {
    /**
     * 前置代码：输入账号密码
     */
    private static WebDriver driver;
    public static WebDriver getbefore(String URL) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().window().maximize();//全屏
        Thread.sleep(2000);
        return driver;
    }
}
