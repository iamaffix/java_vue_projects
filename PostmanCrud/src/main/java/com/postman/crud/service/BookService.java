package com.postman.crud.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.postman.crud.dao.BookRepo;
import com.postman.crud.entities.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public ResponseEntity<?> saveBook(Book book) {
//		return bookRepo.save(book);
		List<Book> li = bookRepo.findAll();
		for(Book b:li) {
			if(b.getTitle().equals(book.getTitle()))
				return ResponseEntity.badRequest().body("A book by this Title already exists: "+book.getTitle());
		}
		return ResponseEntity.ok(bookRepo.save(book));
	}
	
	public Page<Book> getAllBooks(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size); 
        Page<Book> all = bookRepo.findAll(pageable);
        return all;
    
    }
	
	public Book updateBook(Optional<Book> opt, String title, String author) {
		Book bookTemp = opt.get();
		bookTemp.setTitle(title);
		bookTemp.setAuthor(author);
		return bookRepo.save(bookTemp);
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
	
	public Optional<Book> getBookById(Integer id){
		return bookRepo.findById(id);
	}
}
