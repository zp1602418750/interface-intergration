package com.tiza.dcms.inf.utils.dflzm;

import com.tiza.dcms.inf.dflzm.apis.DflzmConstant;
import lombok.AllArgsConstructor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@AllArgsConstructor
public class HttpClientService extends DflzmConstant {


    //请求的API
    @Autowired
    private CloseableHttpClient httpClient;
    //控制请求的超时时间
    @Autowired
    private RequestConfig requestConfig;

    //实现httpClient POST提交
    public String doPost(String url,String json){
        String result = null;
        String charset = "UTF-8";
        //定义请求类型
        HttpPost post = new HttpPost(url);
        //定义超时时间
        post.setConfig(requestConfig);
        // 设置请求头
        post.addHeader("Accept",HEADER_ACCEPT);
        post.addHeader(HTTP.CONN_DIRECTIVE,HEADER_CONNECTION);
        post.addHeader(HTTP.USER_AGENT,HEADER_USER_AGENT);
        post.addHeader(HTTP.CONTENT_TYPE,HEADER_CONTENT_TYPE);

        //判断用户是否传递参数
        if(json !=null){
            StringEntity requestEntity = new StringEntity(json,ContentType.APPLICATION_JSON);
//            requestEntity.setContentType(HEADER_CONTENT_TYPE);
//            requestEntity.setContentEncoding(charset);
            post.setEntity(requestEntity);
        }

        //发送请求
        try {
            CloseableHttpResponse response =
                    httpClient.execute(post);

            //判断返回值状态
            if(response.getStatusLine().getStatusCode() == 200) {

                //表示请求成功
                result = EntityUtils.toString(response.getEntity(),charset);
            }else{
                System.out.println("获取状态码信息:"+response.getStatusLine().getStatusCode());
                throw new RuntimeException();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }



    public String doPost(String url){

        return doPost(url, null);
    }

}



