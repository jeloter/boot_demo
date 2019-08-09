package com.example.boot_demo.core.controller;

import com.example.boot_demo.exception.MyException;
import com.example.boot_demo.model.JsonResult;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @description: 日志测试
 * @author: jeloter
 * @create: 2019-08-07 12:02
 **/
@Api
@RestController
@RequestMapping("/")
public class LogTestController {
    protected static Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/logtest")
    public JsonResult Test(@RequestParam(value = "role") Integer role) throws Exception {
        logger.info("访问了controller");
        int i = role;

        //Exception异常会自动拦截，这里只是做个测试自定义异常
        if (i<0) {
            //int j = i / 0;
            throw new MyException("999", "异常");
        } else {
            return new JsonResult(200, "成功", new HashMap<>(0));
        }
    }
}
