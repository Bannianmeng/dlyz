package dosoar.threadTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_01 {
    private static WebDriver driver;
    @BeforeTest
    public void before(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hao123.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        String currentUrl = driver.getCurrentUrl();
        boolean www = currentUrl.contains("www");
        System.out.println(currentUrl);
        System.out.println(currentUrl.lastIndexOf("s"));
        System.out.println(currentUrl.lastIndexOf("s"));
        Assert.assertEquals(currentUrl,"https://www.hao123.co2/");
    }
    @Test
    public void test2(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://www.hao123.com/");
    }
    @AfterTest
    public void after(){

    }
}
