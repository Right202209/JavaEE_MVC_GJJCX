<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>操作成功</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        h1 {
            color: #0f0;
        }
        p {
            color: #0f0;
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
<h1>操作成功</h1>
<p>
    <%-- 获取成功消息参数 --%>
    <%= request.getParameter("message") %>
</p>
<a href="/exam2_war_exploded/query.jsp">返回查询</a>
</body>
</html>
