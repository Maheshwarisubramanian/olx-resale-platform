//package com.olx.resale.app.entity;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@Slf4j
//public class TransactionEntityTest {
//
//    private TransactionEntity transaction;
//
//    @BeforeEach
//    public void setUp() {
//        transaction = new TransactionEntity();
//        transaction.setId(1L);
//        transaction.setCustomerId(111L);
//        transaction.setCustomerName("Ajay");
//        transaction.setCustomerType("Regular");
//        transaction.setProductId(222L);
//        transaction.setProductName("Laptop");
//        transaction.setProductPrice(50000.0);
//        transaction.setDeliveryPrice(200.0);
//        transaction.setGstTaxSlab(18.0);
//        transaction.setGstPrice(8100.0);
//        transaction.setTotalPrice(53100.0);
//        transaction.setPaymentMode("Credit Card");
//        transaction.setReferenceNumber(1234567890.0);
//        transaction.setPaymentTime("10:00 AM");
//        transaction.setStatus("Pending");
//        transaction.setDeliveryAddress("111 BTM Layout");
//    }
//
//    @Test
//    public void testTransactionEntity() {
//        log.info("Testing TransactionEntity");
//        assertNotNull(transaction);
//        log.info("Testing getId()");
//        assertEquals(1L, transaction.getId());
//        assertEquals(111L, transaction.getCustomerId());
//        log.info("Testing getCustomerName()");
//        assertEquals("Ajay", transaction.getCustomerName());
//        log.info("Testing getCustomerType()");
//        assertEquals("Regular", transaction.getCustomerType());
//        assertEquals(222L, transaction.getProductId());
//        assertEquals("Laptop", transaction.getProductName());
//        log.info("Testing getProductPrice()");
//        assertEquals(50000.0, transaction.getProductPrice());
//        log.info("Testing getDeliveryPrice()");
//        assertEquals(200.0, transaction.getDeliveryPrice());
//        assertEquals(18.0, transaction.getGstTaxSlab());
//        assertEquals(8100.0, transaction.getGstPrice());
//        assertEquals(53100.0, transaction.getTotalPrice());
//        assertEquals("Credit Card", transaction.getPaymentMode());
//        assertEquals(1234567890.0, transaction.getReferenceNumber());
//        assertEquals("10:00 AM", transaction.getPaymentTime());
//        assertEquals("Pending", transaction.getStatus());
//        assertEquals("111 BTM Layout", transaction.getDeliveryAddress());
//        log.info("TransactionEntity Attributes Test Completed.");
//    }
//
//}
