package com.qqhru.exam2.service;

import com.qqhru.exam2.Dao.UserDAO;
import com.qqhru.exam2.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private UserDAO userDAO;
    private Connection connection;

    public UserService(Connection connection) {
        this.userDAO = new UserDAO(connection);
    }


    public User getUserByIdCard(String idCard) throws SQLException {
        return userDAO.getUserByIdCard(idCard);
    }

    public boolean updatePassword(String idCard, String oldPassword, String newPassword) throws SQLException {
        User user = userDAO.getUserByIdCard(idCard);
        if (user != null && user.getPassword().equals(oldPassword)) {
            return userDAO.updatePassword(idCard, newPassword);
        }
        return false;
    }

    public  User getUserByFundAccount(String fundAccount) throws SQLException {
        return userDAO.getUserByFundAccount(fundAccount);
    }

}

