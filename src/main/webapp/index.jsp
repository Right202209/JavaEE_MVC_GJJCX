<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>公积金查询系统</title>
  <style>
    body {
      text-align: center;
      font-family: Arial, sans-serif;
      margin: 50px;
    }
    h1 {
      color: #333;
    }
    .nav {
      margin-top: 20px;
    }
    .nav a {
      display: block;
      margin-bottom: 10px;
      font-size: 18px;
      color: #007bff;
      text-decoration: none;
    }
  </style>
</head>
<body>
<h1>欢迎使用公积金查询系统</h1>
<div class="nav">
  <h2><a href="query.jsp">查询公积金余额</a></h2>
  <h2><a href="./changepassword.jsp">修改密码</a></h2>
</div>
</body>
</html>
