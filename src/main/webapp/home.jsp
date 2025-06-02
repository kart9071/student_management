<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            margin: 0;
            padding: 0;
            color: #fff;
        }

        header {
            background-color: rgba(0, 0, 0, 0.2);
            padding: 20px;
            text-align: center;
        }

        header h1 {
            margin: 0;
            font-size: 2.5rem;
        }

        .container {
            text-align: center;
            margin-top: 100px;
        }

        .container h2 {
            margin-bottom: 30px;
        }

        .btn {
            background-color: #fff;
            color: #2575fc;
            padding: 15px 30px;
            margin: 10px;
            text-decoration: none;
            border-radius: 30px;
            font-weight: bold;
            transition: all 0.3s ease;
            border: none;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #2575fc;
            color: white;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
        }

        footer {
            text-align: center;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.2);
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        a.btn {
            display: inline-block;
        }
    </style>
</head>
<body>
    <header>
        <h1>Student Management System</h1>
    </header>

    <div class="container">
        <h2>Welcome to SMS Dashboard</h2>
        <a href="register.jsp" class="btn">Register Student</a>
        <a href="viewUsers.jsp" class="btn">View Students</a>
        <a href="login.jsp" class="btn">Login</a>
    </div>

    <footer>
        &copy; 2025 Student Management System. All rights reserved.
    </footer>
</body>
</html>
