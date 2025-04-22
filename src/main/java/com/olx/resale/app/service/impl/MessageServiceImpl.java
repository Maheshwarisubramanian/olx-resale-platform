package com.olx.resale.app.service.impl;

import com.olx.resale.app.entity.Message;
import com.olx.resale.app.entity.Product;
import com.olx.resale.app.entity.User;
import com.olx.resale.app.entity.enums.Role;
import com.olx.resale.app.payload.ManageProductResponse;
import com.olx.resale.app.payload.MessageRequest;
import com.olx.resale.app.payload.MessageResponse;
import com.olx.resale.app.repository.MessageRepository;
import com.olx.resale.app.repository.ProductRepository;
import com.olx.resale.app.repository.UserRepository;
import com.olx.resale.app.service.MessageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  AuthServiceImpl authService;

    @Transactional
    public MessageResponse sendMessage(MessageRequest messageRequest ) {	

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User sender = (User) authentication.getPrincipal();
        Product product =productRepository.findById(messageRequest.getProduct()).orElseThrow(()->new RuntimeException("product not found"));
//        User seller =product.getSeller();
        Long sellerId = product.getCustomerId();
        User sellerDetails = userRepository.findById(sellerId).get();
           if (sender.getId().equals(sellerId)) {
               throw new IllegalArgumentException("seller cannot send message to themself");
           }

           
           
            Message message = new Message();
            message.setSender(sender);
            message.setReceiver(sellerDetails);
            message.setProduct(product);
            message.setMessage(messageRequest.getMessage());
            message.setTimestamp(LocalDateTime.now());

            Message SavedMessage = messageRepository.save(message);

            return new MessageResponse(
                    product.getId(),
                    sender.getName(),
                    sellerDetails.getName(),
                    product.getProductName(),
                    SavedMessage.getMessage(),
                    SavedMessage.getTimestamp()
            );


    }

    public List<ManageProductResponse> getMessagesByProductId(long productId) {
        //changed
        List<Message> messages =messageRepository.findByProductId(productId);
        return (List<ManageProductResponse>) messages.stream().map(message -> {
            String sender = message.getSender().getName();
            String receiver =message.getReceiver().getName();
            return new ManageProductResponse(
                    message.getProduct().getId(),
                    sender,
                    receiver,
                    message.getMessage(),
                    message.getTimestamp()
            );
        }).collect(Collectors.toList());
    }
}
