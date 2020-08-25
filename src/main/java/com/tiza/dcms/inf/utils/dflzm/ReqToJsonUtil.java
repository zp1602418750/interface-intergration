package com.tiza.dcms.inf.utils.dflzm;

import com.alibaba.fastjson.JSON;
import com.tiza.dcms.inf.dflzm.apis.entities.RequestEntity;

public class ReqToJsonUtil {

    public static  String ReqToJson(RequestEntity requestEntity ){
        String s = JSON.toJSONString(requestEntity);
        return s;
    }


}
