package com.postman.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postman.crud.entities.Book;
import com.postman.crud.entities.Order;
import com.postman.crud.service.BookService;

@RestController
//@CrossOrigin(origins = "http://localhost:8082")
@CrossOrigin("*")
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping
	public Page<Book> getAllBooks(
			@RequestParam(defaultValue ="0") int page,
			@RequestParam(defaultValue ="5") int size
			){
		return bookService.getAllBooks(page,size);
	}
	 @GetMapping("/{id}")
	    public ResponseEntity<Optional<Book>> getBook(@PathVariable Integer id) {
	     if(bookService.getBookById(id).isEmpty())
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 return ResponseEntity.of(Optional.of(bookService.getBookById(id)));
	}
	
	@PutMapping("{id}/{title}/{author}")
	public Book updateBook (@PathVariable int id, @PathVariable String title, @PathVariable String author) {
		return bookService.updateBook(bookService.getBookById(id),title,author);
	}
	//can also use Exception handling
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable int id) {
		if(bookService.getBookById(id).isEmpty())
			return "No Book by this id";
		bookService.deleteBook(id);
		return "deleted";
	}
}
