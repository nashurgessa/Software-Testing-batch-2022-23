package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BMICalculatorTest {
    WebDriver driver;
    WebDriverWait myWait;
    @BeforeEach
    void setUp(){
        driver = new EdgeDriver();
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.texasheart.org/heart-health/heart-information-center/topics/body-mass-index-bmi-calculator/");
    }
    @Test
    void testBMI() {
        WebElement height = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[2]/input")));
        WebElement weight = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[3]/input")));

        height.sendKeys("175");
        weight.sendKeys("71");

        WebElement btnCalculateBMI =  myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[4]/input")));

        btnCalculateBMI.click();

        // WebElement result = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[2]/input")));
        // WebElement result = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.result-input")));
        // double result_ = Double.parseDouble(result.getText()); // 23.18
        double  result_ = Double.parseDouble(result.getAttribute("value"));
        Assertions.assertEquals(result_, 23.2, 0.2);
    }
    @AfterEach
     void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
