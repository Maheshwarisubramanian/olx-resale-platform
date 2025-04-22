//package com.olx.resale.app.service;
//
//import com.olx.resale.app.entity.BillEntity;
//import com.olx.resale.app.entity.TransactionEntity;
//import com.olx.resale.app.repository.TransactionRepository;
//import com.olx.resale.app.service.impl.BillServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//@Slf4j
//@ExtendWith(MockitoExtension.class)
//public class BillServiceImplTest {
//
//    @Mock
//    private TransactionRepository transactionRepository;
//
//    @InjectMocks
//    private BillServiceImpl billService;
//
//    private TransactionEntity transaction;
//
//    @BeforeEach
//    public void setUp(){
//        log.info("Setting up test data");
//        transaction = new TransactionEntity();
//        transaction.setId(1L);
//        transaction.setCustomerId(101L);
//        transaction.setCustomerName("Ajay");
//        transaction.setCustomerType("Regular");
//        transaction.setProductId(202L);
//        transaction.setProductName("Laptop");
//        transaction.setProductPrice(50000.0);
//        transaction.setDeliveryPrice(200.0);
//        transaction.setGstTaxSlab(18.0);
//        transaction.setGstPrice(8100.0);
//        transaction.setTotalPrice(53100.0);
//        transaction.setStatus("Pending");
//        log.info("Test data setup completed");
//    }
//
//    @Test
//    public void testGenerateBillTransactionById() {
//        log.info("Starting testGenerateBillTransactionById");
//        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
//
//        BillEntity bill = billService.generateBillTransactionById(1L);
//
//        assertNotNull(bill);
//        assertEquals(101L, bill.getCustomerId());
//        assertEquals("Ajay", bill.getCustomerName());
//        assertEquals("Regular", bill.getCustomerType());
//        assertEquals(202L, bill.getProductId());
//        assertEquals("Laptop", bill.getProductName());
//        assertEquals(50000.0, bill.getProductPrice());
//        assertEquals(200.0, bill.getDeliveryPrice());
//        assertEquals(18.0, bill.getGstTaxSlab());
//        assertEquals(8100.0, bill.getGstPrice());
//        assertEquals(53100.0, bill.getTotalPrice());
//        assertEquals("Pending", bill.getStatus());
//
//        verify(transactionRepository, times(1)).findById(1L);
//        log.info("testGenerateBillTransactionById completed");
//    }
//}
