package com.notepad.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2

// ，@Configuration用于定义配置类，可替换xml配置文件
// ，被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext
// 或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。

public class SwaggerConfig {

//
//    @Bean
//    public  Docket docket2()
//    {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("陆乾承");
//    }
    @Bean
//    enable是否启用swagger，false不能启用
    public Docket docket(Environment environment){

//设置要显示的swagger的环境
        Profiles profiles = Profiles.of("dev");   //可以传入多个环境

//获取项目环境,判断是否处在自己设定的环境中

        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("小枫")
                .enable(flag)
                .select()
//                RequestHandlerSelectors ->配置扫描接口的方式
//                  basePackage ->指定扫描的包
//                  any() ->扫描全部
//                        none()->不扫描
                .apis(RequestHandlerSelectors.basePackage("com.notepad.controller"))
//                过滤路径
//                  扫描路径feng下面的接口
//                .paths(PathSelectors.ant("/feng/**"))
                .build();

    }


    public ApiInfo apiInfo()
    {
        Contact contact = new Contact("小枫","http://baidu.com","1376245413@qq.com");
        return new ApiInfo(
                "小枫的API文档",
                "不知道怎么写的项目",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()

        );
    }

}
