package com.example.servlet;

import java.io.IOException;

import com.example.dao.UserDAO;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name=req.getParameter("name");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String role=req.getParameter("role");
        
        User user =new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        UserDAO dao=new UserDAO();
        dao.saveUser(user);
        resp.sendRedirect("success.jsp");
    }


}
