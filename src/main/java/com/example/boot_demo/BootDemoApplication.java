package com.example.boot_demo;

import com.example.boot_demo.core.entity.MyBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;

@SpringBootApplication
//@Import({Person.class})
//@EnableScheduling  //启动定时任务
@EnableSwagger2
public class BootDemoApplication {

    public static void main(String[] args) {
        ApplicationRunner applicationRunner = new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.print("-------------------before--------------------");
                MyBean myBean = new MyBean(args);
                // 使用 lambda 表达式以及函数操作(functional operation)
                myBean.getNonOptions().forEach((option) -> System.out.print(option + "; "));
                // 在 Java 8 中使用双冒号操作符(double colon operator)
                myBean.getNonOptions().forEach(System.out::println);
                System.out.print("-------------------end--------------------");
            }
        };
        SpringApplication app = new SpringApplication();
        app.setBannerMode(Banner.Mode.OFF);
        app.run(BootDemoApplication.class,args);
        //SpringApplication.run(BootDemoApplication.class, args);
    }

    //让Spring管理JPAQueryFactory
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
