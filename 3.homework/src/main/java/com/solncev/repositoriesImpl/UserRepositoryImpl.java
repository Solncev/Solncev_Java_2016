package com.solncev.repositoriesImpl;

import com.solncev.connections.ConnectionHelper;
import com.solncev.entities.User;
import com.solncev.repositories.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 25.11.2016.
 */
public class UserRepositoryImpl implements UserRepository {
    private final static String selectForWinter = "WITH users_count AS (SELECT\n" +
            "                       u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status,\n" +
            "                       count(m.id) c\n" +
            "                     FROM users u\n" +
            "                       JOIN message m ON u.id = m.recipient_id\n" +
            "                     WHERE m.created_at >= '2015-12-01' AND m.created_at < '2016-03-01'\n" +
            "                     GROUP BY u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status)\n" +
            "SELECT\n" +
            "  users_count.id,\n" +
            "  users_count.name,\n" +
            "  users_count.surname,\n" +
            "  users_count.email,\n" +
            "  users_count.password,\n" +
            "  users_count.role,\n" +
            "  users_count.status,\n" +
            "  users_count.c\n" +
            "FROM users_count\n" +
            "WHERE c = (SELECT max(users_count.c)\n" +
            "           FROM users_count)";
    private final static String selectForSpring = "WITH users_count AS (SELECT\n" +
            "                       u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status,\n" +
            "                       count(m.id) c\n" +
            "                     FROM users u\n" +
            "                       JOIN message m ON u.id = m.recipient_id\n" +
            "                     WHERE m.created_at >= '2016-03-01' AND m.created_at < '2016-06-01'\n" +
            "                     GROUP BY u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status)\n" +
            "SELECT\n" +
            "  users_count.id,\n" +
            "  users_count.name,\n" +
            "  users_count.surname,\n" +
            "  users_count.email,\n" +
            "  users_count.password,\n" +
            "  users_count.role,\n" +
            "  users_count.status,\n" +
            "  users_count.c\n" +
            "FROM users_count\n" +
            "WHERE c = (SELECT max(users_count.c)\n" +
            "           FROM users_count)";
    private final static String selectForSummer = "WITH users_count AS (SELECT\n" +
            "                       u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status,\n" +
            "                       count(m.id) c\n" +
            "                     FROM users u\n" +
            "                       JOIN message m ON u.id = m.recipient_id\n" +
            "                     WHERE m.created_at >= '2016-06-01' AND m.created_at < '2016-09-01'\n" +
            "                     GROUP BY u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status)\n" +
            "SELECT\n" +
            "  users_count.id,\n" +
            "  users_count.name,\n" +
            "  users_count.surname,\n" +
            "  users_count.email,\n" +
            "  users_count.password,\n" +
            "  users_count.role,\n" +
            "  users_count.status,\n" +
            "  users_count.c\n" +
            "FROM users_count\n" +
            "WHERE c = (SELECT max(users_count.c)\n" +
            "           FROM users_count)";
    private final static String selectForAutumn = "WITH users_count AS (SELECT\n" +
            "                       u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status,\n" +
            "                       count(m.id) c\n" +
            "                     FROM users u\n" +
            "                       JOIN message m ON u.id = m.recipient_id\n" +
            "                     WHERE m.created_at >= '2016-09-01' AND m.created_at < '2017-01-01'\n" +
            "                     GROUP BY u.id,\n" +
            "                       u.name,\n" +
            "                       u.surname,\n" +
            "                       u.email,\n" +
            "                       u.password,\n" +
            "                       u.role,\n" +
            "                       u.status)\n" +
            "SELECT\n" +
            "  users_count.id,\n" +
            "  users_count.name,\n" +
            "  users_count.surname,\n" +
            "  users_count.email,\n" +
            "  users_count.password,\n" +
            "  users_count.role,\n" +
            "  users_count.status,\n" +
            "  users_count.c\n" +
            "FROM users_count\n" +
            "WHERE c = (SELECT max(users_count.c)\n" +
            "           FROM users_count)";
    private final static String selectForAddress = "WITH users_address AS (SELECT\n" +
            "                         u.id,\n" +
            "                         u.name,\n" +
            "                         u.surname,\n" +
            "                         u.email,\n" +
            "                         u.password,\n" +
            "                         u.role,\n" +
            "                         u.status,\n" +
            "                         count(r.id) c\n" +
            "                       FROM users u\n" +
            "                         JOIN request r ON u.id = r.volunteer_id\n" +
            "                       WHERE r.address LIKE ? \n" +
            "                       GROUP BY u.id,\n" +
            "                         u.name,\n" +
            "                         u.surname,\n" +
            "                         u.email,\n" +
            "                         u.password,\n" +
            "                         u.role,\n" +
            "                         u.status)\n" +
            "SELECT\n" +
            "  users_address.id,\n" +
            "  users_address.name,\n" +
            "  users_address.surname,\n" +
            "  users_address.email,\n" +
            "  users_address.password,\n" +
            "  users_address.role,\n" +
            "  users_address.status,\n" +
            "  users_address.c\n" +
            "FROM users_address\n" +
            "WHERE c = (SELECT max(users_address.c)\n" +
            "           FROM users_address);";

    private final static String insertQuery = "insert INTO users(name, surname, email, password, role, status)" +
            " VALUES (?,?,?,?,?,?)";

    private Connection connection = ConnectionHelper.getConnection();

    @Override
    public void add(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getReceivedHighestNumberOfMessage(String season) {
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            switch (season) {
                case "winter":
                    preparedStatement = connection.prepareStatement(selectForWinter);
                    break;
                case "spring":
                    preparedStatement = connection.prepareStatement(selectForSpring);
                    break;
                case "summer":
                    preparedStatement = connection.prepareStatement(selectForSummer);
                    break;
                case "autumn":
                    preparedStatement = connection.prepareStatement(selectForAutumn);
                    break;
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("status")
                );
                if (user != null)
                    users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> getRespondedHighestNumberOfRequest(String address) {
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectForAddress);
            preparedStatement.setString(1, "%" + address + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("status")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
