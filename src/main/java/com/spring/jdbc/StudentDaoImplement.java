package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.RowMapperImpel;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.enteties.Student;

@Component("studentDao")
public class StudentDaoImplement implements StudentDao{

  @Autowired	
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
	public int change(Student student) {
		// TODO Auto-generated method stub
		String q="update student set name=?,city=? where id=? ";
		int result= this.jdbcTemplate.update(q,student.getName(),student.getCity(),student.getId());
		return result;
	}
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		String q="delete from student where id=?";
		int update = this.jdbcTemplate.update(q,studentId);
	return update;
	}
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		String q="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpel();
		
		Student s=this.jdbcTemplate.queryForObject(q,rowMapper,studentId);
		return s;
	}
	public List<Student> getStudents() {
		String q="select * from student";
		RowMapper<Student> rowMapper=new RowMapperImpel();
		List<Student> s=this.jdbcTemplate.query(q,new RowMapperImpel());
		return s;
	}

}
