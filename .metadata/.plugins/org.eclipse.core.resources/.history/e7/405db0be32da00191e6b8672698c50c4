package com.nit.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

	@RequestMapping("/get")
	public String getHelloMsg(Model  model) {
		model.addAttribute("msg", 
				"This is My Spring Boot With Gradle App:: "+LocalDateTime.now());	
		return "input";
	}
}
