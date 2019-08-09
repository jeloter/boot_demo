package com.example.boot_demo.core.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @description: 类测试
 * @author: jeloter
 * @create: 2019-08-06 11:09
 **/
@Entity
//lombok提供
//@Setter
//@Getter
//@Table(name = "t_person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L; //id

    @Column(name = "name",length = 20)
    private String name; //姓名

    @Column(name = "age", nullable = false, length = 20)
    private int age; //年龄
}
