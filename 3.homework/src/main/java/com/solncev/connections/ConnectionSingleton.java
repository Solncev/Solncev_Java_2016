package com.solncev.connections;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static jdk.nashorn.internal.objects.Global.exit;

/**
 * Created by Марат on 26.11.2016.
 */
public class ConnectionSingleton {
    private static Connection conn = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;


    public static Connection getConnection() {
        if (conn == null) {
            try (InputStream in = ConnectionSingleton.class
                    .getClassLoader().getResourceAsStream("persistence.properties")) {
                Properties properties = new Properties();
                properties.load(in);
                url = properties.getProperty("url");
                username = properties.getProperty("username");
                password = properties.getProperty("password");
            } catch (IOException ex) {
                exit(ex, "Failed to load properties!");
            }
            try {
//                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, username, password);
                Statement statement = conn.createStatement();
            } catch (SQLException ex) {
                exit(ex, "Failed to get connection to the db!");
            }
        }
        return conn;
    }
}
