package com.tiza.dcms.inf.controller;

import com.tiza.dcms.inf.dflzm.apis.entities.Result;
import com.tiza.dcms.inf.service.AttachService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 附件上传控制层
 * @author zpp
 * @date 2020-08-19
 */
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/uploads")
public class AttachUploadController {

    private AttachService attachService;

    @RequestMapping("/item")
    public Result<Object> uploadAttach(){
        System.out.println(attachService);
        return attachService.uploadAttach();
    }

}
