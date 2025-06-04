package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;

public class UserDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentsystem";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "root";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection conn = connectToDatabase();
            String sql = "SELECT * FROM user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setDob(rs.getString("dob"));
                u.setGender(rs.getString("gender"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setGuardianName(rs.getString("guardian_name"));
                u.setGuardianRelation(rs.getString("guardian_relation"));
                u.setGuardianPhone(rs.getString("guardian_phone"));
                u.setGuardianEmail(rs.getString("guardian_email"));
                u.setAddress(rs.getString("address"));
                u.setPhotoFileName(rs.getString("photo_file_name"));
                users.add(u);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public Connection connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveUser(User user) {
        String sql = "INSERT INTO user " +
                "(name, username, password, role, dob, gender, email, phone, " +
                "guardian_name, guardian_relation, guardian_phone, guardian_email, address, photo_file_name) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connectToDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.setString(5, user.getDob());
            stmt.setString(6, user.getGender());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getPhone());
            stmt.setString(9, user.getGuardianName());
            stmt.setString(10, user.getGuardianRelation());
            stmt.setString(11, user.getGuardianPhone());
            stmt.setString(12, user.getGuardianEmail());
            stmt.setString(13, user.getAddress());
            stmt.setString(14, user.getPhotoFileName());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User validateUser(String username, String password) {
        User user = null;
        try (Connection conn = connectToDatabase()) {
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet sr = stmt.executeQuery();
            if (sr.next()) {
                user = new User();
                user.setId(sr.getInt("id"));
                user.setName(sr.getString("name"));
                user.setUsername(sr.getString("username"));
                user.setPassword(sr.getString("password"));
                user.setRole(sr.getString("role"));
                user.setDob(sr.getString("dob"));
                user.setGender(sr.getString("gender"));
                user.setEmail(sr.getString("email"));
                user.setPhone(sr.getString("phone"));
                user.setGuardianName(sr.getString("guardian_name"));
                user.setGuardianRelation(sr.getString("guardian_relation"));
                user.setGuardianPhone(sr.getString("guardian_phone"));
                user.setGuardianEmail(sr.getString("guardian_email"));
                user.setAddress(sr.getString("address"));
                user.setPhotoFileName(sr.getString("photo_file_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
