package com.charlesSpring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlesSpring.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
