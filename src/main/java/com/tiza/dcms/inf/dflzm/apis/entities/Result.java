package com.tiza.dcms.inf.dflzm.apis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private boolean success;
    private T data;
    private String msg;

    public  Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(200, data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result(code, data, data == null ? "暂无承载数据" : msg);
    }
    public static <T> Result<T> data(T data) {
        return data(data, "操作成功");
    }



}
