package com.qqhru.exam2.Dao;

import com.qqhru.exam2.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserByIdCard(String idCard) throws SQLException {
        String query = "SELECT * FROM fund_account WHERE id_card = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idCard);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setIdCard(resultSet.getString("id_card"));
                    user.setFundAccount(resultSet.getString("fund_account"));
                    user.setName(resultSet.getString("name"));
                    user.setBalance(resultSet.getDouble("balance"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                } else {
                    return null; // 没有找到对应的用户
                }
            }
        }
    }

    public boolean updatePassword(String idCard, String newPassword) throws SQLException {
        String query = "UPDATE fund_account SET password = ? WHERE id_card = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newPassword);
            statement.setString(2, idCard);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public User getUserByFundAccount(String fundAccount) throws SQLException {
        String query = "SELECT * FROM fund_account WHERE fund_account = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fundAccount);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setIdCard(resultSet.getString("id_card"));
                    user.setFundAccount(resultSet.getString("fund_account"));
                    user.setName(resultSet.getString("name"));
                    user.setBalance(resultSet.getDouble("balance"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                } else {
                    return null; // 没有找到对应的用户
                }
            }
        }
    }

}

