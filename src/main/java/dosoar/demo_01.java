package dosoar;

import org.testng.annotations.*;


public class demo_01 {

    /**
     * 在测试之前
     */
    @BeforeGroups(groups = "1")
    public void beforeTest() {
        System.out.println("开始之前");
    }

    /**
     * 创建dev新分支
     */
    @Test
    public void Test() {
        System.out.println("执行中1");

    }
    @Test(groups = "1")
    public void Test2() {
        System.out.println("执行中2");

    }

    /**
     * 测试后
     */
    @BeforeGroups(groups = "1")
    public void afterTest() {
        System.out.println("测试结束");
    }

}


