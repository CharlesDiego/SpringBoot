package com.charlesSpring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlesSpring.course.entities.OrdemItem;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, Long>{

}
