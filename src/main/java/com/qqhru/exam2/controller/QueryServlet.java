package com.qqhru.exam2.controller;

import com.qqhru.exam2.model.User;
import com.qqhru.exam2.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test_db";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error initializing servlet: " + e.getMessage());
        }
        userService = new UserService(connection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectMethod = request.getParameter("selectMethod");
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        try {
            User user = null;
            if ("idCard".equals(selectMethod)) {
                user = userService.getUserByIdCard(account);
            } else if ("fundAccount".equals(selectMethod)) {
                user = userService.getUserByFundAccount(account);
            }

            if (user != null && user.getPassword().equals(password)) {
                // 用户存在且密码正确，将用户信息存入session以便其他页面使用
                request.getSession().setAttribute("currentUser", user);
                response.sendRedirect("showBalance.jsp");
            } else {
                // 用户不存在或密码错误，重定向到错误页面
                response.sendRedirect("error.jsp?message="+ URLEncoder.encode("用户不存在或密码错误", StandardCharsets.UTF_8.toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理数据库异常的逻辑，重定向到错误页面
            response.sendRedirect("error.jsp?message="+URLEncoder.encode("数据库异常",StandardCharsets.UTF_8.toString()));
        }
    }

//    @Override
//    public void destroy() {
//        super.destroy();
//        // 在servlet销毁时关闭数据库连接
//        if (userService != null) {
//            userService.closeConnection();
//        }
//    }
}
