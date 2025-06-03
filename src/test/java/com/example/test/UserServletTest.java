package com.example.test;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.dao.UserDAO;
import com.example.model.User;
import com.example.servlet.UserServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServletTest {  // Make class public

    private UserServlet userServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;

    @BeforeEach
    public void setUp() {  // Make public
        userServlet = new UserServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    private void testDoGetShouldForwardToViewWithUsers() throws Exception {
        List<User> dummyUsers = Arrays.asList(
            new User(1,"alice", "Alice", "pass", "student"),
            new User(2,"bob", "Bob", "pass", "student")
        );

        UserDAO daoMock = mock(UserDAO.class);
        when(daoMock.getAllUsers()).thenReturn(dummyUsers);

        UserServlet userServlet = new UserServlet(daoMock);  // inject mock DAO

        when(request.getRequestDispatcher("viewUsers.jsp")).thenReturn(dispatcher);

        userServlet.doGet(request, response);

        verify(request).setAttribute("userList", dummyUsers);
        verify(dispatcher).forward(request, response);
    }
}
