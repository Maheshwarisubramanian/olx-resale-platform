package com.olx.resale.app.controller;

import com.olx.resale.app.entity.Product;
import com.olx.resale.app.exception.InvalidProductException;
import com.olx.resale.app.payload.ApiResponse;
import com.olx.resale.app.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.olx.resale.app.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;


@Tag(name="3. Product Controller")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	private boolean isInvalidProduct(Product product) {
		return false;
	}
	

	@Operation(summary = "POST operation for add the product  ", description = "It is used for seller to add the product.")
	@PreAuthorize("hasRole('SELLER')")
	@PostMapping("/addProduct/{customer_id}")
	public ResponseEntity<ApiResponse<Product>> addProduct(@PathVariable Long customer_id,
			@RequestBody Product product) {
		log.info("Request received to add product: {}", product);
		try {
			Product savedProduct = productService.saveProduct(customer_id,product);
			log.info("Product added successfully: {}", savedProduct);
			ApiResponse<Product> response = new ApiResponse<>("Product added successfully", savedProduct);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Error occurred while adding product: {}", product, e);
			return ResponseEntity.internalServerError().build();
		}

	}

	@Operation(summary = "GET operation for getting product details", description = "It is used to getting product details by product id.")
	@GetMapping("/getProductById/{product_id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
		log.info("Request received to get product by id: {}", product_id);
		Optional<Product> product = productService.getProductById(product_id);
		System.out.print(product_id);

		if (product.isEmpty()) {
			log.warn("Product not found with id: {}", product_id);
			throw new ProductNotFoundException("Product id: " + product_id +" is not available. ");
		}
		log.info("Product retrieved successfully: {}", product.get());
		return ResponseEntity.ok(product.get());

	}

	
	@Operation(summary = "GET operation for getting all available product  ", description = "It is used to getting all available product ")
	@GetMapping("/showAllProduct")
	public ResponseEntity<List<Product>> getAllProducts() {
		log.info("Request received to fetch all products");
		List<Product> products = productService.getAllProducts();
		if (products.isEmpty()) {
			log.warn("No products found");
			throw new ProductNotFoundException("No Products found");
		}
		log.info("Successfully fetched {} products", products.size());
		return ResponseEntity.ok(products);

	}

	
	@Operation(summary = "DELETE operation for delete the product ", description = "It is used for delete the product by product id. ")
	@PreAuthorize("hasRole('SELLER')")
	@DeleteMapping("/deleteProductById/{product_id}")
	public ResponseEntity<ApiResponse<String>> deleteProductById(@PathVariable Long product_id) {
		log.info("Request received to delete product by id: {}", product_id);
		Optional<Product> product = productService.getProductById(product_id);
		if (product.isEmpty()) {
			log.warn("Product not found with id: {}", product_id);
			throw new ProductNotFoundException("Product not found with id: " + product_id);
		}
		productService.deleteProduct(product_id);
		log.info("Product deleted successfully with id: {}", product_id);
		ApiResponse<String> response = new ApiResponse<>("Product id : "+ product_id +" has been deleted successfully ");
		return ResponseEntity.ok(response);
	}

	
	@Operation(summary = "PUT operation for update the product  ", description = "It is used for update the product by product id")
	@PreAuthorize("hasRole('SELLER')")
	@PutMapping("/updateProdcutById/{product_id}")
	public ResponseEntity<ApiResponse<Product>> updateProductById(@PathVariable Long product_id,
			@RequestBody Product updatedProduct) {
		log.info("Request received to update product by id: {}", product_id);
		Optional<Product> optionalProduct = productService.getProductById(product_id);
		if (optionalProduct.isEmpty()) {
			log.warn("Product not found with id: {}", product_id);
			throw new ProductNotFoundException("Product id : " +product_id + " is not found." );
		}
		if (isInvalidProduct(updatedProduct)) {
			log.warn("Invalid product details provided for product id: {}", product_id);
			throw new InvalidProductException("Invalid product details");
		}
		Product product = optionalProduct.get();
		product.setProductName(updatedProduct.getProductName());
		product.setProductPrice(updatedProduct.getProductPrice());
		product.setProductLocation(updatedProduct.getProductLocation());
		product.setLatitude(updatedProduct.getLatitude());
		product.setLongitude(updatedProduct.getLongitude());
		product.setStatus(updatedProduct.getStatus());
		product.setMfgDate(updatedProduct.getMfgDate());
		product.setExpiryDate(updatedProduct.getExpiryDate());
		product.setPostingDate(updatedProduct.getPostingDate());
		product.setOwner(updatedProduct.getOwner());
		product.setDescription(updatedProduct.getDescription());
		product.setColor(updatedProduct.getColor());
		product.setCategory(updatedProduct.getCategory());
		product.setSubcategory(updatedProduct.getSubcategory());

		Product savedProduct = productService.updateProduct(product);
		log.info("Product updated successfully: {}", savedProduct);
		ApiResponse<Product> response = new ApiResponse<>("Product id : " +product_id + " is updated successfully." , savedProduct);
		return ResponseEntity.ok(response);
	}
	
	
	@Operation(summary = "GET operation for searching product  ", description = "It is used for search the product by product name , category or subcategory.")
	@GetMapping("/searchProduct")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) String category,
			@RequestParam(required = false) String subcategory, @RequestParam(required = false) String productName) {
		log.info("Request received to search products with category: {}, subcategory: {}, productName: {}", category, subcategory, productName);
		List<Product> products = productService.searchProducts(category, subcategory, productName);
		log.info("Found {} products for the search criteria", products.size());
		return ResponseEntity.ok(products);
	}


	@Operation(summary = "GET operation for getting all newest product  ", description = "It is used for getting newest product ")
	@GetMapping("/getAllNewestProduct")
	public ResponseEntity<List<Product>> getAllNewestProduct() {
		log.info("Request received to fetch newest products");
		List<Product> products = productService.getNewestProducts();
		log.info("Successfully fetched {} newest products", products.size());
		return ResponseEntity.ok(products);
	}
}
