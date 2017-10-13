package com.zz.test;

import java.sql.Connection;

import javax.activation.DataSource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.PreparedStatement;
import com.zz.model.User;
import com.zz.service.UserService;

public class test1_spring_hibernate_intergrate {

	
	@Test
	public void test(){
	
		
		
	ApplicationContext context=new  ClassPathXmlApplicationContext("applicationContext.xml");
		
	//测试配置成功没
	System.out.println("测试查询");
	
		     SessionFactory sessionFactory=(SessionFactory) context.getBean("mySessionFactory");
	      Session session=(Session) sessionFactory.openSession();
	      
	  
	      User user=  (User) session.get(User.class, 2);
	        System.out.println(user);
	        
	        
	    //增加
	        System.out.println("所有数据"); 
	        UserService userService=  (UserService) context.getBean("userService");
	      
	}
}
