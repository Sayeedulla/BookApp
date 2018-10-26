package com.mindtree.BookManagement.Entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="book")
public class Book {
	int book_Id;
	String book_name;
	String author_name;
	String publisher;
	String category;
	int price;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int book_Id, String book_name, String author_name, String publisher, String category, int price) {
		super();
		this.book_Id = book_Id;
		this.book_name = book_name;
		this.author_name = author_name;
		this.publisher = publisher;
		this.category = category;
		this.price = price;
	}
	@Id
	@Column(name="book_id")
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
