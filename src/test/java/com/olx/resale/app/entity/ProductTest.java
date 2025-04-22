//package com.olx.resale.app.entity;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@Slf4j
//public class ProductTest {
//
//    private Product product;
//
//    @BeforeEach
//    public void setUp(){
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
//        product.setOwner("Ajay Shinde");
//        product.setDescription("A gaming laptop");
//        product.setColor("Black");
//        product.setCategory("Electronics");
//        product.setSubcategory("Computers");
//        product.setDiscount("10%");
//        product.setCustomerId(123L);
//        product.setCustomerName("Ajay");
//        product.setCustomerType("Regular");
//    }
//
//    @Test
//    public void testProductEntity(){
//        log.info("Testing Product");
//        assertNotNull(product);
//        log.info("Testing getId()");
//        assertEquals(1L, product.getId());
//        assertEquals("Laptop", product.getProductName());
//        log.info("Testing getPrice()");
//        assertEquals(1000.0, product.getPrice());
//        log.info("Testing getProductLocation()");
//        assertEquals("Bengaluru", product.getProductLocation());
//        assertEquals(12.9716, product.getLatitude());
//        assertEquals(77.5946, product.getLongitude());
//        assertEquals("Available", product.getStatus());
//        assertNotNull(product.getMfgDate());
//        assertNotNull(product.getExpiryDate());
//        assertNotNull(product.getPostingDate());
//        assertEquals("Ajay Shinde", product.getOwner());
//        log.info("Testing getDescription()");
//        assertEquals("A gaming laptop", product.getDescription());
//        log.info("Testing getColor()");
//        assertEquals("Black", product.getColor());
//        assertEquals("Electronics", product.getCategory());
//        assertEquals("Computers", product.getSubcategory());
//        assertEquals("10%", product.getDiscount());
//        assertEquals(123L, product.getCustomerId());
//        assertEquals("Ajay", product.getCustomerName());
//        assertEquals("Regular", product.getCustomerType());
//        log.info("Product Attributes Test Completed.");
//    }
//}
