package com.cwh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cwh.entity.Category;
import com.cwh.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService
{
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Page<Category> getAllCategories(Pageable pageable)
	{
		return categoryRepo.findAll(pageable);
	}
	
	@Override
	public Category getCategoryById(Long id)
	{
		return categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found!"));
	}
	
	@Override
	public Category createCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	
	@Override
	public Category updateCategoryById(Long id, Category categoryDetails)
	{
		Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found!"));
		category.setCategoryName(categoryDetails.getCategoryName());
		
		return categoryRepo.save(category);
	}
	
	@Override
	public String deleteCategoryById(Long id)
	{
		Optional<Category> category = categoryRepo.findById(id);
		
		if(category.isPresent())
		{
			categoryRepo.deleteById(id);
			
			return id+" Category found and Deleted";
		}
		else
		{
			return id+" Category not found ! ";
		}
	}
	
}
