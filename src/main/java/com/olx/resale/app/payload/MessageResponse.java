package com.olx.resale.app.payload;


import java.time.LocalDateTime;

public class MessageResponse {
    private Long productId;
    private String sender;
    private String receiver;
    private String productName;
    private String messageContent;
    private LocalDateTime timestamp;

    public MessageResponse() {
    }

    public MessageResponse(Long productId, String sender, String receiver, String productName, String messageContent, LocalDateTime timestamp) {
        this.productId = productId;
        this.sender = sender;
        this.receiver = receiver;
        this.productName = productName;
        this.messageContent = messageContent;
        this.timestamp = timestamp;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

