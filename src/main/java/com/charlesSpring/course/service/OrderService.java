package com.charlesSpring.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.charlesSpring.course.entities.Order;
import com.charlesSpring.course.repositories.OrderRepository;

@Component
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj=  repository.findById(id);
		return obj.get();
	}

}
