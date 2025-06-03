package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.dao.UserDAO;
import com.example.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
    public UserDAO userDAO;

    // Add constructor for DI (used in test)
    public UserServlet(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Default constructor for servlet container
    public UserServlet() {
        this.userDAO = new UserDAO();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        List<User> userList = dao.getAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/viewUsers.jsp");
        dispatcher.forward(request, response);
    }
}
