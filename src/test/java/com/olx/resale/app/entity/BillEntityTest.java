//package com.olx.resale.app.entity;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@Slf4j
//public class BillEntityTest {
//
//    private BillEntity bill;
//
//    @BeforeEach
//    public void setUp(){
//        bill = new BillEntity();
//        bill.setId(1L);
//        bill.setCustomerId(101L);
//        bill.setCustomerName("Ajay");
//        bill.setCustomerType("Regular");
//        bill.setGstNo("GST12345");
//        bill.setDeliveryAddress("111 BTM Layout");
//        bill.setCompanyName("HCLTech");
//        bill.setProductId(10L);
//        bill.setProductName("Laptop");
//        bill.setQuantity(1L);
//        bill.setProductPrice(30000.0);
//        bill.setDiscountPrice(3000.0);
//        bill.setDeliveryPrice(200.0);
//        bill.setTaxableAmount(20000.0);
//        bill.setGstTaxSlab(18.0);
//        bill.setGstPrice(5000.0);
//        bill.setCgst(4000.0);
//        bill.setSgst(4000.0);
//        bill.setIgst(0.0);
//        bill.setTotalPrice(38000.0);
//        bill.setGrandTotal(38500.0);
//        bill.setStatus("Pending");
//    }
//
//    @Test
//    public void testBillEntity(){
//        log.info("Testing BillEntity");
//        assertEquals(1L, bill.getId());
//        assertEquals(101L, bill.getCustomerId());
//        assertEquals("Ajay", bill.getCustomerName());
//        assertEquals("Regular", bill.getCustomerType());
//        assertEquals("GST12345", bill.getGstNo());
//        assertEquals("111 BTM Layout", bill.getDeliveryAddress());
//        assertEquals("HCLTech", bill.getCompanyName());
//        assertEquals(10L, bill.getProductId());
//        assertEquals("Laptop", bill.getProductName()); 
//        assertEquals(1L, bill.getQuantity());
//        assertEquals(30000.0, bill.getProductPrice());
//        assertEquals(3000.0, bill.getDiscountPrice());
//        assertEquals(200.0, bill.getDeliveryPrice());
//        assertEquals(20000.0, bill.getTaxableAmount());
//        assertEquals(18.0, bill.getGstTaxSlab());
//        assertEquals(5000.0, bill.getGstPrice());
//        assertEquals(4000.0, bill.getCgst());
//        assertEquals(4000.0, bill.getSgst());
//        assertEquals(0.0, bill.getIgst());
//        assertEquals(38000.0, bill.getTotalPrice());
//        assertEquals(38500.0, bill.getGrandTotal());
//        assertEquals("Pending", bill.getStatus());
//        log.info("Completed the BillEntity");
//    }
//
//}
