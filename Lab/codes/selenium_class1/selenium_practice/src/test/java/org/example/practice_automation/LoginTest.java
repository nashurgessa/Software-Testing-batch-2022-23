package org.example.practice_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    WebDriverWait myWait;
    WebElement username;
    WebElement password;
    WebElement btnLogin;
    @BeforeClass // @BeforeMethod
    void setUp() {
        driver = new EdgeDriver();
        myWait  = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //
        username = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        password =  myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        btnLogin = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

    }
    @BeforeMethod
    void clearField() {
        username.clear();
        password.clear();
    }

    @Test
    void PositiveLoginTest() {
        username.sendKeys("student");
        password.sendKeys("Password123");
        btnLogin.click();

        WebElement btnLogout = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div/div/div/a")));
        Assert.assertTrue(btnLogout.isDisplayed());
        // logout
        btnLogout.click();
    }

    @Test
    void negativeUsernameTest() {
        username.sendKeys("incorrectUser");
        password.sendKeys("Password123");
        btnLogin.click();

        WebElement error = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(error.getText().contains("Your username is invalid!"));
    }

    @Test
    void negativePasswordTest() {
        username.sendKeys("student");
        password.sendKeys("incorrectPassword");
        btnLogin.click();

        WebElement error = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(error.getText().contains("Your password is invalid!"));
    }

    @DataProvider(name="login_data")
    public Object[][] loginData() {
      return new Object[][] {
            {"student", "Password123", ""},
            {"incorrectUser", "Password123", "Your username is invalid!"},
            {"student", "incorrectPassword", "Your password is invalid!"}
        };
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
