package dosoar.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test_03 {
    /**
     * 群组测试验证：选择特定用例执行@Test(groups = "smoke")
     *  <groups>
     *             <run>
     *                 <include name = "smoke"/>
     *             </run>>
     *  </groups>>
     */

    @Test
    public void Test_01() {
        System.out.println("执行中");
    }
    @Test(groups = "smoke")
    public void Test_02() {
        System.out.println("执行中");
    }
    @Test(groups = "smoke")
    public void Test_03() {
        System.out.println("执行中");
    }
}
