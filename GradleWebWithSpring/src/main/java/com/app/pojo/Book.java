package com.app.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	private String bookIsbn;
	private String bookName;
	private String authName;
	private String authEmail;
	private Double bookPrice;
	
	
	public String getBookIsbn() {
		return bookIsbn;
	}


	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthName() {
		return authName;
	}


	public void setAuthName(String authName) {
		this.authName = authName;
	}


	public String getAuthEmail() {
		return authEmail;
	}


	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}


	public Double getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}


	@Override
	public String toString() {
		return "Book [bookIsbn=" + bookIsbn + ", bookName=" + bookName + ", authName=" + authName + ", authEmail="
				+ authEmail + ", bookPrice=" + bookPrice + "]";
	}
	
}
