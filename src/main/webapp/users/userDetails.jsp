<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<%@ page import="com.example.dao.UserDAO" %>

<%
    String userIdParam = request.getParameter("userId");
    User user = null;

    if (userIdParam != null) {
        int userId = Integer.parseInt(userIdParam);
        UserDAO userDAO = new UserDAO();
        user = userDAO.getUserById(userId); // You must implement this method
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #74ebd5, #ACB6E5);
            min-height: 100vh;
            padding: 30px;
        }

        .container {
            background-color: white;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            max-width: 600px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Details</h2>

    <% if (user != null) { %>
        <p><strong>ID:</strong> <%= user.getId() %></p>
        <p><strong>Full Name:</strong> <%= user.getName() %></p>
        <p><strong>Username:</strong> <%= user.getDob() %></p>
        <p><strong>Email:</strong> <%= user.getEmail() %></p>
        <p><strong>Guardian Name:</strong> <%= user.getGuardianName() %></p>
        <p><strong>Guardian Phone:</strong> <%= user.getGuardianPhone() %></p>
        <p><strong>Guardian Email:</strong> <%= user.getGuardianEmail() %></p>
        <p><strong>Guardian Relation:</strong> <%= user.getGuardianRelation() %></p>
        <p><strong>Student Address:</strong> <%= user.getAddress() %></p>
        <p><strong>Role:</strong> <%= user.getRole() %></p>
    <% } else { %>
        <p class="text-danger">User not found.</p>
    <% } %>

    <div class="text-center mt-4">
        <a href="<%= request.getContextPath() %>/viewUsers" class="btn btn-back px-4">Back</a>
    </div>
</div>
</body>
</html>
