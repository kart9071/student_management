package com.example.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        AbandonedConnectionCleanupThread.checkedShutdown();
        System.out.println("AbandonedConnectionCleanupThread shutdown complete.");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Optional: Initialization logic
    }
}
