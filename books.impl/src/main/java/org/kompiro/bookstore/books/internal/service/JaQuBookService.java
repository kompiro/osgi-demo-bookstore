package org.kompiro.bookstore.books.internal.service;

import java.io.File;
import java.util.List;

import org.h2.jaqu.Db;
import org.kompiro.bookstore.books.internal.model.DBBook;
import org.kompiro.bookstore.books.model.Book;
import org.kompiro.bookstore.books.service.BookService;
import org.kompiro.bookstore.books.service.BookService2;

public class JaQuBookService implements BookService,BookService2{

	private static Db db;
	static{
		try {
			String tempFile = File.createTempFile("book_service", "db").getAbsolutePath();
			db = Db.open("jdbc:h2:" + tempFile, "sa", "sa");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public List<DBBook> find(String name) {
		DBBook book = new DBBook();
		if(name == null || name.equals("")){
			return db.from(book).select();
		}
		String wrappedLike = "%" + name + "%";
		return db.from(book).where(book.name).like(wrappedLike).select();
	}

	private Book create(String name, String author, int price) {
		DBBook book = new DBBook(name,author,price);
		db.insert(book);
		return book;
	}

	public Book register(String name, String author, int price) {
		Book result = create(name,author,price);
		return result;
	}
	
	static void setDb(String url) {
		if(JaQuBookService.db != null){
			JaQuBookService.db.close();
		}
		JaQuBookService.db = Db.open(url, "sa", "");
	}

	public String getServiceName() {
		return getClass().getSimpleName();
	}

}
