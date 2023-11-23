package dosoar.cookie;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import dosoar.beforeinit.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class demo_01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = beforeGetChrome.getbefore("https://www.baidu.com");

        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.get("https://www.baidu.com");

        Set<Cookie> cookies = driver.manage().getCookies();//获取cookie

        Map<String, String> map = new LinkedHashMap<>();//存放各个cookie键值对

        for (Cookie cookie : cookies) {
            map.put(cookie.getName(), cookie.getValue());
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
//        Cookie cookie = new Cookie(map.get("BIDUPSID"),map.get("BA_HECTOR"),map.get("BAIDUID_BFESS"),map.get("PSTM"),map.get("ZFY"));
        //放置cookie
//        driver.manage().addCookie(cookie);
        //放置cookie
    }
}
