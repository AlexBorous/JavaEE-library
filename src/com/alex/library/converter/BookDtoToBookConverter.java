package com.alex.library.converter;

import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.Stateless;

import com.alex.library.dto.BookDto;
import com.alex.library.model.Book;

@Stateless
public class BookDtoToBookConverter {
	public Book convertNew(BookDto bookDto) {
		Book book = new Book();
		int randomNum = ThreadLocalRandom.current().nextInt(0, 5000 + 1);
		book.setId((long) randomNum);
		book.setAuthor(bookDto.getAuthor());
		book.setDescription(bookDto.getDescription());
		book.setTitle(bookDto.getTitle());
		return book;
	}
	
	public Book convertUpdate(Book book , BookDto bookDto) {
		book.setAuthor(bookDto.getAuthor());
		book.setDescription(bookDto.getDescription());
		book.setTitle(bookDto.getTitle());
		return book;
	}
}
