package com.tiza.dcms.inf.dflzm.apis.entities;

import com.tiza.dcms.inf.dflzm.apis.entities.responseSub.HeadInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseEntity<T> implements Serializable {

    private String infName;
    private String success;
    private String ecode;
    private String system;
    private String msg;
    private String total;
    private T data;
    private HeadInfo headInfo;
    private String toltalCount;
    private String pages;
    private String result;

}
