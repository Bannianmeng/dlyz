package dosoar.hutoolhttp;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;


public class Demo_01 {

    public static void main(String[] args) {
        HttpRequest request = HttpRequest.get(
                "https://remote.dosoar.com/apiVirtualHuman/device/getListPage?provinceId=1&totalElements=0&pageSize=10&pageNum=1")
                .body("{\"name\":\"wang\",\"age\":\"123\"}")
                .header("Accept", "gzip, deflate, br")
                .header("Accept-Encoding", "*/*")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                .header("Connection", "keep-alive")
                .header("Cookie", "virtual_human_token=MDE0YzcwOWIxMTVkYjc0NzcxMDAyN2I5ZjBhNDdmNjAzNmNkNjMyZTlhNDE5NDY0MzUxYzI0OGUyNTE4ZTAzYQ==; virtual_human_refresh_token=NTE0OGQ2YzFiNTJjOWE1ODE4N2I5NmNjYmI4ZGY4ZWFhNWEzNjk1OWViMDVmODBkNjQzMjQ2OTAzNzRkYTMzZQ==")
                .header("Host", "remote.dosoar.com")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("ec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"119\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "\"Windows\"");


        // 发送 GET 请求并获取响应
        //写一个http请求
        HttpResponse response = request.execute();

        // 获取响应状态码和内容
        int status = response.getStatus();
        String body = response.body();

        // 打印响应结果
        System.out.println("Status: " + status);
        System.out.println("Body: " + body);
    }
}
