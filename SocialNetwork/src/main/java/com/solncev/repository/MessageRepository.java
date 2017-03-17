package com.solncev.repository;

import com.solncev.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Марат on 17.03.2017.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByRecipientIdAndSenderId(Long recipientId, Long senderId);
}
