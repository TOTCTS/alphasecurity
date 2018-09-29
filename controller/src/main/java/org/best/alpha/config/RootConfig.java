package org.best.alpha.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:00
 * @description:
 **/
@Configuration
@ComponentScan(basePackages = {"org.best.alpha"},
        useDefaultFilters = false,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = {RestController.class, Controller.class, RestControllerAdvice.class, ControllerAdvice.class})})
public class RootConfig {

}
