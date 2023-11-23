package dosoar;


import dosoar.proerties.PropertiesTool;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class demo {
    /**
     * 模板文件，请勿修改
     */
    private static WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com/");
    }

    @Test
    public void Test() throws IOException {
        System.out.println("执行中");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("结束");
    }


}
