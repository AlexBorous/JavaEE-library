package com.alex.library.repository;

import java.util.List;

import com.alex.library.model.Book;

public interface BookRepo {

	Book getBookById(Long id);

	Book getBookByTitle(String title);

	Book saveBook(Book b);

	Book updateBook(Book b);

	void deleteBook(Long b);
	
	List<Book> getAuthorBooks(String author);
}
