package com.example.boot_demo.core.repository;

import com.example.boot_demo.core.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: ${description}
 * @author: jeloter
 * @create: 2019-08-07 17:36
 **/
//,QueryDslPredicateExecutor<Work>
public interface WorkRepository extends JpaRepository<Work,Integer>{

}
