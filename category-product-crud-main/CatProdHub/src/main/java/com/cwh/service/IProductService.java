package com.cwh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cwh.entity.Product;

public interface IProductService 
{
	public Page<Product> getAllProducts(Pageable pageable);
	public Product getProductById(Long id);
	public Product createProduct(Product product);
	public Product updateProductById(Long id, Product productDetails);
	public String deleteProductById(Long id);
}
