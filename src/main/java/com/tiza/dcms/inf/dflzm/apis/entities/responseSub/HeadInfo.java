package com.tiza.dcms.inf.dflzm.apis.entities.responseSub;

import lombok.Data;

import java.util.Date;

@Data
public class HeadInfo {

    private String dtCat;
    private String optTp;
    private String srcTp;
    private Date msgDt;
    private Integer msgId;
}
