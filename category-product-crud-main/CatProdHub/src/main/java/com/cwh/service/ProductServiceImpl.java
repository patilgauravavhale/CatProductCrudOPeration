package com.cwh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cwh.entity.Product;
import com.cwh.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService
{
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) 
	{
		return productRepo.findAll(pageable);
	}

	@Override
	public Product getProductById(Long id)
	{
		return productRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found!"));
	}

	@Override
	public Product createProduct(Product product) 
	{
		return productRepo.save(product);
	}

	@Override
	public Product updateProductById(Long id, Product productDetails) 
	{
		Product product = productRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found")); 
		product.setProductName(productDetails.getProductName()); 
		product.setProductPrice(productDetails.getProductPrice());
		product.setCategory(productDetails.getCategory()); 
		return productRepo.save(product);
	}

	@Override
	public String deleteProductById(Long id)
	{
		Optional<Product> product = productRepo.findById(id);
		
		if(product.isPresent())
		{
			productRepo.deleteById(id);
			
			return id+"Product found and Deleted";
		}
		else
		{
			return id+"Product not found ! ";
		}
	}

}
