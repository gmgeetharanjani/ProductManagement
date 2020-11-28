package com.geetha.springdemo.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.geetha.springdemo.entity.Product;
import com.geetha.springdemo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	// autowire ProductService
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable int productId) {
		Product theProduct =  productService.getProduct(productId);
		if(theProduct == null) {
			throw new ProductNotFoundException("Product not found with Id - " + productId);
		}
		return theProduct;
		
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product theProduct) {
		theProduct.setId(0);
		productService.saveProduct(theProduct);
		return theProduct;
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product theProduct) {
		productService.saveProduct(theProduct);
		return theProduct;
	}
	
	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		Product theProduct = productService.getProduct(productId);
		
		if(theProduct == null) {
			throw new ProductNotFoundException("Product not found with Id - " + productId);
		}
		productService.deleteProduct(productId);
		return "Deleted product with Id - " + productId;
	}

}
