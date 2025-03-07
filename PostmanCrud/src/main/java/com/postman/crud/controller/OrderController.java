package com.postman.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postman.crud.dao.OrderRepo;
import com.postman.crud.entities.Order;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@PostMapping
	public Order  SaveOrder(@RequestBody Order order){
		return orderRepo.save(order);
	}
	@GetMapping
	public List<Order> getOrder() {
			return orderRepo.findAll(Sort.by(Sort.Order.desc("date")));
	}
}
