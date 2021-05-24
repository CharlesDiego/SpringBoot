package com.charlesSpring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlesSpring.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
