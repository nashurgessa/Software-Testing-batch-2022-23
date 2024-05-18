package org.example.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        loginButton.click();

        WebElement logoutLink = driver.findElement(By.linkText("Log out"));
        assert logoutLink.isDisplayed();

        // Check logout success
        //WebElement loginButtonAgain = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        //assertTrue(loginButtonAgain.isDisplayed(), "Logout failed, login button not displayed after logout.");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
