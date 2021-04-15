package com.notepad;

import com.notepad.pojo.Unfinish;
import com.notepad.service.UnfinishService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAsync//开启异步注解功能
@EnableScheduling//开启定时功能的注解
@SpringBootApplication
@MapperScan("com.notepad.mapper")
public class NotepadApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotepadApplication.class, args);





    }



}


