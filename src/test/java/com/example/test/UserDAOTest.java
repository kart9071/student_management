package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.dao.UserDAO;
import com.example.model.User;

public class UserDAOTest {

    private static Connection conn;
    @Test
    private void testGetAllUsers() {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUsers();

        // Print for debug (optional)
        for (User user : users) {
            System.out.println(user.getId() + " " + user.getUsername()+" "+user.getPassword()+" "+user.getRole());
        }

        // Assert there is at least one user
        assertFalse(users.isEmpty(), "User list should not be empty");
    }

    @Test
    private void testDeleteAllUsers() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsystem", "root", "root");
        Statement stmt = conn.createStatement();

        // Delete all users
        int rowsDeleted = stmt.executeUpdate("DELETE FROM user");
        System.out.println("Deleted rows: " + rowsDeleted);

        // Verify table is empty
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM user");
        rs.next();
        int count = rs.getInt(1);

        Assertions.assertEquals(0, count, "All users should be deleted.");
    }
}
