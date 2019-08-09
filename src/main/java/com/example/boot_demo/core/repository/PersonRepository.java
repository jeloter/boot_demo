package com.example.boot_demo.core.repository;

import com.example.boot_demo.core.entity.Person;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @description: ${description}
 * @author: jeloter
 * @create: 2019-08-06 11:16
 **/
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findAllOrderByAge(long id);

    Person findByName(String name);

    int deleteByAge(int age);

    //自定义repository。手写sql
    @Query(value = "update person set name=?1 where id=?4",nativeQuery = true)   //占位符传值形式
    @Modifying
    int updateById(String name,int id);

    @Query("from Person u where u.name=:name")   //SPEL表达式
    Person findUser(@Param("name") String name);// 参数username 映射到数据库字段username
}
