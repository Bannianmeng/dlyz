package testcase;

import org.openqa.selenium.WebDriver;
import page.*;
import basepages.*;

import java.io.IOException;

public class Demo_01 {
    public static void main(String[] args) throws InterruptedException, IOException {

        LogIn.LogIn();
        String screenshot = LogIn.Screenshot();
        LogIn.getFfdm(screenshot);


    }
}
