package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionSingleton;
import com.solncev.entities.Request;
import com.solncev.repositories.RequestRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Марат on 25.11.2016.
 */
public class RequestRepositoryImpl implements RequestRepository {
    Connection connection = ConnectionSingleton.getConnection();

    @Override
    public void add(Request request) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO request(needy_id, volunteer_id, address, latitude, longitude, created_at, service_type, status) VALUES " +
                    "(?, ?, ?, ?, ?, to_date(?,'YYYY-MM-DD hh24:mi:ss'), ?, ?)");
            preparedStatement.setLong(1, request.getNeedy_id());
            preparedStatement.setLong(2, request.getVolunteer_id());
            preparedStatement.setString(3, request.getAddress());
            preparedStatement.setDouble(4, request.getLatitude());
            preparedStatement.setDouble(5, request.getLongitude());
            preparedStatement.setString(6, request.getCreated_at());
            preparedStatement.setString(7, request.getService_type());
            preparedStatement.setString(8, request.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
