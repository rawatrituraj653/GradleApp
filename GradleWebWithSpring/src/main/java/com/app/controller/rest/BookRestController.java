package com.app.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Book;

@RestController
public class BookRestController {
	
	public BookRestController() {
		System.out.println("BookRestController::called");
	}

	@GetMapping("/getBook")
	public ResponseEntity<Book> getBook(){
			System.out.println("getBook():: called");
			Book book=new Book();
			book.setBookIsbn("JPA231");
			book.setBookName("Hibernate with jpa");
			book.setAuthName("Gaven King");
			book.setAuthEmail("gaven123@yahoo.com");
			book.setBookPrice(699.80);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
}
