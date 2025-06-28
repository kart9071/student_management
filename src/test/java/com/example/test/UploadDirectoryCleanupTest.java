package com.example.test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

public class UploadDirectoryCleanupTest {

    private static final String UPLOAD_DIR = "D:/student-uploads";

    @Test
    private void testDeleteUploadDirectory() {
        StringBuilder report = new StringBuilder();

        File directory = new File(UPLOAD_DIR);

        boolean existedBefore = directory.exists();
        report.append("Directory Existed Before Deletion: ").append(existedBefore).append("\n");

        boolean deleted = deleteDirectory(directory);
        report.append("Deletion Attempted: ").append(deleted).append("\n");

        boolean existsAfter = directory.exists();
        report.append("Directory Exists After Deletion: ").append(existsAfter).append("\n");

        // Log report to console
        System.out.println(report.toString());

        // Optionally assert to enforce test correctness
        assertTrue(existedBefore, "Directory should exist before deletion");
        assertTrue(deleted, "Directory should be deleted successfully");
        assertFalse(existsAfter, "Directory should not exist after deletion");
    }

    private boolean deleteDirectory(File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
            return dir.delete();
        }
        return false;
    }
}