package page;

import org.openqa.selenium.*;
import tool.DriverTool;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LogIn {
    private static WebDriver driver = DriverTool.getDriver();


    /**
     * 登录输入账号、密码
     *
     * @param driver 登录
     * @return {@link WebDriver}
     * @throws InterruptedException 中断异常
     */
    public static WebDriver LogIn() throws InterruptedException {

        driver.findElement(By.id("basic_account")).sendKeys("whh");//输入账号
        Thread.sleep(1000);

        driver.findElement(By.id("basic_password")).sendKeys("Dosoar@123456");//输入密码
        Thread.sleep(1000);
        return driver;
    }

    /**
     * 截图（全屏）
     */
    public static String Screenshot() throws IOException {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//获取整个页面的屏幕截图


        //获取验证码图片位置
        WebElement code = driver.findElement(By.xpath("//*[@id=\"basic\"]/div[3]/div/div[2]/div/div/div/div[2]"));//验证码元素
        Point location = code.getLocation();
        int width = code.getSize().width;
        int height = code.getSize().height;

        BufferedImage fullImage = null;
        try {
            fullImage = ImageIO.read(screenshotFile);
        } catch (IOException e) {
            System.out.println("读取截屏到内存出错");
            e.printStackTrace();
        }
        BufferedImage codeImage = fullImage.getSubimage(location.getX(), location.getY(), width, height);//截取特定位置的图片
        File file = new File("D:\\dlyz\\src\\main\\resources\\img" + screenshotFile.getName());
        String ImagePath = "D:\\dlyz\\src\\main\\resources\\img" + screenshotFile.getName();
        ImageIO.write(codeImage, "png", file); //保存截图


        return ImagePath;
    }

    /**
     * 调用斐斐打码获取验证码
     */
    public static String getFfdm(String imagPath) {
        File file = new File(imagPath);
        //TODO 去调用斐斐打码获取验证码code
        String code = null;
        System.out.println("验证码：" + code);
        driver.findElement(By.id("basic_captcha")).sendKeys(code);//输入验证码
        driver.findElement(By.xpath("//*[@id=\"basic\"]/div[4]/div/div/div/div/button")).click();//点击登录
        if (driver.getWindowHandle() != "https://remote.dosoar.com/#/user/login?redirect=%2F") {
            System.out.println("登录成功");
        }


        return code;
    }

}
