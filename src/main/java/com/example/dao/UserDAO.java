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
            Connection conn=connectToDatabase();
            String sql = "SELECT * FROM user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public Connection connectToDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            return connection;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void saveUser(User user){
        String sql="INSERT INTO USER (name,username,password) VALUES (?,?,?)";
        try(
            Connection conn=connectToDatabase();
            PreparedStatement stmt=conn.prepareStatement(sql)){
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPassword());

                stmt.executeUpdate();
        }
         catch(Exception e){
            e.printStackTrace();
        }

    }

}
