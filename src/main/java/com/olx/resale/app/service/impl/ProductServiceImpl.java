package com.olx.resale.app.service.impl;

import com.olx.resale.app.entity.Product;
import com.olx.resale.app.entity.User;
import com.olx.resale.app.repository.ProductRepository;
import com.olx.resale.app.repository.UserRepository;
import com.olx.resale.app.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public Product saveProduct(Long id, Product product) {
		log.info("Attempting to save product for user with ID: {}", id);
		
		try {
			User user = userRepository.findById(id).get();
			log.info("User found: {}", user.getName());

			product.setCustomerId(id);
			product.setCustomerName(user.getName());
			product.setCustomerType(user.getRole().toString());

			Product savedProduct = productRepository.save(product);
			log.info("Product saved successfully with ID: {}", savedProduct.getId());
			return savedProduct;
		} catch (Exception e) {
			log.error("Error saving product for user with ID: {}", id, e);
			throw e;
		}
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		log.info("Attempting to update product with ID: {}", product.getId());
		try {
			Product updatedProduct = productRepository.save(product);
			log.info("Product updated successfully with ID: {}", updatedProduct.getId());
			return updatedProduct;
		} catch (Exception e) {
			log.error("Error updating product with ID: {}", product.getId(), e);
			throw e;
		}
	}

	@Override
	public Optional<Product> getProductById(Long productId) {
		log.info("Fetching product with ID: {}", productId);
		return productRepository.findById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		log.info("Fetching all products from the database");
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteProduct(Long productId) {
		log.info("Attempting to delete product with ID: {}", productId);
		try {
			productRepository.deleteById(productId);
			log.info("Product deleted successfully with ID: {}", productId);
		} catch (Exception e) {
			log.error("Error deleting product with ID: {}", productId, e);
			throw e;
		}
	}

	@Override
	public List<Product> searchByCategory(String category) {
		log.info("Searching for products by category: {}", category);
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> searchBySubcategory(String subcategory) {
		log.info("Searching for products by subcategory: {}", subcategory);
		return productRepository.findBySubcategory(subcategory);
	}

	@Override
	public List<Product> searchProducts(String category, String subcategory, String productName) {
		log.info("Searching for products with parameters - Category: {}, Subcategory: {}, Product Name: {}", category, subcategory, productName);

		if (category != null && !category.isEmpty()) {
			return productRepository.findByCategory(category);
		} else if (subcategory != null && !subcategory.isEmpty()) {
			return productRepository.findBySubcategory(subcategory);
		} else if (productName != null && !productName.isEmpty()) {
			return productRepository.findByProductName(productName);
		} else {
			return productRepository.findAll();
		}
	}

	@Override
	public List<Product> getNewestProducts() {
		log.info("Fetching newest products sorted by posting date");
		Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");
		return productRepository.findAll(sort);
	}

	@Override
	public boolean existsById(Long id) {
		log.info("Checking if product exists with ID: {}", id);
		return productRepository.existsById(id);
	}
}


	/*@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public Product saveProduct(Long id, Product product) {
		try {

			User user = userRepository.findById(id).get();

			product.setCustomerId(id);
			product.setCustomerName(user.getName());
			product.setCustomerType(user.getRole().toString());

			return productRepository.save(product);
		} catch (Exception e) {
			// Log the exception and handle it appropriately
			System.err.println("Error saving product: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		try {

			return productRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Optional<Product> getProductById(Long product_id) {
		return productRepository.findById(product_id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteProduct(Long product_id) {
		productRepository.deleteById(product_id);
	}

	@Override
	public List<Product> searchByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> searchBySubcategory(String subcategory) {
		return productRepository.findBySubcategory(subcategory);
	}
	@Override
	public List<Product> searchProducts(String category, String subcategory, String productName) {
		if (category != null && !category.isEmpty()) {
			return productRepository.findByCategory(category);
		} else if (subcategory != null && !subcategory.isEmpty()) {
			return productRepository.findBySubcategory(subcategory);
		} else if (productName != null && !productName.isEmpty()) {
			return productRepository.findByProductName(productName);
		} 
		else {
			return productRepository.findAll();
		}
	}

	@Override
	public List<Product> getNewestProducts() {
		Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");
		return productRepository.findAll(sort);
	}

	@Override
	public boolean existsById(Long id) {
		return productRepository.existsById(id);
	}
}
*/