package com.cwh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cwh.entity.Category;

public interface ICategoryService
{
	public Page<Category> getAllCategories(Pageable pageable);
	public Category getCategoryById(Long id);
	public Category createCategory(Category category);
	public Category updateCategoryById(Long id, Category categoryDetails);
	public String deleteCategoryById(Long id);
}
