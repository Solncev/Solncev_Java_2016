package com.solncev.service;

import com.solncev.model.Message;

import java.util.List;

/**
 * Created by Марат on 17.03.2017.
 */
public interface MessageService {
    List<Message> findAllByRecipientId(Long recipientId, Long senderId);

    void add(Message message);
}
