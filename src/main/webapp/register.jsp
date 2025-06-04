<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(120deg, #84fab0, #8fd3f4);
            height: 100vh;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            width: 400px;        /* narrower, single column */
            max-height: 90vh;    /* max height to allow vertical scroll */
            overflow-y: auto;
            padding: 30px;
        }
        .form-label {
            font-weight: 600;
        }
    </style>
</head>
<body>

<div class="card">
    <h3 class="text-center mb-4 text-primary">Register</h3>
    <form action="register" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" id="name" name="name" class="form-control" required placeholder="Enter full name" />
        </div>

        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" id="username" name="username" class="form-control" required placeholder="Choose a username" />
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" class="form-control" required placeholder="Enter password" />
        </div>

        <div class="mb-3">
            <label for="role" class="form-label">Role</label>
            <select id="role" name="role" class="form-select" required>
                <option value="" disabled selected>Select role</option>
                <option value="student">Student</option>
                <option value="admin">Admin</option>
            </select>
        </div>

        <hr>

        <div class="mb-3">
            <label for="dob" class="form-label">Date of Birth</label>
            <input type="date" id="dob" name="dob" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <select id="gender" name="gender" class="form-select" required>
                <option value="" disabled selected>Select gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" id="email" name="email" class="form-control" required placeholder="Enter email" />
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input type="tel" id="phone" name="phone" class="form-control" placeholder="Enter phone number" />
        </div>

        <h5 class="mb-3 mt-4">Guardian Information</h5>

        <div class="mb-3">
            <label for="guardian_name" class="form-label">Guardian Name</label>
            <input type="text" id="guardian_name" name="guardian_name" class="form-control" required placeholder="Enter guardian name" />
        </div>

        <div class="mb-3">
            <label for="guardian_relation" class="form-label">Guardian Relation</label>
            <input type="text" id="guardian_relation" name="guardian_relation" class="form-control" placeholder="e.g. Parent, Uncle" />
        </div>

        <div class="mb-3">
            <label for="guardian_phone" class="form-label">Guardian Phone</label>
            <input type="tel" id="guardian_phone" name="guardian_phone" class="form-control" placeholder="Enter guardian phone" />
        </div>

        <div class="mb-3">
            <label for="guardian_email" class="form-label">Guardian Email</label>
            <input type="email" id="guardian_email" name="guardian_email" class="form-control" placeholder="Enter guardian email" />
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <textarea id="address" name="address" class="form-control" rows="4" placeholder="Enter address"></textarea>
        </div>

        <div class="mb-3">
            <label for="photo" class="form-label">Photo</label>
            <input type="file" id="photo" name="photo" class="form-control" accept="image/*" />
        </div>

        <div class="d-grid mt-3">
            <button type="submit" class="btn btn-success">Register</button>
        </div>
    </form>

    <p class="mt-3 text-center text-muted">
        Already have an account? <a href="login.jsp" class="text-primary">Login</a>
    </p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
