package com.tiza.dcms.inf.dflzm.apis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EcodeEnum {
    SUCCESS(1000,"http响应成功"),
    SING_ERR(2001,"签名错误"),
    PARAM_ILLGAL(2002,"请求参数不合法"),
    INNER_ERR(2003,"服务器内部错误,请联系Java后台开发人员"),
    IP_ADDR_LIMIT(2007,"IP受限");

    final int ecode;
    final String desc;
}
