package org.best.alpha.initializer;

import org.best.alpha.config.RootConfig;
import org.best.alpha.config.ServiceConfig;
import org.best.alpha.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author: BG336672
 * @create: 2018-09-26 13:59
 * @description:
 **/
public class AlphaSecurityApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, ServiceConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
