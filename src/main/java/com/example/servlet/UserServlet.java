package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.dao.UserDAO;
import com.example.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewUsers") // This maps the servlet to /viewUsers
public class UserServlet extends HttpServlet {
    public UserDAO userDAO;

    public UserServlet(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserServlet() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> userList = userDAO.getStudents();  // only students
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/viewUsers.jsp");
        dispatcher.forward(request, response);
    }
}
