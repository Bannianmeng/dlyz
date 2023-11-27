package dosoar.beforeinit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class beforeDlyz {
    /**
     * 前置代码：输入账号密码
     */
    private static WebDriver driver;
    public static WebDriver getbefore() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://remote.dosoar.com/");
        driver.manage().window().maximize();//全屏
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//隐式等待
        Thread.sleep(2000);
        driver.findElement(By.id("basic_account")).clear();
        driver.findElement(By.id("basic_account")).sendKeys("whh");
        driver.findElement(By.id("basic_password")).clear();
        driver.findElement(By.id("basic_password")).sendKeys("Dosoar@123456");
        Thread.sleep(1000);


        return driver;
    }
}
