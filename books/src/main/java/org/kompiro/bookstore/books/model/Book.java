package org.kompiro.bookstore.books.model;

public class Book {

	private String name;
	private String author;
	private int price;
	
	public Book(){
		
	}
	
	public Book(String name, String author, int price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
