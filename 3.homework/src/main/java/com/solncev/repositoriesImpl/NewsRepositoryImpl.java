package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionSingleton;
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
    Connection connection = ConnectionSingleton.getConnection();

    @Override
    public void update(long id, News news) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE news SET text = ?,community_id = ?, author_id=?,created_at=to_date(?,'YYYY-MM-DD hh24:mi:ss') WHERE id = ?");
            preparedStatement.setString(1, news.getText());
            preparedStatement.setLong(2, news.getCommunity_id());
            preparedStatement.setLong(3, news.getAuthor_id());
            preparedStatement.setString(4, news.getCreated_at());
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
            preparedStatement = connection.prepareStatement("SELECT count(*) from news " +
                    "WHERE author_id = ?");
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
