package com.olx.resale.app.controller;

import com.olx.resale.app.payload.ManageProductResponse;
import com.olx.resale.app.payload.MessageRequest;
import com.olx.resale.app.payload.MessageResponse;
import com.olx.resale.app.service.MessageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="4. Message Controller")
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

	@Operation(summary = "POST operation to send the message by customer to the seller for cost negotiation.  ",
			description = "It is used to send the message by any customer for price negotiation .")
    @PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
    @PostMapping("/sendMessage")
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody MessageRequest messageRequest) {
       MessageResponse response = messageService.sendMessage(messageRequest);
       return  ResponseEntity.ok(response);
    }

	@Operation(summary = "GET operation for getting all the message by product id. ",
			description = "It is used for getting all the message by product wise.")
    @GetMapping("/productId/{productId}")
    public ResponseEntity<List<ManageProductResponse>> getListOfMessagesByProductId(@PathVariable("productId") long productId) {
        List<ManageProductResponse> messagesByProductId = messageService.getMessagesByProductId(productId);
        return ResponseEntity.ok(messagesByProductId);
    }

}
