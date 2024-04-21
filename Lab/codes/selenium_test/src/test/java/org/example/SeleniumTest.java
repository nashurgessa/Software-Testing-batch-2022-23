package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private static EdgeOptions options;
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        options = new EdgeOptions();  // Initialize the EdgeOptions object
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver(options);  // Ensure EdgeDriver is imported

        driver.get("https://www.bing.com");
    }

    @Timeout(2)  // 2 seconds
    @Test
    void testSteps() throws InterruptedException {
        // Implement test steps here
        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
        Thread.sleep(2000);

        // Set the desired value in the textarea
        textArea.sendKeys("Neusoft institute guangdong");
        Thread.sleep(2000);

        // Simulate pressing the Enter key
        textArea.sendKeys(Keys.ENTER);
    }


    @AfterAll
    static void tearDown() {  // Renamed from tearUp to tearDown for clarity
        // driver.quit();  // Changed from close to quit to completely exit the browser session
    }

}
