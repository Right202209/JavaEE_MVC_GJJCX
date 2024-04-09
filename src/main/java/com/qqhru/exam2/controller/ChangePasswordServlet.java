package com.qqhru.exam2.controller;

import com.qqhru.exam2.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test_db";
            String username = "root";
            String password = "csqszq";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error initializing servlet: " + e.getMessage());
        }
        userService = new UserService(connection);
    }


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String selectMethod = request.getParameter("selectMethod");
//        String account = request.getParameter("account");
//        String oldPassword = request.getParameter("oldPassword");
//        String newPassword = request.getParameter("newPassword");
//
//        try {
//            boolean passwordChanged = userService.updatePassword(account, oldPassword, newPassword);
//            if (passwordChanged) {
//                // 密码修改成功的提示
//                response.sendRedirect("success.jsp?message=密码修改成功");
//            } else {
//                // 密码修改失败的提示
//                response.sendRedirect("error.jsp?message=密码修改失败");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // 处理数据库异常的逻辑
//            response.sendRedirect("error.jsp?message=数据库异常");
//        }
//    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String selectMethod = request.getParameter("selectMethod");
    String account = request.getParameter("account");
    String oldPassword = request.getParameter("oldPassword");
    String newPassword = request.getParameter("newPassword");

    Connection connection = null; // 获取数据库连接
    try {
        // 初始化数据库连接
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test_db";
        String username = "root";
        String dbPassword = "csqszq";
        connection = DriverManager.getConnection(url, username, dbPassword);

        // 实例化 UserService 对象并传入连接
        UserService userService = new UserService(connection);

        boolean passwordChanged = userService.updatePassword(account, oldPassword, newPassword);
        if (passwordChanged) {
            // 密码修改成功的提示
            response.sendRedirect("success.jsp?message="+ URLEncoder.encode("密码修改成功", StandardCharsets.UTF_8.toString()));
        } else {
            // 密码修改失败的提示
            response.sendRedirect("error.jsp?message="+URLEncoder.encode("密码修改失败",StandardCharsets.UTF_8.toString()));
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        // 处理数据库异常的逻辑
        response.sendRedirect("error.jsp?message="+URLEncoder.encode("数据库异常",StandardCharsets.UTF_8.toString()));
    } finally {
        // 关闭数据库连接
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

}
