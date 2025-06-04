package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class RunSQLFileTest {

    @Test
    public void testRunSQLFile() {
        String jdbcURL = "jdbc:mysql://localhost:3306/studentsystem"; // your DB URL
        String username = "root";    // your DB username
        String password = "root";    // your DB password
        String sqlFilePath = "D:\\java EE project\\student-management\\schema.sql"; // your SQL file path

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             BufferedReader br = new BufferedReader(new FileReader(sqlFilePath))) {

            StringBuilder sqlStatement = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Skip empty lines and comments
                if (line.isEmpty() || line.startsWith("--") || line.startsWith("//") || line.startsWith("/*")) {
                    continue;
                }

                // Remove inline comments starting with --
                int commentIndex = line.indexOf("--");
                if (commentIndex != -1) {
                    line = line.substring(0, commentIndex).trim();
                }

                if (line.isEmpty()) {
                    continue;
                }

                sqlStatement.append(line).append(" ");

                // Check if line ends with semicolon (end of SQL statement)
                if (line.endsWith(";")) {
                    // Remove the trailing semicolon
                    String sqlToExecute = sqlStatement.toString().trim();
                    sqlToExecute = sqlToExecute.substring(0, sqlToExecute.length() - 1);

                    System.out.println("Executing SQL: " + sqlToExecute);

                    stmt.execute(sqlToExecute);
                    sqlStatement.setLength(0);  // Clear for next statement
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred while executing SQL script: " + e.getMessage());
        }
    }
}
