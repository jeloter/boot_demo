package com.example.boot_demo.core.entity;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ${description}
 * @author: jeloter
 * @create: 2019-08-07 10:10
 **/
@Component
@Getter
public class MyBean {

    private List<String> nonOptions = null;

    @Autowired
    public  MyBean(ApplicationArguments applicationArguments){
            boolean debug = applicationArguments.containsOption("debug");
            nonOptions = applicationArguments.getNonOptionArgs();
        //如果使用“--debug logfile.txt”运行debug = true，files = [“logfile.txt”]
    }
}
