package com.tiza.dcms.inf.dflzm.apis.entities;

import lombok.Data;

@Data
public class RequestEntity<T> {

    private String type;
    private T dataMap;
    private String reqSystem;
    private String reqTime;
    private String startTime;
    private String endTime;
    private Integer dataWay;
    private Integer pageIndex;
    private Integer pageSize;

}
