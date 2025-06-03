package com.example.servlet;

import java.io.IOException;

import com.example.dao.UserDAO;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        UserDAO dao=new UserDAO();
        User user=dao.validateUser(username, password);

        if(user!=null){
            HttpSession session=req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
        
        if("admin".equalsIgnoreCase(user.getRole())){
            res.sendRedirect("adminDashboard.jsp");
        }
        else{
            res.sendRedirect("studentDashboard.jsp");
        }
    }
    else{
        res.sendRedirect("login.jsp?error=1");
    }

    }
}
