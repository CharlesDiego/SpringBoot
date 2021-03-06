package com.charlesSpring.course.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.charlesSpring.course.entities.User;
import com.charlesSpring.course.repositories.UserRepository;

@Component
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj=  repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	@Transactional
	public void delete (Long id) {
		repository.deleteById(id);
	}
	public User update (Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
	
}
