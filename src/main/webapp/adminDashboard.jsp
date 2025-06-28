<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"admin".equalsIgnoreCase(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            padding: 0;
            margin: 0;
        }
        header {
            background: #003366;
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
            background-color: #007bff;
            color: white;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome, <%= user.getName() %> (Admin)</h1>
</header>

<div class="container">
    <h2>Admin Dashboard</h2>
    <img src="images/<%= user.getPhotoFileName() %>" alt="Profile Photo" height="150"/>
    <a href="users/" class="btn">View All Students</a>
    <a href="register.jsp" class="btn">Register New Student</a>
    <a href="logout.jsp" class="btn">Logout</a>
</div>
</body>
</html>
