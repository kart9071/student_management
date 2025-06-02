<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #56ab2f, #a8e063);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card {
            border-radius: 15px;
            padding: 30px;
            text-align: center;
            box-shadow: 0 6px 25px rgba(0, 0, 0, 0.3);
        }
        .btn-home {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="card">
    <h2 class="text-success">🎉 Registration Successful!</h2>
    <p class="mt-3 fs-5">Welcome to the system. Your account has been created.</p>
    <a href="home.jsp" class="btn btn-light btn-home">Go to Homepage</a>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
