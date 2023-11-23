package dosoar.Screenshot;

import dosoar.ffdm.AuthCode;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class demo_01 {
    public static void main(String[] args) throws Exception {
        // 设置 Chrome 浏览器驱动的路径
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

        /**
         * 1、输入账号密码
         */
        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://remote.dosoar.com/");
            driver.manage().window().maximize();//全屏
            driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);// 显示等待
            Thread.sleep(2000);
            driver.findElement(By.id("basic_account")).clear();
            driver.findElement(By.id("basic_account")).sendKeys("whh");
            driver.findElement(By.id("basic_password")).clear();
            driver.findElement(By.id("basic_password")).sendKeys("Dosoar@123456");
            Thread.sleep(1000);
//      driver.findElement(By.xpath("//*[@id=\"basic\"]/div[3]/div/div[2]/div/div/div/div[2]")).click();//点击
            Thread.sleep(1000);
            /**
             * 截取验证码图片
             */
            WebElement code = driver.findElement(By.xpath("//*[@id=\"basic\"]/div[3]/div/div[2]/div/div/div/div[2]"));//验证码元素
            Point location = code.getLocation();//元素坐标位置,巨坑因为笔记本的缩放为125，导致获取坐标值有偏差
            int width = code.getSize().width;//宽
            int height = code.getSize().height;//高

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//获取整个页面的屏幕截图
            BufferedImage fullImage = ImageIO.read(screenshotFile);
            BufferedImage codeImage = fullImage.getSubimage(location.getX(), location.getY(), width, height);//截取特定位置的图片


            /**
             * 保存验证码图片至绝对路径
             */
            String imgName = screenshotFile.getName();
            File filePath = new File("D:\\dlyz\\src\\main\\resources\\img\\" + imgName);
            ImageIO.write(codeImage, "png", filePath);//保存图片
            /**
             * 传路径，调用获取验证码接口。
             */

        String authcode = AuthCode.getCode(filePath.toString());
//        driver.findElement(By.id("basic_captcha")).sendKeys(authcode);
            Thread.sleep(5000);
//        driver.findElement(By.id("basic_captcha")).sendKeys("123456");  //输入验证码
//            driver.findElement(By.xpath("//*[@id=\"basic\"]/div[4]/div/div/div/div/button")).click(); //点击登录
            /**
             * https://remote.dosoar.com/#/service/workplace
             */
            String currentUrl = driver.getCurrentUrl();
            System.out.println("当前页面URL:" + currentUrl);
            if (currentUrl.equals("https://remote.dosoar.com/#/service/workplace")) {
                //重新再调一次获取验证码并输入（封装一下，调取验证码接口）
                //调用退费接口
                System.out.println("登录成功");

            } else {
                // TODO: 2023/11/13 登录失败的情况，调用二维码退费 
                System.out.println("登录失败");
                throw new RuntimeException("登录失败，无法执行后续用例");
            }
            /**
             * 时间控件方式一：简单可以直接输入
             */
            Thread.sleep(2000);
            System.out.println("===");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.linkText("接待分析")).click();//坑点：用xpath无法定位：通过文字超链接的形式进行定位
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).sendKeys(Keys.DELETE);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).sendKeys("2022-11-01");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(Keys.DELETE);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys("2022-11-01");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(Keys.ENTER);


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Thread.sleep(12000);
            driver.quit();
        }

        // 关闭浏览器

    }
}
