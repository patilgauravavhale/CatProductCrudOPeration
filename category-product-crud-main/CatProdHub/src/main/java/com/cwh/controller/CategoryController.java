package com.cwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwh.entity.Category;
import com.cwh.service.ICategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController 
{
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/categories")
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int size) 
	{
		Pageable pageable = PageRequest.of(page, size);
		return categoryService.getAllCategories(pageable);
	}
	
	@PostMapping("/categories/add")
	public Category createCategory(@RequestBody Category category)
	{
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/categories/{id}")
	public Category getCategoryById(@PathVariable Long id)
	{
		 Category category = categoryService.getCategoryById(id);
		 return category ;
	}
	
	@PutMapping("/categories/{id}")
	public Category updateCategoryById(@PathVariable Long id, @RequestBody Category categoryDetails)
	{
		return categoryService.updateCategoryById(id, categoryDetails);
	}
	
	@DeleteMapping("/categories/{id}")
	public String deleteCategoryById(@PathVariable Long id)
	{
		return categoryService.deleteCategoryById(id);
	}
}
