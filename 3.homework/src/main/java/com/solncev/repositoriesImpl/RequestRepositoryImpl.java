package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionHelper;
import com.solncev.entities.Request;
import com.solncev.repositories.RequestRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Марат on 25.11.2016.
 */
public class RequestRepositoryImpl implements RequestRepository {
    private final static String insertQuery = "INSERT INTO request(needy_id, volunteer_id, address, latitude, longitude, created_at, service_type, status) VALUES " +
            "(?, ?, ?, ?, ?, to_date(?,'YYYY-MM-DD hh24:mi:ss'), ?, ?)";
    Connection connection = ConnectionHelper.getConnection();

    @Override
    public void add(Request request) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setLong(1, request.getNeedyId());
            preparedStatement.setLong(2, request.getVolunteerId());
            preparedStatement.setString(3, request.getAddress());
            preparedStatement.setDouble(4, request.getLatitude());
            preparedStatement.setDouble(5, request.getLongitude());
            preparedStatement.setString(6, request.getCreatedAt());
            preparedStatement.setString(7, request.getServiceType());
            preparedStatement.setString(8, request.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
