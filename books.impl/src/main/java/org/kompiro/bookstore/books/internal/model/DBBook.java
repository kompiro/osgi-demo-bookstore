package org.kompiro.bookstore.books.internal.model;

import org.h2.jaqu.Table;
import org.kompiro.bookstore.books.model.Book;
import static org.h2.jaqu.Define.*;

public class DBBook implements Table,Book {

	public String name;
	public String author;
	public Integer price;


	public DBBook() {
	}
	
	public DBBook(String name, String author, int price) {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}


	public void define() {
		tableName("book");
	}

}
