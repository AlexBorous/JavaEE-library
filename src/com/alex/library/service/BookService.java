package com.alex.library.service;

import java.util.List;

import com.alex.library.dto.BookDto;
import com.alex.library.model.Book;

public interface BookService {
	Book getBookById(Long id);

	Book getBookByTitle(String title);

	List<Book> getAuthorBooks(String author);

	boolean deleteBook(Long id);

	Book addBook(BookDto bookDto);

	Book updateBook(Long id,BookDto bookDto);
}
