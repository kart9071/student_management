package com.example.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import com.example.dao.UserDAO;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/register")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1,  // 1MB
                 maxFileSize = 1024 * 1024 * 10,       // 10MB
                 maxRequestSize = 1024 * 1024 * 15)    // 15MB
public class RegisterServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // Read form fields
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String dobStr = req.getParameter("dob");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String guardianName = req.getParameter("guardian_name");
        String guardianRelation = req.getParameter("guardian_relation");
        String guardianPhone = req.getParameter("guardian_phone");
        String guardianEmail = req.getParameter("guardian_email");
        String address = req.getParameter("address");

        // Handle photo upload
        Part photoPart = req.getPart("photo");
        String photoFileName = null;
        if (photoPart != null && photoPart.getSize() > 0) {
            String submittedFileName = Paths.get(photoPart.getSubmittedFileName()).getFileName().toString();
            String fileExt = "";

            int i = submittedFileName.lastIndexOf('.');
            if (i > 0) {
                fileExt = submittedFileName.substring(i);
            }

            photoFileName = UUID.randomUUID().toString() + fileExt;  // unique filename

            // Determine upload path
            String appPath = req.getServletContext().getRealPath("");
            String uploadPath = appPath + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Save file on disk
            photoPart.write(uploadPath + File.separator + photoFileName);
        }

        // Create User object and set all fields
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setDob(dobStr);
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        user.setGuardianName(guardianName);
        user.setGuardianRelation(guardianRelation);
        user.setGuardianPhone(guardianPhone);
        user.setGuardianEmail(guardianEmail);
        user.setAddress(address);
        user.setPhotoFileName(photoFileName);

        // Save user using DAO
        UserDAO dao = new UserDAO();
        dao.saveUser(user);

        // Redirect after successful registration
        resp.sendRedirect("success.jsp");
    }
}
