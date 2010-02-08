package org.kompiro.bookstore.books.internal.service;

import java.util.ArrayList;
import java.util.List;

import org.kompiro.bookstore.books.model.Book;
import org.kompiro.bookstore.books.service.BookService;

public class MockBookService implements BookService{

	public List<Book> find(String name) {
		List<Book> result = new ArrayList<Book>();
		result.add(create("ねずみの本","こんぴろ",500));
		result.add(create("ねこの本","こんぴろ",200));
		result.add(create("いぬの本","こんぴろ",800));
		return result;
	}

	private Book create(String name, String author, int price) {
		return new Book(name,author,price);
	}

}
