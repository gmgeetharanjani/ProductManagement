package com.geetha.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geetha.springdemo.dao.ProductDAO;
import com.geetha.springdemo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	// need to inject customer dao
	@Autowired
	private ProductDAO customerDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return customerDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {

		customerDAO.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		return customerDAO.getProduct(theId);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		
		customerDAO.deleteProduct(theId);
	}
}





