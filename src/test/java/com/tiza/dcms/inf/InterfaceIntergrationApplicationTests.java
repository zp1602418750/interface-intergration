package com.tiza.dcms.inf;

import com.alibaba.fastjson.JSON;
import com.tiza.dcms.inf.config.RedisConfig;
import com.tiza.dcms.inf.dflzm.apis.entities.ResponseEntity;
import com.tiza.dcms.inf.dflzm.apis.entities.Result;
import com.tiza.dcms.inf.dflzm.apis.entities.TPStockUpDetailEntityDTO;
import com.tiza.dcms.inf.dflzm.apis.entities.responseSub.HeadInfo;
import com.tiza.dcms.inf.utils.dflzm.DateUtil;
import com.tiza.dcms.inf.utils.dflzm.DflzmHttpRequest;
import com.tiza.dcms.inf.utils.dflzm.ReadWriteDataUtil;
import com.tiza.dcms.inf.utils.dflzm.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class InterfaceIntergrationApplicationTests {


    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {

        System.out.println("开始写入...");
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setEcode("11");
        ReadWriteDataUtil.writeDataToFile("20200818",responseEntity);
        System.out.println("写入完毕");
        System.out.println("开始读...");
        Object o = ReadWriteDataUtil.readDataFromFile("20200818");
        System.out.println(o);
    }
    @Test
    public void test(){
        // http://192.168.31.166:9105/sale/salePartsByPsoIds
        HashMap<String, Object> map = new HashMap<>();
        map.put("psoIds", Arrays.asList(616));
        String reqParam = JSON.toJSONString(map);
        String result= DflzmHttpRequest.sendPost("http://localhost:9105/sale/salePartsByPsoIds",reqParam);
        Result result1 = JSON.parseObject(result, Result.class);
        Object data = result1.getData();
        //String success = result1.getCode();
        List<TPStockUpDetailEntityDTO> dataList = JSON.parseArray(data.toString(), TPStockUpDetailEntityDTO.class);
        System.out.println(dataList);
        redisTemplate.opsForValue().set("mzd",dataList);
        System.out.println(redisTemplate.opsForValue().get("mzd"));

    }
    @Test
    public void test02(){
        String s = DateUtil.formatNow();
        System.out.println(s);
    }
}
