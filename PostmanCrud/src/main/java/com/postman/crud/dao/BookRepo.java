package com.postman.crud.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.postman.crud.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

	Page<Book> findAll(Pageable pageable);
	
}
