package com.example.junit_demo;

public class PerformanceUtils {

    public String longRunningTask() {
        try {
            Thread.sleep(3000); // 3 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}
