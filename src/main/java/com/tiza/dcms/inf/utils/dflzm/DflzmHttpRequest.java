package com.tiza.dcms.inf.utils.dflzm;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.tiza.dcms.inf.dflzm.apis.DflzmConstant;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class DflzmHttpRequest extends DflzmConstant {

    /**
     * post 请求
     */
    public static String sendPost(String url, String param) {
        String result = HttpRequest.post(url).header(Header.ACCEPT, HEADER_ACCEPT)
                .header(Header.CONNECTION, HEADER_CONNECTION)
                .header(Header.USER_AGENT, HEADER_USER_AGENT)
                .header(Header.CONTENT_TYPE, HEADER_CONTENT_TYPE)
                .timeout(20000)
                .setReadTimeout(20000)
                .body(param)
                .execute()
                .body();
        return result;
    }

}
