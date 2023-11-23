package dosoar.frame;

import dosoar.beforeinit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demo_01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = beforeGetChrome.getbefore("https://www.baidu.com/");
        driver.switchTo().frame(driver.findElement(By.id("#kw")));
        driver.switchTo().defaultContent();
        WebElement element = driver.findElement(By.id("123"));
        element.isEnabled();
        element.isDisplayed();
        element.isSelected();
    }
}
