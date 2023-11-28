package tool.ffdm;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;

public class Hello {
    public static void main(String[] args) throws Exception {
        Api api = new Api();
        /**
         * AppID: 339037
         * AppKey: PKq/fefJ4t+nCBkXyaKA7C1eOeTShE9+
         * PD账号: 139037
         * PD秘钥: V52GyGaQVohWmxLMHx4LW7kCl1/QNsZw
         */
        String app_id = "339037";
        String app_key = "PKq/fefJ4t+nCBkXyaKA7C1eOeTShE9+";
        String pd_id = "139037";
        String pd_key = "V52GyGaQVohWmxLMHx4LW7kCl1/QNsZw";
        api.Init(app_id, app_key, pd_id, pd_key);// 对象生成之后，在任何操作之前，需要先调用初始化接口

        double balance = api.QueryBalcExtend();    // 直接返回余额结果
        System.out.println("剩余积分余额:" + balance);

        String pred_type = "30400";//二维码类型   4位：数字+英文
        String img_file = "D:\\dlyz\\src\\main\\java\\dosoar\\img\\Snipaste_01.png";  //通过文件进行验证码识别,请使用自己的图片文件替换
        byte[] file = FileUtil.readBytes(img_file);

        Util.HttpResp res1 = api.Predict(pred_type, file);// 直接返回识别结果
        if (res1.ret_code != 0) {
            System.out.println("调用失败");
            System.out.println("错误消息" + res1.err_msg);
            //调用退款接口
            boolean jflag = false;
            if (jflag) {
                // 识别的结果如果与预期不符，可以调用这个接口将预期不符的订单退款
                // 退款仅在正常识别出结果后，无法通过网站验证的情况，请勿非法或者滥用，否则可能进行封号处理
                int ret = api.JusticeExtend(res1.req_id); // 直接返回是否成功
                if (ret == 0) System.out.println("Justice Success!");
                else System.out.println("Justice fail! code:" + ret);

                Util.HttpResp resp = api.Justice(res1.req_id);// 返回完整信息
                System.out.printf("justice !ret: %d cust: %f err: %s reqid: %s pred: %s\n", resp.ret_code, resp.cust_val, resp.err_msg, resp.req_id, resp.pred_resl);
            }
        } else {
            System.out.println("响应req_id：" + res1.req_id);
            System.out.println("响应resu：" + res1.rsp_data);

        }
        String rsp_data = res1.rsp_data;
        JSONObject jsonObject = JSONObject.parseObject(rsp_data);
        String yzm = jsonObject.getString("result");
        System.out.println(yzm);

    }
}
