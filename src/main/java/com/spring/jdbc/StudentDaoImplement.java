package com.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.enteties.Student;


public class StudentDaoImplement implements StudentDao{

	
  private JdbcTemplate jdbcTemplate;	
  
	public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
	public int insert(Student student) {
		// TODO Auto-generated method stub
		 String q="insert into student(id,name,city) values(?,?,?)";
	       int result= this.jdbcTemplate.update(q,student.getId(),student.getName(),student.getCity());
		return result;
	}

}
