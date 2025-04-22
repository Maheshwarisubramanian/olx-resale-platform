package com.olx.resale.app.payload;

import java.time.LocalDateTime;

public class ManageProductResponse {
    private Long productId;
    private String sender;
    private String receiver;
    private String message;
    private LocalDateTime timeStamp;

    public ManageProductResponse() {
    }

    public ManageProductResponse(Long productId, String sender, String receiver, String message, LocalDateTime timeStamp) {
        this.productId = productId;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timeStamp = timeStamp;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}

