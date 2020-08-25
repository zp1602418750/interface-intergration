package com.tiza.dcms.inf.dflzm.apis;

import com.alibaba.fastjson.JSON;
import com.tiza.dcms.inf.dflzm.apis.entities.RequestEntity;
import com.tiza.dcms.inf.dflzm.apis.entities.Result;
import com.tiza.dcms.inf.dflzm.apis.entities.TPStockUpDetailEntityDTO;
import com.tiza.dcms.inf.dflzm.apis.entities.responseSub.HeadInfo;
import com.tiza.dcms.inf.dflzm.apis.enums.UrlEnum;
import com.tiza.dcms.inf.utils.dflzm.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDemo extends DflzmConstant{

    /**
     *   下发数据获取
     * 方法名: main</br>
     * 详述: </br>
     * 开发人员：huangdian</br>
     * 创建时间：2020年7月29日</br>
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("psoIds", Arrays.asList(616));
        String reqParam = JSON.toJSONString(map);
        String result= DflzmHttpRequest.sendPost("http://localhost:9105/sale/salePartsByPsoIds",reqParam);
        //System.out.println(result);
        Result result1 = JSON.parseObject(result, Result.class);
        System.out.println(result1.getData().getClass().getTypeName());
        Object data = result1.getData();
        //String success = result1.getCode();
        //System.out.println("success->"+success);
        //System.out.println(result1);
        //HeadInfo headInfo = JSON.parseObject(result1.getHeadInfo().getMsgId().toString(), HeadInfo.class);
        //System.out.println(headInfo);
        List<TPStockUpDetailEntityDTO> tpStockUpDetailEntityDTOS = JSON.parseArray(data.toString(), TPStockUpDetailEntityDTO.class);
        System.out.println(tpStockUpDetailEntityDTOS);
        //Integer msgId = result1.getHeadInfo().getMsgId();
        //System.out.println(msgId);

        //String reqParam="{\"reqSystem\":\"LQMMDM\",\"type\":\"2\",\"startTime\":\"2000-06-23 16:11:58\",\"endTime\":\"2020-07-00 00:00:00\",\"reqTime\":\"2020-07-27 11:04:00\",\"dataWay\":1,\"pageIndex\":2,\"pageSize\":10}";
       //String jsonString = JSON.toJSONString(SecurityUtil.setParamWithSecurity(reqParam));

        // 测试环境地址尚未申请下来
        // 调用品系接口
       //String result11= DflzmHttpRequest.sendPost(URL+UrlEnum.VEHICLE_INFO.getUrl(),jsonString);
        //System.out.printf(result);
        //RequestEntity requestEntity = JSON.parseObject(reqParam, RequestEntity.class);
        //System.out.println(result);
    }

}
