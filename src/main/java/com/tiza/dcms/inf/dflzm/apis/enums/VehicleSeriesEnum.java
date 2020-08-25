package com.tiza.dcms.inf.dflzm.apis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VehicleSeriesEnum {

    SERIESID("SERIESID","seriesId"),
    STRAINID("STRAINID","strainId"),
    CODE("CODE","code"),
    NAME("NAME","name"),
    ORDERNO("ORDERNO","orderNo"),
    REMARK("REMARK","remark"),
    STATUS("STATUS","status"),
    CREATEDATE("CREATEDATE","createDate"),
    UPDATEDATE("UPDATEDATE","updateDate");

    final String oriStr;
    final String entityStr;

}
