package com.kjcspring.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages="com.kjcspring.dao")
public class MybatisConfig {
	
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("kjc.kjcspring.model");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
        
        return sqlSessionFactory.getObject();
    }
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
