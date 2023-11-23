package dosoar.Thred;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class Demo_01 {
    private static WebDriver driver;

    @BeforeTest()
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com/");
    }

    @Test
    public void Test() throws IOException {
        System.out.println("执行中1");
    }

    @Test
    public void Test2() throws IOException {
        System.out.println("执行中2");
    }

    @AfterTest()
    public void afterTest() {
        System.out.println("结束");
    }

}
