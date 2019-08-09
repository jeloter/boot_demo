package com.example.boot_demo.core.service;

import com.example.boot_demo.core.entity.Person;

import java.util.List;


/**
 * @description: ${description}
 * @author: jeloter
 * @create: 2019-08-06 11:21
 **/
public interface PersonService {

   List<Person> getList();

   Person getById(long id);

   Person getByName(String name);

   Person add(String name,int age);

   int delete(int id);
}
