package dosoar.testngRunSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class demo_01 {

    WebDriver driver;


    @BeforeTest
    public void BeforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        ChromeOptions CP = chromeOptions.setHeadless(true);
        driver = new ChromeDriver();
    }

    @Test
//    @Parameters({"exePath"})
    //String exePath
    public void Test_01() throws InterruptedException {
        // 设置 Chrome 浏览器驱动的路径
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

        /**
         * 1、输入账号密码
         */

        driver.get("https://remote.dosoar.com/");
        driver.manage().window().maximize();//全屏
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);//隐式等待
        driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);// 显式等待
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
        BufferedImage fullImage = null;
        try {
            fullImage = ImageIO.read(screenshotFile);
        } catch (IOException e) {
            System.out.println("读取截屏，到内存出错");
            e.printStackTrace();
        }
        BufferedImage codeImage = fullImage.getSubimage(location.getX(), location.getY(), width, height);//截取特定位置的图片


        /**
         * 保存验证码图片至绝对路径
         */
        String imgName = screenshotFile.getName();
        File filePath = new File("D:\\dlyz\\src\\main\\resources\\img\\" + imgName);

        try {
            ImageIO.write(codeImage, "png", filePath);//保存图片
        } catch (IOException e) {
            System.out.println("保存文件失败");
            e.printStackTrace();
        }
        /**
         * 传路径，调用获取验证码接口。
         */

//            String authcode = AuthCode.getCode(filePath.toString());
//            driver.findElement(By.id("basic_captcha")).sendKeys(authcode);
        Thread.sleep(5000);
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
        Thread.sleep(1000);
        System.out.println("===");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /**
         * 时间控件方式一：简单可以直接输入
         * 1、客服运营中心、时间框
         */

//
//            driver.findElement(By.linkText("接待分析")).click();//坑点：用xpath无法定位：通过文字超链接的形式进行定位
////            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).clear();//
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).sendKeys(Keys.DELETE);
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/input")).sendKeys("2022-11-01");
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(Keys.DELETE);
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys("2022-11-01");
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(Keys.ENTER);
//
//            Thread.sleep(1000);
//            String Reception = driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/b")).getText();
//            String Notreceived = driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[2]/b")).getText();
//            System.out.println(Reception + "Reception" + Notreceived);
//
//            try {
//                Assert.assertEquals(Reception,"14人", "用例不通过：接待分析-接待设备-总接待人数");
//
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//                System.out.println("接待分析-接待设备-总接待人数：" + Reception + "预期人数：15");
//            }
//            try {
//                Assert.assertEquals(Notreceived,"3人" , "用例不通过：接待分析-接待设备-未接通：");
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("接待分析-接待设备-未接通：" + Notreceived + "预期人数：4");
//            }
        /**
         * 上传本地截图，使用autoIt实现
         */
        driver.findElement(By.xpath("//*[@id=\"indexlayout-left___3W5DF\"]/div[2]/div/div[1]/ul/li[2]/div/span/div/span")).click(); //点击 设备管理中心
//            driver.findElement(By.linkText("设备台账管理")).click(); //点击 设备台账管理
//            driver.findElement(By.id("serialNumber")).sendKeys("GX07"); // 输入 设备编号GX07
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[14]/button[3]/span")).click(); //点击报修
//            Thread.sleep(2000);
//            //TODO 输入故障时间格式 ：2023-11-15 11:19:03
//            driver.findElement(By.id("maintnceTime")).sendKeys("2023-11-16 15:03:45");
//            driver.findElement(By.id("maintnceTime")).sendKeys(Keys.chord(Keys.ENTER));
//            driver.findElement(By.id("recorder")).sendKeys("王杭杭");//输入故障发现人
//            driver.findElement(By.id("contactPhone")).sendKeys("17718134997");//输入故障发现人


        /**
         * 执行exe文件,上传照片，建议exe文件的路径做成配置项
         * 1、xml中<parameet name = " " value =""/>
         * 2、Test方法上加@Parameters（{“name”}）
         * 3、方法上加形参
         */
//            driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[6]/div/div[2]/div/div/span/div[1]/span/button")).click();//点击 选择文件
//            Thread.sleep(3000);
//            String exePath = PropertiesInstance.getProperties().getProperty("exePath");//单例模式调用
//
//            ProcessBuilder processBuilder = new ProcessBuilder(exePath);
//            Process start = null;
//            try {
//                start = processBuilder.start();
////                start.waitFor();
//            } catch (IOException e) {
//                System.out.println("执行exe文件出错");
//                e.printStackTrace();
//            }
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")).click();//点击 完成
        /**
         *  执行翻页操作
         */

        driver.findElement(By.linkText("故障报修反馈")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div[2]/div/div/div/ul/li[5]/button")).click();//WebElement element = //点击翻页
//        while (true) {
//            System.out.println(driver.findElement(By.xpath("*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[11]/td[1]")).getText());
//            if (element.isEnabled()) {
//                element.click();
//            } else {
//
//                System.out.println("已经到最后一页拉");
//            }
        /**
         * 实现水平滑动和垂直滑动
         *          JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
         *          整个窗口实现垂直滑动：javascriptExecutor.executeScript("window.scrollBy(0,700)");
         *          整个窗口实现水平滑动：javascriptExecutor.executeScript("window.scrollBy(700,0)");
         */
        WebElement element = driver.findElement(By.xpath("//*[@id=\"indexlayout-right___hL9BB\"]/div[2]/div/div[2]/div/div/div/div"));
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) element;
//        javascriptExecutor.executeScript("window.scrollBy(arguments[0], 0)",1000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,arguments[0])", 700);
        javascriptExecutor.executeScript("window.scrollBy(arguments[0], 0)", 700);

    }

//            Thread.sleep(12000);
//            driver.close();


    // 关闭浏览器


    @AfterTest
    public void AfterTest() {
    }
}
