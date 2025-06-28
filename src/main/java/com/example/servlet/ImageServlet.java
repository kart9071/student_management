package com.example.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    private static final String IMAGE_DIR = "D:/student-uploads";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the requested file name from URL: /images/<filename>
        String requestedFile = request.getPathInfo(); // e.g. "/abc.jpg"
        if (requestedFile == null || requestedFile.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Image name is required.");
            return;
        }

        // Remove leading slash
        String fileName = requestedFile.substring(1);
        File imageFile = new File(IMAGE_DIR, fileName);
        System.out.println("ImageServlet called for file: " + fileName);

        if (!imageFile.exists() || imageFile.isDirectory()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found.");
            return;
        }

        // Set content type (e.g. image/jpeg, image/png)
        String mimeType = getServletContext().getMimeType(imageFile.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLengthLong(imageFile.length());

        // Stream image content to the response output stream
        Files.copy(imageFile.toPath(), response.getOutputStream());
    }
}
