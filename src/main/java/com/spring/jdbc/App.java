package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
      //  ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//      Student student=new Student();
//        student.setId(36);
//        student.setName("Hii");
//        student.setCity("EveryBody");
//        System.out.println("Data enter...."+studentDao.insert(student));
        List<Student> students=studentDao.getStudents();
        for(Student i:students)
        {
        	System.out.println(i);
        	
        }
      
       
        
    }
}
