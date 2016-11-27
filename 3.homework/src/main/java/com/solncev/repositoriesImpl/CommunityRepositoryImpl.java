package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionSingleton;
import com.solncev.entities.Community;
import com.solncev.repositories.CommunityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Марат on 25.11.2016.
 */
public class CommunityRepositoryImpl implements CommunityRepository {
    Connection connection = ConnectionSingleton.getConnection();

    @Override
    public void update(long id, Community community) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE community SET name = ?, description = ?, founder_id = ?, created_at = to_date(?,'YYYY-MM-DD') WHERE id = ?");
            preparedStatement.setString(1, community.getName());
            preparedStatement.setString(2, community.getDescription());
            preparedStatement.setLong(3, community.getFounder_id());
            preparedStatement.setString(4, community.getCreated_at());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
