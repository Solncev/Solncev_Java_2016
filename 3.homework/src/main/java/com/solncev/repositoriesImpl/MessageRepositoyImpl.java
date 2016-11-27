package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionSingleton;
import com.solncev.entities.Message;
import com.solncev.repositories.MessageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Марат on 25.11.2016.
 */
public class MessageRepositoyImpl implements MessageRepository {
    Connection connection = ConnectionSingleton.getConnection();

    @Override
    public void add(Message message) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO message(text, sender_id, recipient_id, created_at, status)" +
                    " VALUES (?,?,?,to_date(?,'YYYY-MM-DD hh24:mi:ss'),?)");
            preparedStatement.setString(1, message.getText());
            preparedStatement.setLong(2, message.getSender_id());
            preparedStatement.setLong(3, message.getRecipient_id());
            preparedStatement.setString(4, message.getCreated_at());
            preparedStatement.setString(5, message.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
