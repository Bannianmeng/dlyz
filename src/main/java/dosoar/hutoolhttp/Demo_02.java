package dosoar.hutoolhttp;

import cn.hutool.http.HttpRequest;
import dosoar.beforeinit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Demo_02 {



    
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = beforeGetChrome.getbefore("https://www.baidu.com/");
        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("123");
    }
}
