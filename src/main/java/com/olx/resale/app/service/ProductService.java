package com.olx.resale.app.service;

import com.olx.resale.app.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Long id , Product product);
    Product updateProduct( Product product);
    Optional<Product> getProductById(Long product_id);
    List<Product> getAllProducts();
    void deleteProduct(Long product_id);
    List<Product> searchByCategory(String category);
    List<Product> searchBySubcategory(String subcategory);
//    List<Product> searchByCategoryAndSubcategory(String category, String subcategory);
//    List<Product> searchByLocation(String location);
    List<Product> searchProducts(String category, String subcategory, String productName);
    List<Product> getNewestProducts();
    boolean existsById(Long id);
}