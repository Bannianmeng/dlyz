package dosoar.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test_01 {
    /**
     * 1、模板：testng三种常见用法
     * 2、通过xml形式接收参数@Parameters({"username", "password"})   在testng.xml中定义<parameter name =“” value = “” ></>
     */
    @BeforeTest
    public void BeforeTest() {
        /**
         * 1、抽取需要做初始初始化的操作
         * 2、初始化driver
         * 3、全屏显示
         * 4、隐藏式等待
         */
        System.out.println("开始之前");
    }

    @Test
    @Parameters({"username", "password"})
    public void Test_01(String username, String password) {

        System.out.println("执行中");
        System.out.println(username+password);

    }
    @Test
    @Parameters({"username", "password"})
    public void Test_02(String username, String password) {

        System.out.println("执行中");
        System.out.println(username+password);
    }

    @AfterTest
    public void AfterTest() {
        /**
         * 1、关闭游览器
         */
        System.out.println("测试结束");
    }
}
