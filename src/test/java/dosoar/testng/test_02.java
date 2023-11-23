package dosoar.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test_02 {
    /**
     * 验证两种传参方式
     * 方式一：注解@dataProvider定义参数，通过@Test（dataProvider = “方法名”）
     *
     * @return
     */
    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"whh","Dosoar@123456.."},
                {"zww","123456"},
                {"admin","123456"}
        };
    }
    @BeforeTest
    public void BeforeTest() {
        System.out.println("开始之前");
    }
    @Test(dataProvider = "data")
    public void Test(String username , String passwd){
        System.out.println(username+passwd);
        System.out.println("执行中");
    }
    @AfterTest
    public void AfterTest(){

        System.out.println("测试结束");
    }
}
