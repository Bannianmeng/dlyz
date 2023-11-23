package dosoar.jietu;
import dosoar.beforeinit.beforeDlyz;
import dosoar.beforeinit.beforeGetChrome;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Demo_01 {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = beforeDlyz.getbefore();

        /**
         *
         */
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);    //截全图
        BufferedImage read = ImageIO.read(screenshotAs);    //读到内存
        WebElement element = driver.findElement(By.xpath("//*[@id=\"basic\"]/div[3]/div/div[2]/div/div/div/div[2]/img"));   //找到验证码元素
        BufferedImage subimage = read.getSubimage(element.getLocation().getX(), element.getLocation().getY(), element.getSize().width, element.getSize().height);//二次截图 起始位置x、y、宽、高
        ImageIO.write(subimage,"png",new File("D:\\"+screenshotAs.getName()));  //写到磁盘

    }
}
