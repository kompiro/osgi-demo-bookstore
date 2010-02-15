package org.kompiro.bookstore.books.internal.model;

import org.h2.jaqu.Table;
import org.kompiro.bookstore.books.model.Book;
import static org.h2.jaqu.Define.*;

public class DBBook extends Book implements Table{

	public DBBook() {
	}
	
	public DBBook(String name, String author, int price) {
		super(name,author,price);
	}

	public void define() {
		tableName("book");
	}

}
