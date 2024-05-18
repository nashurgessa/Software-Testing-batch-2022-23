package org.example;

import org.testng.annotations.Test;

public class TimeoutExampleTestNG {
    @Test(timeOut = 2000) // timeout in milliseconds
    public void testMethodWithTimeout() {
        try {
            // Simulating a long-running process
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted, Failed to complete operation");
        }
    }
}
