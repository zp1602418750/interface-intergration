package com.tiza.dcms.inf.dflzm.apis.entities.responseSub;

import lombok.Data;

import java.util.Date;

@Data
public class VehicleSeriesEntity {

    private String seriesId;
    private String strainId;
    private String code;
    private String name;
    private Integer orderNo;
    private String remark;
    private Integer status;
    private Date createDate;
    private Date updateDate;

}
