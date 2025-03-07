package com.postman.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postman.crud.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
	
}
