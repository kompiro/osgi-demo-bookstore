package org.kompiro.bookstore.books.service;

import java.util.List;

import org.kompiro.bookstore.books.model.Book;

public interface BookService {

	public List<Book> find(String name);
	
}
