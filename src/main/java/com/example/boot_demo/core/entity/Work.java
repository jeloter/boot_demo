package com.example.boot_demo.core.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @description: QueryDSL 测试类
 * @author: jeloter
 * @create: 2019-08-07 17:28
 **/
@Entity
@Data
@Table(name="t_work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer num;
    private String name;
    private String content;
    private String marker;
}
