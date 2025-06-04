package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.dao.UserDAO;
import com.example.model.User;

public class UserDAOTest {
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
}
