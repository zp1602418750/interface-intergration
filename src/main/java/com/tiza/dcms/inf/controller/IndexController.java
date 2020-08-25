package com.tiza.dcms.inf.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class IndexController {


    @RequestMapping(value = {"", "/index"})
    public String index(){
        log.info("hello");
        return "hello";
    }
}
