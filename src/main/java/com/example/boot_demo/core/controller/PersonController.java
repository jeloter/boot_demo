package com.example.boot_demo.core.controller;

import com.example.boot_demo.core.entity.Person;
import com.example.boot_demo.core.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: ${description}
 * @author: jeloter
 * @create: 2019-08-06 11:36
 **/
@Api
@RestController
@RequestMapping("/person")
public class PersonController {

    protected static  Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    //获取列表
    @ApiOperation(value="获取人物列表", notes="无条件")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Person> getList(){
        return personService.getList();
    }
    //获取对象
    @ApiOperation(value="获取人物信息", notes="通过姓名匹配人物")
    @ApiImplicitParam(name = "text", value = "人物姓名", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/man",method = RequestMethod.GET)
    public Person getPerson(@RequestParam(name = "text",defaultValue = "小明") String name){
        return personService.getByName(name);
    }
    //获取对象2
    @RequestMapping(value = "/test/{name}",method = RequestMethod.GET)
    public Person getPerson2(@PathVariable String name){
        return personService.getByName(name);
    }
    //获取对象
    @RequestMapping(value = "/getname",method = RequestMethod.GET)
    public Person getPerson3(String name){
        return personService.getByName(name);
    }
    //获取对象
    @RequestMapping(value = "/findname",method = RequestMethod.GET)
    public Person getPerson4(@RequestParam("name") String name){
        return personService.getByName(name);
    }

    @ApiOperation(value="新增人物", notes="根据人物姓名和年龄")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "age", value = "用户年龄", required = false, dataType = "int",type = "{}.{}")
    })
    @PostMapping(path = "/add/{name}.{age}")
    public Person addPerson(@PathVariable String name,@PathVariable int age){
        return  personService.add(name,age);
    }

    @PostMapping(path = "/delete/{age}")
    public int deletePerson(@PathVariable int age){
        return  personService.delete(age);
    }
}
