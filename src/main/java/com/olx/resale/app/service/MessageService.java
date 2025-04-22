package com.olx.resale.app.service;

import com.olx.resale.app.payload.ManageProductResponse;
import com.olx.resale.app.payload.MessageRequest;
import com.olx.resale.app.entity.Message;
import com.olx.resale.app.payload.MessageResponse;

import java.util.List;

public interface MessageService {

    public MessageResponse sendMessage(MessageRequest messageRequest );

    public List<ManageProductResponse> getMessagesByProductId(long productId);
}
