package com.tiza.dcms.inf.utils.dflzm;

import com.alibaba.fastjson.JSON;
import com.tiza.dcms.inf.dflzm.apis.entities.ResponseEntity;
import com.tiza.dcms.inf.dflzm.apis.entities.Result;
import com.tiza.dcms.inf.dflzm.apis.entities.UploadResponseEntity;
import com.tiza.dcms.inf.dflzm.apis.entities.responseSub.HeadInfo;
import com.tiza.dcms.inf.dflzm.apis.entities.responseSub.ResInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@AllArgsConstructor
public class HandleResponseResult {

    private RedisUtil redisUtil;

    public  Result<Object> handleResponseResult(String response) {
        // 将响应string转成ResponseEntity对象
        ResponseEntity responseEntity = JSON.parseObject(response, ResponseEntity.class);
        //将json数组data和json对象headInfo分别转换成List和HeadInfo
        Object data = responseEntity.getData();
        String result = responseEntity.getResult();
        if (data != null) { // 如果是下发
            List<Object> datalist = JSON.parseArray(data.toString(), Object.class);
            HeadInfo headInfo = JSON.parseObject(responseEntity.getHeadInfo().toString(), HeadInfo.class);
            // 取出接口名称和msgId(唯一标识符)
            String infName = responseEntity.getInfName();
            Integer msgId = headInfo.getMsgId();
            // 将msgId作为文件名,data存入到redis
            redisUtil.set(infName+msgId,datalist);
            //ReadWriteDataUtil.writeDataToFile(infName+msgId,datalist);
            return Result.data(datalist);
        } else if (result != null) { // 否则是上传
            // 将json字符串result转换 UploadResponseEntity对象
            UploadResponseEntity uploadResponseEntity = JSON.parseObject(result, UploadResponseEntity.class);
            Object res = uploadResponseEntity.getRes();
            List<ResInfo> resList = JSON.parseArray(res.toString(), ResInfo.class);
            redisUtil.set(response,resList);
            return Result.data(resList);
        }
        return null;
    }
}
