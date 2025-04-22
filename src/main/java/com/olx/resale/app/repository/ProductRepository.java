

package com.olx.resale.app.repository;

import com.olx.resale.app.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findBySubcategory(String subcategory);
//    List<Product> findByCategoryAndSubcategory(String category, String subcategory);
//    List<Product> findByProductLocation(String productLocation); // Correct property name
//    List<Product> findByCategoryAndSubcategoryAndProductLocation(String category, String subcategory, String productLocation);
//
    List<Product> findByProductName(String productName);


//    List<Product> findByCategory(String category, Sort sort);
//    List<Product> findBySubcategory(String subcategory, Sort sort);
//    List<Product> findByProductName(String productName, Sort sort);
    List<Product> findAll(Sort sort);
//    List<Product> findByCategoryAndSubcategory(String category, String subcategory, Sort sort);





}


