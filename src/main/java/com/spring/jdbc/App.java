package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.enteties.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        Student student=new Student();
        student.setId(36);
        student.setName("Hellloo");
        student.setCity("Everyone"); 
       System.out.println("no of record inserted"+studentDao.insert(student));
        
    }
}
