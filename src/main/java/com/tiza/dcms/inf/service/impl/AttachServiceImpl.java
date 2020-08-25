package com.tiza.dcms.inf.service.impl;

import com.alibaba.fastjson.JSON;
import com.tiza.dcms.inf.dflzm.apis.DflzmConstant;
import com.tiza.dcms.inf.dflzm.apis.entities.RequestEntity;
import com.tiza.dcms.inf.dflzm.apis.entities.Result;
import com.tiza.dcms.inf.dflzm.apis.enums.UrlEnum;
import com.tiza.dcms.inf.service.AttachService;
import com.tiza.dcms.inf.utils.dflzm.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class AttachServiceImpl implements AttachService {

    private HandleResponseResult handleResponseResult;

    @Override
    public Result<Object> uploadAttach() {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setReqSystem("LQMMDM");
        requestEntity.setReqTime(DateUtil.formatNow());
        // new 一个HashMap,封装请求参数,请求DMS系统接口
        HashMap<String, Object> dataMap = new HashMap<>();
        // TODO 这里需往dataMap里面put数据,现在不知道放什么,暂时留着.
        requestEntity.setDataMap(dataMap);
        String reqParam = ReqToJsonUtil.ReqToJson(requestEntity);
      /*  HashMap<String, Object> map = new HashMap<>();
        map.put("psoIds", Arrays.asList(616));
        String reqParam = JSON.toJSONString(map);*/
        String jsonString = JSON.toJSONString(SecurityUtil.setParamWithSecurity(reqParam));
        // 此处的url暂时写成这样,具体的url接口文档里面并没有写
        String result= DflzmHttpRequest.sendPost(DflzmConstant.URL+ UrlEnum.VEHICLE_INFO.getUrl(),jsonString);
        //String result = DflzmHttpRequest.sendPost("http://localhost:9105/sale/salePartsByPsoIds", reqParam);
        // 处理DMS系统返回给的数据
        return handleResponseResult.handleResponseResult(result);
    }
}
