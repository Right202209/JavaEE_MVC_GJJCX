<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查询公积金</title>
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
    a {
    color: black;
    text-decoration:none;
    }
    </style>
</head>
<body>
<h1>查询公积金</h1>
<form action="query" method="post">
    <label for="selectMethod">选择查询方式：</label>
    <select name="selectMethod" id="selectMethod">
        <option value="idCard">身份证号</option>
        <option value="fundAccount">公积金账号</option>
    </select>
    <br><br>
    <label for="account">账号：</label>
    <input type="text" id="account" name="account" required>
    <br><br>
    <label for="password">密码：</label>
    <input type="password" id="password" name="password" required>
    <br><br>
    <input type="submit" style="text-align: center" value="查询">
    <button style="text-align: right;"><a href="index.jsp">返回</a> </button>
</form>
</body>
</html>
