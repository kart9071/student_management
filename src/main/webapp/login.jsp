<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Student Management System</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            margin: 0;
            padding: 0;
            color: #fff;
        }

        .login-container {
            width: 400px;
            margin: 100px auto;
            padding: 40px;
            background-color: rgba(0, 0, 0, 0.3);
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.4);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-top: 5px;
            border-radius: 8px;
            border: none;
            outline: none;
            font-size: 14px;
        }

        .btn {
            width: 100%;
            padding: 12px;
            margin-top: 25px;
            background-color: #fff;
            color: #2575fc;
            border: none;
            border-radius: 25px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn:hover {
            background-color: #2575fc;
            color: white;
        }

        .error {
            color: #ff4d4d;
            text-align: center;
            margin-top: 10px;
        }

        a.back-home {
            display: block;
            margin-top: 20px;
            text-align: center;
            color: #fff;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>User Login</h2>
        <form action="login" method="post">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" required />

            <label for="password">Password</label>
            <input type="password" name="password" id="password" required />

            <input type="submit" value="Login" class="btn" />
        </form>

        <%-- Optional error message --%>
        <%
            String error = request.getParameter("error");
            if (error != null) {
        %>
            <div class="error">Invalid username or password</div>
        <% } %>

        <a href="home.jsp" class="back-home">← Back to Home</a>
    </div>
</body>
</html>
