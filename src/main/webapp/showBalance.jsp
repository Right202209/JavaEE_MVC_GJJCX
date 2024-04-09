<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.qqhru.exam2.model.User"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>公积金余额</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        h1 {
            color: #333;
        }
        a {
            display: block;
            margin-bottom: 10px;
            font-size: 18px;
            color: #007bff;
            text-decoration: none;
        }
        .balance-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h1>您的公积金余额</h1>
<div class="balance-container">
        <% User currentUser = (User) request.getSession().getAttribute("currentUser"); %>
        <p>您的公积金余额为：<strong><%= currentUser.getBalance() %></strong> 元</p>
    <a href="index.jsp">返回首页</a>
</div>
</body>
</html>
