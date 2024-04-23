package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class HandlingWebElementsTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        EdgeOptions options = new EdgeOptions();
         options.addArguments("--remote-allow-origins=*");
         System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/msedgedriver.exe");
         driver = new EdgeDriver(options);

        if (driver == null) {
            throw new IllegalStateException("Driver did not initialize. Please check your WebDriver executable path and configurations.");
        }

        String appUrl = "http://127.0.0.1:3000/Lab/codes/frontend/web_elements.html";
        driver.get(appUrl);

        // maximize the window
        driver.manage().window().maximize();
    }

    @Test
    void foo() {

    }

    @Test
    public void testDropDowns() throws InterruptedException{

        // Go to Bing
        driver.findElement(By.linkText("Bing")).click();
        Thread.sleep(2000);
        // navigate back to previous page
        driver.navigate().back();
        Thread.sleep(2000);


        // Select by visible text
        Select colorDropdown = new Select(driver.findElement(By.id("colorSelector")));
        colorDropdown.selectByVisibleText("Green");
        Thread.sleep(1000);

        // Select by value
        Select fruitDropDown = new Select(driver.findElement(By.id("fruitSelector")));
        fruitDropDown.selectByValue("banana");
        Thread.sleep(1000);

        // Fill then name Field
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.sendKeys("Neusoft Institute Guangdong");


        // Handling radio buttons
        WebElement maleRadio = driver.findElement(By.xpath("//input[@name='gender'][@value='male']"));
        maleRadio.click();
        Thread.sleep(1000);

        // Handling checkboxes
        WebElement sportsCheckbox = driver.findElement(By.xpath("//input[@name='hobby'][@value='sports']"));
        if (!sportsCheckbox.isSelected()) {
            sportsCheckbox.click();
        }
        Thread.sleep(1000);

        // select by index
        Select countryDropdown = new Select(driver.findElement(By.id("countrySelect")));
        countryDropdown.selectByIndex(1);
        Thread.sleep(1000);

        // Submitting the form
        driver.findElement(By.id("submitBtn")).click();
        Thread.sleep(1000);
    }

    @AfterAll
    static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
