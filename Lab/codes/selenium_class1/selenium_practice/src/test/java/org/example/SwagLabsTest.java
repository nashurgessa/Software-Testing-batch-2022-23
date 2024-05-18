package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsTest {
    WebDriver driver;
    WebDriverWait myWait;

    WebElement username;
    WebElement password;
    WebElement btnLogin;

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        //
        myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        username = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user-name\"]")));
        password = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        btnLogin = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-button\"]")));
    }
    @Test
    @Disabled
    void standardTest() {
        WebElement username = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user-name\"]")));
        WebElement password = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        WebElement btnLogin = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-button\"]")));
        btnLogin.click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));

    }

    @Test
    void lockedOutTest() {
        username.sendKeys("locked_out_user");
        password.sendKeys("secret_sauce");

        btnLogin.click();

        //*[@id="login_button_container"]/div/form/div[3]/h3/button/svg
        WebElement errMessage = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container.error")));

        Assertions.assertTrue(errMessage.getText().contains("Sorry, this user has been locked out."));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}
