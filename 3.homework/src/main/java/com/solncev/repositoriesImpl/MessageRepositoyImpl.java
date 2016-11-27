package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionHelper;
import com.solncev.entities.Message;
import com.solncev.repositories.MessageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Марат on 25.11.2016.
 */
public class MessageRepositoyImpl implements MessageRepository {
    private final static String insertQuery = "INSERT INTO message(text, sender_id, recipient_id, created_at, status)" +
            " VALUES (?,?,?,to_date(?,'YYYY-MM-DD hh24:mi:ss'),?)";
    Connection connection = ConnectionHelper.getConnection();

    @Override
    public void add(Message message) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, message.getText());
            preparedStatement.setLong(2, message.getSenderId());
            preparedStatement.setLong(3, message.getRecipientId());
            preparedStatement.setString(4, message.getCreated_at());
            preparedStatement.setString(5, message.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
