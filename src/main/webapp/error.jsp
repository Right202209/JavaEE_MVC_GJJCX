<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>错误提示</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        h1 {
            color: #f00;
        }
        p {
            color: #f00;
        }
        a {
            display: block;
            margin-bottom: 10px;
            font-size: 18px;
            color: #007bff;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>错误提示</h1>
<p>
    <%-- 获取错误消息参数 --%>
    <%= request.getParameter("message") %>
</p>
<a href="/exam2_war_exploded/query.jsp">返回重新输入</a>
</body>
</html>
