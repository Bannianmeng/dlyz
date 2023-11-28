package tool;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import dosoar.demo_01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import tool.ffdm.*;

public class ffdmTool {


    /**
     * 获取验证码
     *
     */
    public static String getCode(File img_file) throws Exception {
        /**
         * 初始化读取相关配置文件
         */
        Properties properties = new Properties();
        InputStream input = demo_01.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("读取文件到内存中出错");
            throw new RuntimeException(e);
        }

        Api api = new Api();
        String app_id = properties.getProperty("app_id");
        String app_key = properties.getProperty("app_key");
        String pd_id = properties.getProperty("pd_id");
        String pd_key = properties.getProperty("pd_key");
        String pred_type = properties.getProperty("pred_type");//二维码类型   4位：数字+英文

        api.Init(app_id, app_key, pd_id, pd_key);// 对象生成之后，在任何操作之前，需要先调用初始化接口
        double balance = api.QueryBalcExtend();    // 直接返回余额结果
        System.out.println("剩余积分余额:" + balance);


        byte[] file = FileUtil.readBytes(img_file);//形参接收文件路径
        Util.HttpResp res1 = api.Predict(pred_type, file);// 直接返回识别结果

        /**
         * 对调用成功的json进行处理，获取code
         *  {
         *     "RetCode": “0”,
         *     "ErrMsg": "RetCode非0时，为具体的错误信息",
         *     "RequestId": "201707020038ae826793dc000501afdf",
         *     "RspData": "{\"result\":\"test\"}",
         *   }
         */

        JSONObject jsonObject = JSONObject.parseObject(res1.rsp_data);
        String Code = jsonObject.getString("result");
        System.out.println(Code);
        return Code;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\789.png");
        String code = ffdmTool.getCode(file);
    }
}
