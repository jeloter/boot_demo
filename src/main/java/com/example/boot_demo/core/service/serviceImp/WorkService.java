package com.example.boot_demo.core.service.serviceImp;

import com.example.boot_demo.entity.QWork;
import com.example.boot_demo.core.entity.Work;
import com.example.boot_demo.core.repository.WorkRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @description: ${description}
 * @author: jeloter
 * @create: 2019-08-07 17:41
 **/
@Service
public class WorkService {
    @Autowired
    private WorkRepository workRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    JPAQueryFactory jpaQueryFactory;


    //////////////////////////以下展示使用原生的dsl/////////////////////

    /**
     * 根据用户名和密码查找（假定只能找出一条）
     *
     * @param num
     * @param name
     * @return
     */
    public Work findByWorkNameAndPassword(Integer num, String name) {
        QWork work = QWork.work;
        return jpaQueryFactory
                .selectFrom(work)
                .where(
                        work.num.eq(num),
                        work.name.eq(name)
                )
                .fetchOne();
    }

}
