package dosoar.ffdm;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import dosoar.demo_01;

import java.io.InputStream;
import java.util.Properties;

public class AuthCode {
    /**
     * @param img_file 验证码图片文件的路径
     * @return         验证码数字
     * @throws Exception
     */
    public static String getCode(String img_file) throws Exception {
        /**
         * 读取配置文件初始化代码
         */
        Properties properties = new Properties();
        InputStream input = demo_01.class.getClassLoader().getResourceAsStream("config.properties");
        properties.load(input);

        Api api = new Api();
        String app_id = properties.getProperty("app_id");
        String app_key = properties.getProperty("app_key");
        String pd_id = properties.getProperty("pd_id");
        String pd_key = properties.getProperty("pd_key");
        String pred_type = properties.getProperty("pred_type");//二维码类型   4位：数字+英文

        api.Init(app_id, app_key, pd_id, pd_key);// 对象生成之后，在任何操作之前，需要先调用初始化接口
        double balance = api.QueryBalcExtend();    // 直接返回余额结果
        System.out.println("剩余积分余额:" + balance);


        /**
         * 调用识别验证码接口
         */
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
        String authCode = jsonObject.getString("result");
        System.out.println(authCode);

        return authCode;
    }

}
