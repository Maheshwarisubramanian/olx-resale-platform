package com.olx.resale.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.resale.app.entity.BillEntity;
import com.olx.resale.app.entity.TransactionEntity;
import com.olx.resale.app.repository.TransactionRepository;
import com.olx.resale.app.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	private static final Logger log = LoggerFactory.getLogger(BillServiceImpl.class);
	 @Autowired
	 private TransactionRepository transactionRepository;
	
	@Override
	public BillEntity generateBillTransactionById(Long id) {
		log.info("Generating bill for Transaction ID: "+id);
		
		TransactionEntity transactionEntity = transactionRepository.findById(id).get();
		log.info("Transaction details fetched: Customer ID= "+transactionEntity.getCustomerId()+
				", Product ID= "+transactionEntity.getProductId()+", Customer Name= "+transactionEntity.getCustomerName());
		BillEntity bill=new BillEntity();
		bill.setCustomerId(transactionEntity.getCustomerId());
		bill.setProductId(transactionEntity.getProductId());
		bill.setCustomerName(transactionEntity.getCustomerName());
		bill.setCustomerType(transactionEntity.getCustomerType());
		bill.setDeliveryAddress(transactionEntity.getDeliveryAddress());
		bill.setDeliveryPrice(transactionEntity.getDeliveryPrice());
		bill.setGstPrice(transactionEntity.getGstPrice());
		bill.setGstTaxSlab(transactionEntity.getGstTaxSlab());
		bill.setProductName(transactionEntity.getProductName());
		bill.setProductPrice(transactionEntity.getProductPrice());
		bill.setStatus(transactionEntity.getStatus());
		bill.setTotalPrice(transactionEntity.getTotalPrice());


		bill.setOrderDate(transactionEntity.getPaymentDate());
		bill.setCompanyName("OLX company pvt ltd");
		bill.setCompanyGstNo("07ABCDE1234F2Z5");
		bill.setQuantity(transactionEntity.getQuantity());
		bill.setUnits(transactionEntity.getUnits());
		bill.setDiscountPrice(transactionEntity.getDiscountPrice());
		bill.setTaxableAmount(transactionEntity.getTaxableAmount());
		bill.setDiscountPrice(transactionEntity.getDiscountPrice());
		bill.setGrandTotalAmount(transactionEntity.getGrandTotalAmount());
		log.info("Bill generated successfully for transaction ID: "+id);
		return bill;
		
//		bill.setCustomerId(transactionEntity.getCustomerId());
//		bill.setCustomerId(transactionEntity.getCustomerId());
//		bill.setCustomerId(transactionEntity.getCustomerId());
//		bill.setCustomerId(transactionEntity.getCustomerId());
//		bill.setCustomerId(transactionEntity.getCustomerId());

	}

}
