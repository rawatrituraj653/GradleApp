package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.app.model.Employee;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

	@Autowired
	private Environment env;
	@Bean("employee")
	public Employee getEmp() {
		System.out.println(env.getProperty("app.group"));
		System.out.println(env.getProperty("app.name"));
		System.out.println(env.getProperty("app.version"));
		return new Employee(11011, "Rituraj", 50000.00, "Developer");
	}
}
