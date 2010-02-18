package org.kompiro.bookstore.books.internal.service;

import java.util.ArrayList;
import java.util.List;

import org.kompiro.bookstore.books.internal.model.MockBook;
import org.kompiro.bookstore.books.model.Book;
import org.kompiro.bookstore.books.service.BookService;

public class MockBookService implements BookService{

	private List<Book> books = new ArrayList<Book>();
	
	public MockBookService() {
		register("ねずみの本","こんぴろ",500);
		register("ねこの本","こんぴろ",200);
		register("いぬの本","こんぴろ",800);
	}

	public List<Book> find(String name) {
		return books;
	}

	private Book create(String name, String author, int price) {
		return new MockBook(name,author,price);
	}

	public Book register(String name, String author, int price) {
		Book result = create(name,author,price);
		books.add(result);
		return result;
	}
	
	public String getServiceName() {
		return getClass().getSimpleName();
	}


}
