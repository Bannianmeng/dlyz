package basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebInit {
    static WebDriver driver = null;

    /**
     * 获取Driver对象
     *
     * @param url 网页URL
     * @return {@link WebDriver}
     * @throws InterruptedException 中断异常
     */
    public static WebDriver getDriver(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().window().maximize();//全屏
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//隐式等待
        Thread.sleep(2000);


        return driver;
    }

}
