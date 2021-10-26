package com.alex.library.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;

import com.alex.library.converter.BookDtoToBookConverter;
import com.alex.library.dto.BookDto;
import com.alex.library.model.Book;
import com.alex.library.repository.BookRepo;

@Stateless
public class BookServiceImpl implements BookService {

	@EJB
	private BookRepo bookRepo;

	@EJB
	private BookDtoToBookConverter bookConverter;

	@Override
	public List<Book> getAuthorBooks(String author) {
		return Optional.ofNullable(bookRepo.getAuthorBooks(author))
				.orElseThrow(() -> new RuntimeException("Author: " + author + "doesnt have books"));
	}

	public Book getBookById(Long id) {
		return Optional.ofNullable(bookRepo.getBookById(id))
				.orElseThrow(() -> new RuntimeException("Book with id : " + id + " cannot be found"));
	}

	@Override
	public Book getBookByTitle(String title) {
		return Optional.ofNullable(bookRepo.getBookByTitle(title))
				.orElseThrow(() -> new RuntimeException("Book with title: " + title + " doesnt exists"));
	}

	@Override
	public Book addBook(BookDto bookDto) {
		Book book = bookConverter.convertNew(bookDto);
		return bookRepo.saveBook(book);
	}

	@Override
	public Book updateBook(Long id, BookDto bookDto) {
		Book book = Optional.ofNullable(bookRepo.getBookById(id)).orElseThrow(() -> new NotFoundException("Book could not be found"));
		book = bookConverter.convertUpdate(book, bookDto);
		return Optional.ofNullable(bookRepo.updateBook(book))
				.orElseThrow(() -> new RuntimeException("Update book error"));
	}

	@Override
	public boolean deleteBook(Long id) {
		bookRepo.deleteBook(id);
		return true;
	}
}
