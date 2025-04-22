package com.olx.resale.app.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.resale.app.entity.Product;
import com.olx.resale.app.entity.TransactionEntity;
import com.olx.resale.app.entity.User;
import com.olx.resale.app.repository.ProductRepository;
import com.olx.resale.app.repository.TransactionRepository;
import com.olx.resale.app.repository.UserRepository;
import com.olx.resale.app.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);


	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<TransactionEntity> getAllTransaction() {
		log.info("Fetching all transactions,");

		List<TransactionEntity> allTransaction = transactionRepository.findAll();
		log.info("Fetched "+allTransaction.size()+" transactions.");
		return allTransaction;
	}

	@Override
	public TransactionEntity getTransactionById(Long id) {
		log.info("Fetching transactions with ID: "+id);
		TransactionEntity referenceById = transactionRepository.getReferenceById(id);
		log.info("Transactions with ID: "+id+" fetched successfully.");
		return referenceById;
	}

	@Override
	public String saveTransaction(Long user_id, Long product_id, TransactionEntity transactionEntity) {


		TransactionEntity transaction=new  TransactionEntity();
		transaction=transactionEntity;

		log.info("Attempting to sav transaction for user ID: "+user_id+" and product ID: "+product_id);
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter expiryPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String currentDate = currentDateTime.format(pattern);

		DateTimeFormatter timePattern = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalTime time = LocalTime.now();
        String currentTime = time.format(timePattern);

		log.info("Formatted current date and current time: "+currentDateTime);
		log.info("Fetching user with ID: "+user_id);

        System.out.println("Formatted Date String: " + currentTime);
		
		User user = userRepository.findById(user_id).orElse(null);
		log.info("User found: "+user.getName()+ ", Role: "+user.getRole().toString());
		transactionEntity.setCustomerId(user.getId());
		transactionEntity.setCustomerName(user.getName());
		transactionEntity.setCustomerType(user.getRole().toString());

		log.info("Fetching product with ID: "+product_id);
		Product product = productRepository.findById(product_id).orElse(null);
		log.info("Product found: "+product.getProductName()+", Price: "+product.getProductPrice());
		transactionEntity.setProductId(product_id);
		transactionEntity.setProductName(product.getProductName());
		transactionEntity.setProductPrice(product.getProductPrice());
		transactionEntity.setPaymentDate(currentDate);
		transactionEntity.setPaymentTime(currentTime);
		System.out.println("M2 transactionEntity " + transaction);

		log.info("Saving transaction with customer ID: "+user.getId()+" and product ID: "+product_id);
		TransactionEntity save = transactionRepository.save(transactionEntity);
		if (save != null) {
			log.info("Transaction saved successfully with ID: "+save.getId());
			return "Transaction details have been saved. ";

		} else {
			log.error("Transaction failed to save.");
			return "Transaction details have not be saved.";
		}
	}

}
