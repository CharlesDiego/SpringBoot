package com.charlesSpring.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.charlesSpring.course.entities.Category;
import com.charlesSpring.course.repositories.CategoryRepository;

@Component
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj=  repository.findById(id);
		return obj.get();
	}

}
