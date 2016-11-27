package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionHelper;
import com.solncev.entities.News;
import com.solncev.repositories.NewsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Марат on 25.11.2016.
 */
public class NewsRepositoryImpl implements NewsRepository {
    private final static String updateQuery = "UPDATE news SET text = ?,community_id = ?, author_id=?,created_at=to_date(?,'YYYY-MM-DD hh24:mi:ss') WHERE id = ?";
    private final static String queryForNewsCount = "SELECT count(*) from news " +
            "WHERE author_id = ?";
    Connection connection = ConnectionHelper.getConnection();

    @Override
    public void update(long id, News news) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, news.getText());
            preparedStatement.setLong(2, news.getCommunityId());
            preparedStatement.setLong(3, news.getAuthorId());
            preparedStatement.setString(4, news.getCreatedAt());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCountByAuthorId(long id) {
        int count = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(queryForNewsCount);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = (int) resultSet.getLong("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
