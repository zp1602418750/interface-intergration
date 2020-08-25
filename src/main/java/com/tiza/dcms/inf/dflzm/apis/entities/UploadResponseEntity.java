package com.tiza.dcms.inf.dflzm.apis.entities;

import lombok.Data;

@Data
public class UploadResponseEntity<T> {
    private String message;
    private int status;
    private T res;

}
