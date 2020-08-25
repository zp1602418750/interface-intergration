package com.tiza.dcms.inf.controller;

import com.tiza.dcms.inf.dflzm.apis.entities.Lower;
import com.tiza.dcms.inf.dflzm.apis.entities.ResponseEntity;
import com.tiza.dcms.inf.dflzm.apis.entities.Upper;
import com.tiza.dcms.inf.utils.dflzm.BeanCopyUtil;

public class Test {
    public static void main(String[] args) {
        Upper upload = new Upper("upload", "200", "32222");
        Lower lower = new Lower();
        BeanCopyUtil.BeanCopy(upload,lower);
        System.out.println(lower);

    }
}
