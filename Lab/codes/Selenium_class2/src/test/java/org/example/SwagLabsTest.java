package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SwagLabsTest {
    WebDriver driver;
    WebDriverWait myWait;
    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        // Waits for driver to be loaded for 5 seconds
        // myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void testLogin() throws InterruptedException{
        // username xpath = //*[@id="user-name"]
        // WebElement username = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user-name\"]")));
        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        // password xpath = //*[@id="password"]
        // WebElement password = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        // loginButton xpath = //*[@id="login-button"]
        // WebElement btnLogin = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-button\"]")));
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        username.sendKeys("performance_glitch_user");
        password.sendKeys("secret_sauce");

        //Thread.sleep(2000);

        btnLogin.click();

        // Verify that after login, the URL changes to the inventory page
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

        Thread.sleep(10000);
    }

    @AfterEach
    void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
