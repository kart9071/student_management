
package com.example.test;

import java.util.List;

import com.example.dao.UserDAO;
import com.example.model.User;

public class UserDAOTest {
    public static void main(String[] args) {
        UserDAO userDao = new UserDAO();
        List<User> users = userDao.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("No users found or failed to connect.");
        } else {
            System.out.println("Users fetched from database:");
            for (User u : users) {
                System.out.println("ID: " + u.getId() + ", Name: " + u.getName());
            }
        }
    }
}
