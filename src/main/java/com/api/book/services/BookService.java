package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.controller.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	/*
	private static List<Book> list = new ArrayList<>();
	static {
		list.add(new Book(201, "c# book", "Bill Gates"));
		list.add(new Book(205, "Python book", "James Goslin"));
		list.add(new Book(207, "Art of Acting", "James Goslin"));
	}
	*/
	
	public List<Book> getAllBooks(){
		//return list;
		return (List<Book>) this.bookRepository.findAll();
	}
	
	public Book getBookById(int id) {
		Book book = null;
		try{
//			book = list.stream()
//					.filter(b-> b.getId() == id)
//					.findFirst()
//					.get();
			
			book = this.bookRepository.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	public Book addBook(Book book) {
//		list.add(book);
//		return book;
		Book result = bookRepository.save(book);
		return result;
	}
	
	public void deleteBook(int id) {
//		list = list.stream()
//		.filter(book-> book.getId() != id)
//		.collect(Collectors.toList());
		
		bookRepository.deleteById(id);
	}
	
	public void updateBook(Book book, int id) {
//		list = list.stream().map(b-> {
//			if(b.getId() == id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(id);
		bookRepository.save(book);
		
	}
	
}
