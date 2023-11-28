package testcase;

import org.openqa.selenium.WebDriver;
import page.*;
import basepages.*;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo_01 {
    public static void main(String[] args) throws Exception {
//
        LogIn.LogIn();//输入账号密码
        File screenshot = LogIn.Screenshot();//获取文件截图
//        String code = LogIn.getFfdm(screenshot);//获取验证码
//        LogIn.enterVerificationCode(code);//输入验证码
        LogIn.clickToLogIn();//点击登录


    }

}
