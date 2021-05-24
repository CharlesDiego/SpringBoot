package com.charlesSpring.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.charlesSpring.course.entities.Product;
import com.charlesSpring.course.repositories.ProductRepository;

@Component
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj=  repository.findById(id);
		return obj.get();
	}

}
