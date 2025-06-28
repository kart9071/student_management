<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"teacher".equalsIgnoreCase(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #e0f7fa;
            padding: 0;
            margin: 0;
        }
        header {
            background: #00796b;
            color: white;
            padding: 20px;
            text-align: center;
        }
        .container {
            margin: 50px auto;
            width: 80%;
            text-align: center;
        }
        .btn {
            padding: 12px 25px;
            margin: 10px;
            border: none;
            border-radius: 6px;
            background-color: #00897b;
            color: white;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome, <%= user.getName() %> (Teacher)</h1>
    <img src="images/<%= user.getPhotoFileName() %>" alt="Profile Photo" height="150"/>
</header>

<div class="container">
    <h2>Teacher Dashboard</h2>
    <p>You are successfully logged in.</p>
    <a href="logout.jsp" class="btn">Logout</a>
</div>
</body>
</html>
