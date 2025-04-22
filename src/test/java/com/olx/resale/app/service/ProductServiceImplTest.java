//package com.olx.resale.app.service;
//
//import com.olx.resale.app.entity.Product;
//import com.olx.resale.app.repository.ProductRepository;
//import com.olx.resale.app.service.impl.ProductServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@Slf4j
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceImplTest {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductServiceImpl productService;
//
//    private Product product;
//
//    @BeforeEach
//    public void setUp(){
//        log.info("Setting up test data");
//        product = new Product();
//        product.setId(1L);
//        product.setProductName("Laptop");
//        product.setPrice(1000.0);
//        product.setProductLocation("Bengaluru");
//        product.setLatitude(12.9716);
//        product.setLongitude(77.5946);
//        product.setStatus("Available");
//        product.setMfgDate(new Date());
//        product.setExpiryDate(new Date());
//        product.setPostingDate(new Date());
//        product.setOwner("Ajay");
//        product.setDescription("A gaming laptop");
//        product.setColor("Black");
//        product.setCategory("Electronics");
//        product.setSubcategory("Computers");
//        product.setDiscount("10%");
//        product.setCustomerId(1L);
//        product.setCustomerName("Ajay");
//        product.setCustomerType("Regular");
//        log.info("Test data setup completed");
//    }
//
//    @Test
//    public void testSaveProduct() {
//        log.info("Starting testSaveProduct");
//        when(productRepository.save(product)).thenReturn(product);
//
//        Product savedProduct = productService.saveProduct(product);
//
//        assertNotNull(savedProduct);
//        assertEquals("Laptop", savedProduct.getProductName());
//        assertEquals("Bengaluru", savedProduct.getProductLocation());
//        assertEquals("Available", savedProduct.getStatus());
//        assertEquals("Black", savedProduct.getColor());
//        assertEquals("Electronics", savedProduct.getCategory());
//        assertEquals("Computers", savedProduct.getSubcategory());
//
//        verify(productRepository, times(1)).save(product);
//        log.info("testSaveProduct completed");
//    }
//
//    @Test
//    public void testGetProductById() {
//        log.info("Starting testGetProductById");
//        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
//
//        Optional<Product> foundProduct = productService.getProductById(1L);
//
//        assertTrue(foundProduct.isPresent());
//        assertEquals("Laptop", foundProduct.get().getProductName());
//        assertEquals("Bengaluru", foundProduct.get().getProductLocation());
//        assertEquals("Available", foundProduct.get().getStatus());
//        assertEquals("Black", foundProduct.get().getColor());
//        assertEquals("Electronics", foundProduct.get().getCategory());
//        assertEquals("Computers", foundProduct.get().getSubcategory());
//
//        verify(productRepository, times(1)).findById(1L);
//        log.info("testGetProductById completed");
//    }
//
//    @Test
//    public void testGetAllProducts() {
//        log.info("Starting testGetAllProducts");
//        List<Product> products = Arrays.asList(product);
//        when(productRepository.findAll()).thenReturn(products);
//
//        List<Product> allProducts = productService.getAllProducts();
//
//        assertNotNull(allProducts);
//        assertEquals(1, allProducts.size());
//        verify(productRepository, times(1)).findAll();
//        log.info("testGetAllProducts completed");
//    }
//
//    @Test
//    public void testSearchByCategory() {
//        log.info("Starting testSearchByCategory");
//        List<Product> products = Arrays.asList(product);
//        when(productRepository.findByCategory("Electronics")).thenReturn(products);
//
//        List<Product> foundProducts = productService.searchByCategory("Electronics");
//
//        assertNotNull(foundProducts);
//        assertEquals(1, foundProducts.size());
//        verify(productRepository, times(1)).findByCategory("Electronics");
//        log.info("testSearchByCategory completed");
//    }
//
//    @Test
//    public void testSearchBySubcategory() {
//        log.info("Starting testSearchBySubcategory");
//        List<Product> products = Arrays.asList(product);
//        when(productRepository.findBySubcategory("Computers")).thenReturn(products);
//
//        List<Product> foundProducts = productService.searchBySubcategory("Computers");
//
//        assertNotNull(foundProducts);
//        assertEquals(1, foundProducts.size());
//        verify(productRepository, times(1)).findBySubcategory("Computers");
//        log.info("testSearchBySubcategory completed");
//    }
//}
