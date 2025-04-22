package com.olx.resale.app.service;

import java.util.List;

import com.olx.resale.app.entity.TransactionEntity;

public interface TransactionService {

	List<TransactionEntity> getAllTransaction();

	TransactionEntity getTransactionById(Long id);

	String saveTransaction(Long user_id, Long product_id,TransactionEntity transactionEntity);

}
