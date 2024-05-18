package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BMITest {

    WebDriver driver;
    WebDriverWait myWait;

    @BeforeClass
    void setUp(){
        driver = new EdgeDriver();
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.texasheart.org/heart-health/heart-\n" +
                "information-center/topics/body-mass-index-bmi-calculator/");

        // driver.manage().window().maximize();
    }

    @Test
    void testBMI() throws InterruptedException {
        // //*[@id="post-601"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[2]/input
        WebElement height = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[2]/input")));
        // //*[@id="post-601"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[3]/input
        WebElement weight = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[3]/input")));
        // //*[@id="post-601"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[4]/input

        height.sendKeys("175");
        weight.sendKeys("70");

        WebElement btnCalculateBMI = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[4]/input")));
        // //*[@id="post-601"]/div/div/form/fieldset/div[2]/div[2]/input
        // WebElement result = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result-input")));

        btnCalculateBMI.click();

        // Wait until the result is not empty
        WebElement result = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[2]/input")));
        // myWait.until((WebDriver d) -> !result.getAttribute("value").isEmpty());

        String resultText = result.getAttribute("value");
        System.out.println("Result: " + resultText);

        // Parse the result to double and assert
        double resultValue = Double.parseDouble(resultText);
        Assertions.assertEquals(22.85, resultValue, 0.2, "BMI calculation does not match expected value.");

    }


    @AfterClass
    void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
