package com.olx.resale.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olx.resale.app.entity.BillEntity;
import com.olx.resale.app.service.BillService;

@Tag(name="6. Bill Controller")
@RestController
@RequestMapping("/api/bill")
public class BillController {

	private static final Logger log = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillService billService;
	
	
	@Operation(summary = "GET operation for generate invoice by transation id. ",
			description = "It is used for generate invoice bill by transaction id.")
	@GetMapping("/billGenerateByTransactionId/{id}")
	public ResponseEntity<BillEntity> billGenerateByTransactionId(@PathVariable Long id ) {
		log.info("Received request to generate bill for transaction ID: {}", id);

		try {
			BillEntity generatedBill = billService.generateBillTransactionById(id);
			if (generatedBill != null) {
				log.info("Successfully generated bill for transaction ID: {}", id);
				return new ResponseEntity<>(generatedBill, HttpStatus.OK);
			} else {
				log.warn("No bill found for transaction ID: {}", id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("Error occurred while generating bill for transaction ID: {}", id, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
