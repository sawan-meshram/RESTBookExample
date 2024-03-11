package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

//@Controller
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
//	@RequestMapping(value="/books", method=RequestMethod.GET)
//	@ResponseBody
/*	@GetMapping("/books")
	public List<Book> getBooks() {
//		Book book = new Book(123, "Java Book","Sawan Meshram");
		return bookService.getAllBooks();
	}
*/	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
//		Book book = new Book(123, "Java Book","Sawan Meshram");
		List<Book> list = bookService.getAllBooks();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	/*
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}*/
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book =  bookService.getBookById(id);
		if(book == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(book));
	}
/*	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book  book) {
		
		return bookService.addBook(book);
	}
*/	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book  book) {
		Book b1 = null;
		try {
			b1 = bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b1));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

/*	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
	}
*/
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			bookService.deleteBook(bookId);
			//return ResponseEntity.ok().build(); //or
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
/*	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book, bookId);
		return book;
	}
*/	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		
		try {
			this.bookService.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
