package org.best.alpha.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.best.alpha.entity.po.User;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:36
 * @description:
 **/
@Configuration
@ComponentScan(basePackages = {"org.best.alpha"})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class ServiceConfig {

    @Value("${jdbc.username}")
    private String JDBC_USERNAME;
    @Value("${jdbc.password}")
    private String JDBC_PASSWORD;
    @Value("${jdbc.driverClassName}")
    private String JDBC_DRIVER_CLASS_NAME;
    @Value("${jdbc.url}")
    private String JDBC_URL;

    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(JDBC_USERNAME);
        druidDataSource.setPassword(JDBC_PASSWORD);
        druidDataSource.setUrl(JDBC_URL);
        druidDataSource.setDriverClassName(JDBC_DRIVER_CLASS_NAME);
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("org.best.alpha.entity");
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean().getObject());
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
