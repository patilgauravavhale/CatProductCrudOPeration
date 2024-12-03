package com.cwh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwh.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> 
{

}
