package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.Exception.DataAccessException;
import com.product.persistance.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public Product deleteProduct(int id);
	public Product updateProduct(int id , Product product);
	public List<Product> getAll()throws DataAccessException;
	public Product getById(int id);
}
