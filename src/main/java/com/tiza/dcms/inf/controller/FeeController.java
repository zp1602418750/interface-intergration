package com.tiza.dcms.inf.controller;

import com.tiza.dcms.inf.dflzm.apis.entities.Result;
import com.tiza.dcms.inf.service.FeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 走保工时费用下发控制器
 * @author zpp
 * @date 2020-08-25
 */

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/uploads")
public class FeeController {
    private FeeService feeService;

    public Result<Object> getData(){
        return feeService.getData();
    }
}
