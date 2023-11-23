package dosoar.login;

import cn.hutool.core.util.ClassUtil;
import dosoar.beforeinit.beforeDlyz;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class demo_01 {
    /**
     *
     * @param args 登录：输入账号、密码（无验证码）
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = beforeDlyz.getbefore();
        driver.manage().window().maximize();//全屏
        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);// 显示等待

        Thread.sleep(2000);
        driver.findElement(By.id("basic_account")).clear();
        driver.findElement(By.id("basic_account")).sendKeys("whh");
        driver.findElement(By.id("basic_password")).clear();
        driver.findElement(By.id("basic_password")).sendKeys("Dosoar@123456..");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"basic\"]/div[3]/div/div[2]/div/div/div/div[2]")).click();//点击
        Thread.sleep(2000);
        WebElement code = driver.findElement(By.xpath("//*[@id=\"basic\"]/div[3]/div/div[2]/div/div/div/div[2]"));//验证码元素

        Point location = code.getLocation();//元素坐标位置,巨坑因为笔记本的缩放为125，导致获取坐标值有偏差
        int width = code.getSize().width;//宽
        int height = code.getSize().height;//高

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//获取整个页面的屏幕截图
        BufferedImage fullImage = ImageIO.read(screenshotFile);
        BufferedImage codeImage = fullImage.getSubimage(location.getX(),location.getY(),width, height);//截取特定位置的图片
        ImageIO.write(codeImage, "png", new File("D:\\" + screenshotFile.getName()));//保存图片

        // 关闭浏览器
        driver.quit();
    }
}
