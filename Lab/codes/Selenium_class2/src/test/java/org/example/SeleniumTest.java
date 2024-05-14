package org.example;

//  import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {
    static WebDriver driver;

    @BeforeMethod
    void setUp() {
        // Initialize the WebDriver instance using EdgeDriver
        driver = new EdgeDriver();
        //driver.get("https://www.baidu.com");
    }

    @Test
    void testBaidu() throws InterruptedException {
        // Baidu
        driver.get("https://www.baidu.com");

        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        Thread.sleep(2000);

        // Set the desired value in the textarea
        textArea.sendKeys("Neusoft institute guangdong");
        Thread.sleep(3000);

        // Simulate pressing the Enter key
        textArea.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }


    @Test
    void testBing() throws InterruptedException {
        // Baidu
        driver.get("https://www.bing.com");

        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
        Thread.sleep(2000);

        // Set the desired value in the textarea
        textArea.sendKeys("Neusoft Institute Guandong");
        Thread.sleep(3000);

        // Simulate pressing the Enter key
        textArea.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }


    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
