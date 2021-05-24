package com.charlesSpring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlesSpring.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
