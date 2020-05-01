package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import modals.Config;

import java.sql.*;

public class MySQLUsersDao implements Users {

    // --------- INITIALIZE ---------
    private Connection connection = null; // object that represents my connection to the database

    // --------- CONSTRUCTOR METHOD ---------
    public MySQLUsersDao(Config config) {  // Config holds out SECRET information (username and passwords for database)

        try {

            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );

        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }

    }


    // --------- METHODS FROM USERS INTERFACE ---------
    @Override
    public User findByUsername(String username) throws SQLException {

        // create a variable that holds our mysql query
        String insertQuery = "SELECT * FROM users WHERE username LIKE ?";

        try {
            // connection.prepareStatement(sql): Create the prepared statement object
            PreparedStatement stmt = connection.prepareStatement(insertQuery);

            // 1 is the ? , username
            stmt.setString(1, username);

            return extractAd(stmt.executeQuery());

        } catch (SQLException e){

            throw new RuntimeException("Error finding a user by username", e);

        }
    }

    @Override
    public Long insert(User user) {
        try {
            // We defined the query with a placeholder, a ? to indicate where the value will go.
            String insertQuery = "INSERT INTO users(id, username, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            // insert the input terms into the query
            stmt.setLong(1, user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch (SQLException e) {

            throw new RuntimeException("Error creating a new user.", e);

        }
    }


    private User extractAd(ResultSet rs) throws SQLException {

        if( ! rs.next()){
            return null;
        }

        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

}
