package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.AppConfig;
import com.app.model.Employee;

public class ClientApp {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Employee  employee=context.getBean("employee",Employee.class);
		System.out.println(employee);
		
	}
}
