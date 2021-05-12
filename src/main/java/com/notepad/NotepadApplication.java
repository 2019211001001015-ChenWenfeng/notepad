package com.notepad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAsync//开启异步注解功能
@EnableScheduling//开启定时功能的注解
@SpringBootApplication
@MapperScan("com.notepad.mapper")
//implements WebServerFactoryCustomizer<TomcatServletWebServerFactory>
public class NotepadApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotepadApplication.class, args);
    }
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                // 如果要强制使用https，请松开以下注释
//                 SecurityConstraint constraint = new SecurityConstraint();
//                 constraint.setUserConstraint("CONFIDENTIAL");
//                 SecurityCollection collection = new SecurityCollection();
//                 collection.addPattern("/*");
//                 constraint.addCollection(collection);
//                 context.addConstraint(constraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(createStandardConnector()); // 添加http
//        return tomcat;
//
//
//    }
//
//    // 配置http
//    private Connector createStandardConnector() {
//        // 默认协议为org.apache.coyote.http11.Http11NioProtocol
//        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//        connector.setSecure(false);
//        connector.setScheme("http");
//        connector.setPort(80);
//        connector.setRedirectPort(443); // 当http重定向到https时的https端口号
//        return connector;
//    }
//
//
//    //这里设置默认端口为443，即https的，如果这里不设置，会https和http争夺80端口
//    @Override
//    public void customize(TomcatServletWebServerFactory factory) {
//        factory.setPort(443);
//    }
}


