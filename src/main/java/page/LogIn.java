package page;

import cn.hutool.json.JSONUtil;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import tool.DriverTool;
import tool.ffdmTool;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LogIn {
    private static WebDriver driver = DriverTool.getDriver();


    /**
     * 登录输入账号、密码
     *
     * @param driver 登录
     * @return {@link WebDriver}
     * @throws InterruptedException 中断异常
     */
    public static WebDriver LogIn() {

        driver.findElement(By.id("basic_account")).sendKeys("whh");//输入账号
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.id("basic_password")).sendKeys("Dosoar@123456");//输入密码
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    /**
     * 截图（全屏）
     * 出参：截图路径
     */
    public static File Screenshot() {

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
        File file = new File("D:\\dlyz\\src\\main\\resources\\img\\", screenshotFile.getName());

        boolean png = false;//保存截图
        try {
            png = ImageIO.write(codeImage, "png", file);
        } catch (IOException e) {
            System.out.println("保存验证码截图出现异常");
            throw new RuntimeException(e);
        }

        return png ? file : null;
    }

    /**
     * 调用斐斐打码获取验证码
     */
    public static String getFfdm(File file) throws Exception {
        //TODO 去调用斐斐打码获取验证码code

        String code = ffdmTool.getCode(file);
        System.out.println("验证码：" + code);
        driver.findElement(By.id("basic_captcha")).sendKeys(code);//输入验证码


        return code;
    }

    /**
     * 输入验证码并点击
     *
     * @param verificationCode 验证码
     */
    public static void enterVerificationCode(String verificationCode) {
        driver.findElement(By.id("basic_captcha")).sendKeys();
    }


    /**
     * 点击登录
     */
    public static void clickToLogIn() {
        try {
            driver.findElement(By.xpath("//*[@id=\"basic\"]/div[4]/div/div/div/div/button/span")).click();
            if (driver.getWindowHandle() != "https://remote.dosoar.com/#/user/login?redirect=%2F") {
                System.out.println("登录成功");
            }
        } catch (Exception e) {
            System.out.println("点击登录失败");
        }
    }

    @Test
    public static void Test() {
        Screenshot();
        System.out.println("测试");
    }

}
