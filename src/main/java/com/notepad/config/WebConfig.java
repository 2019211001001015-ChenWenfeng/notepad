package com.notepad.config;


import com.notepad.pojo.AppConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 资源映射配置
     *
     * @param registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addResourceHandler(AppConstant.FILE_MAP)
                .addResourceLocations("file:" + AppConstant.FILE_PATH);
    }
}
