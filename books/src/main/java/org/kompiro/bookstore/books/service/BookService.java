package org.kompiro.bookstore.books.service;

import java.util.List;

import org.kompiro.bookstore.books.model.Book;

public interface BookService {

	public String getServiceName();
	
	public List<? extends Book> find(String name);
	
	public Book register(String name, String author, int price);
	
}
