package com.wego.web.ctx;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"com.wego.web"})
@ComponentScan(basePackages = {"com.wego.web"})
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class RootContext {
		@Bean
		public DataSource dataSource() {
			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
			hikariConfig.setJdbcUrl("jdbc:mariadb://172.168.0.121/wegodb");
			hikariConfig.setUsername("wego");
			hikariConfig.setPassword("wego");
			
			HikariDataSource dataSource =new HikariDataSource(hikariConfig);
			
			return dataSource;
		}
		@Bean
		public DataSourceTransactionManager txManager() {
			return new DataSourceTransactionManager(dataSource());
		}
	
	
}