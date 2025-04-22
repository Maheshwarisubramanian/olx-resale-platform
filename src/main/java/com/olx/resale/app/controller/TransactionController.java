package com.olx.resale.app.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.olx.resale.app.entity.TransactionEntity;
import com.olx.resale.app.service.TransactionService;

@Tag(name="5. Transaction Controller")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TransactionService transactionService;

	@Operation(summary = "POST operation for save the transation after successful payment.", 
			description = "It is used to save all the transaction data after successful payment. ")
	@PostMapping("/saveTransactionAfterSuccessfulPayment")
	public ResponseEntity<String> saveTransactionAfterSuccessfulPayment(
			@RequestParam(required = false) Long user_id,
			@RequestParam(required = false) Long product_id,
			@RequestBody TransactionEntity transactionEntity) {

		log.info("Request received to save transaction: {}", transactionEntity);
		try {
			String result = transactionService.saveTransaction(user_id,product_id, transactionEntity);
			log.info("Transaction saved successfully: {}", transactionEntity);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error occurred while saving transaction: {}", transactionEntity, e);
			return new ResponseEntity<>("Failed to save transaction.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	@Operation(summary = "GET operation for showing all the transation details of product.",
			description = "It is used to showing all the transaction details. ")
	@GetMapping("/showAllTransaction")
	public ResponseEntity<List<TransactionEntity>> showAllTransaction() {
		log.info("Request received to fetch all transactions");
		try {
			List<TransactionEntity> transactions = transactionService.getAllTransaction();
			log.info("Fetched {} transactions successfully", transactions.size());
			return new ResponseEntity<>(transactions, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error occurred while fetching all transactions", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	@Operation(summary = "GET operation for showing transation details by transaction id.",
			description = "It is used to showing transaction details of transaction id. ")
	@GetMapping("/showTransactionById/{id}")
	public ResponseEntity<TransactionEntity> showTransactionById(@PathVariable Long id) {
		log.info("Request received to fetch transaction by id: {}", id);
		try {
			TransactionEntity transaction = transactionService.getTransactionById(id);
			if (transaction != null) {
				log.info("Transaction found: {}", transaction);
				return new ResponseEntity<>(transaction, HttpStatus.OK);
			} else {
				log.warn("Transaction not found with id: {}", id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("Error occurred while fetching transaction by id: {}", id, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
