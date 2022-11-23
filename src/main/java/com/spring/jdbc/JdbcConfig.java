package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc"})
public class JdbcConfig {

 @Bean("ds")	
 public DataSource getDataSource()
 {
	 DriverManagerDataSource d=new DriverManagerDataSource();
	 d.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 d.setUsername("root");
	 d.setUrl("jdbc:mysql://localhost:3306/springjdbc");
	 d.setPassword("Himanshu@2411");
	 return d;
 }
 
 @Bean("template")
 public JdbcTemplate getTemplate()
 {
	 JdbcTemplate jdbc=new JdbcTemplate();
	 jdbc.setDataSource(getDataSource());
	 return jdbc;
 }
 
// @Bean("studentDao")
// public StudentDao getStudentduo()
// {
//	 StudentDaoImplement stud=new StudentDaoImplement();
//	 stud.setJdbcTemplate(getTemplate());
//	 return stud;
// }
}
