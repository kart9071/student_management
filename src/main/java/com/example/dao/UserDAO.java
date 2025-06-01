package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String sql = "SELECT * FROM user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                users.add(u);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
