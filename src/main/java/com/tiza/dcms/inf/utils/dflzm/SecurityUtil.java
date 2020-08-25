package com.tiza.dcms.inf.utils.dflzm;

import java.util.HashMap;
import java.util.Map;

import static com.tiza.dcms.inf.dflzm.apis.DflzmConstant.*;

public class SecurityUtil {

    public static Map setParamWithSecurity(String param){

        Map<String,String> result = new HashMap<String, String>();
        String key = DESEncrypt.encryption(USER_ID,SECRET);
        String sign= MD5Util.GetSignValue(USER_ID+"|"+param,SECRET);
        param=DESEncrypt.encryption(param,PASSWORD);
        result.put("key", key);
        result.put("sign", sign);
        result.put("param", param);
        return result;
    }

}
