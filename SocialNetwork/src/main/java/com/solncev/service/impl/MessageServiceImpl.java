package com.solncev.service.impl;

import com.solncev.model.Message;
import com.solncev.repository.MessageRepository;
import com.solncev.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Марат on 17.03.2017.
 */
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public List<Message> findAllByRecipientId(Long recipientId, Long senderId) {
        return messageRepository.findAllByRecipientIdAndSenderId(recipientId, senderId);
    }

    @Override
    public void add(Message message) {
        messageRepository.save(message);
    }
}
