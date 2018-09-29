package org.best.alpha.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:01
 * @description:
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.best.alpha.controller", "org.best.alpha.advice"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}


