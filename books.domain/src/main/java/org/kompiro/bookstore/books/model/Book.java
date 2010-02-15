package org.kompiro.bookstore.books.model;

public class Book {

	public String name;
	public String author;
	public Integer price;
	
	public Book(){
		
	}
	
	public Book(String name, String author, int price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
}
