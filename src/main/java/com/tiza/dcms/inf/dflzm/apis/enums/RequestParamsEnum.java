package com.tiza.dcms.inf.dflzm.apis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class RequestParamsEnum{

    @Getter
    @AllArgsConstructor
    public enum type {
        QUERY(0, "条件查询"),
        FULL(1, "全量"),
        ADDON(2, "增量");

        final int code;
        final String desc;
    }

    @Getter
    @AllArgsConstructor
    public enum dataWay {
        DEFAULT(0, "默认值"),
        PAGINATION(1, "使用分页");

        final int code;
        final String desc;
    }



}
