
package com.neo.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @program: springboot_mybatis_xml_multisource->DataSource1Config
 * @description: test1的配置类
 * @author: lin qx
 * @create: 2019-11-21 18:10
 **/
@Configuration
@MapperScan(basePackages = "com.neo.mapper.test1",
        sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSource1Config {

    /**
     * 配置数据源
     * @return 返回数据源
     */
    @Bean(name = "test1DataSource")
    //对应数据库
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    @Primary   //指定主数据库
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置SqlSession工厂
     * @param dataSource 数据源
     * @return  返回SqlSessionFactory对象
     * @throws Exception
     */
    @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory  //Qualifier中的value要与上面的Bean一致
    (@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置数据源的事务管理
     * @param dataSource 数据源
     * @return 数据源事务管理类
     * @throws Exception
     */
    @Bean(name = "test1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager
            (@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置SqlSession模板
     * @param sqlSessionFactory 拿到sqlSession的工厂
     * @throws Exception
     */
    @Bean(name = "test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate
            (@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
