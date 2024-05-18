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
    static void setUp() throws InterruptedException{
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

        Thread.sleep(2000);

        String appUrl = "file:///Users/nashu/Desktop/Source_code/software_testing/SoftwareTesting/Lab/codes/selenium_test/src/main/resources/index.html";
        driver.get(appUrl);

        // maximize the window
        driver.manage().window().maximize();
    }

    @Test
    public void testWebElements() throws InterruptedException{
        //
        //// Go to Bing
        //driver.findElement(By.linkText("Bing")).click();
        //Thread.sleep(2000);
        //// navigate back to previous page
        //driver.navigate().back();
        //Thread.sleep(2000);


        // Select by visible text
        Select colorDropdown = new Select(driver.findElement(By.id("colorSelector")));
        colorDropdown.selectByVisibleText("Green");
        Thread.sleep(1000);

        // Select by value
        Select fruitDropDown = new Select(driver.findElement(By.id("fruitSelector")));
        fruitDropDown.selectByValue("banana");
        Thread.sleep(1000);

        // TextField
        WebElement textField = driver.findElement(By.id("nameInput"));
        textField.sendKeys("Neusoft");
        Thread.sleep(2000);

        // Male RadioButton
        WebElement maleRadioButton = driver.findElement(By.xpath("/html/body/fieldset[1]/label[1]"));
        maleRadioButton.click();
        Thread.sleep(2000);

        // female RadioButton
        WebElement femaleRadioButton = driver.findElement(By.xpath("/html/body/fieldset[1]/label[2]"));
        femaleRadioButton.click();
        Thread.sleep(2000);


        // Select by value
        Select countries = new Select(driver.findElement(By.id("countrySelect")));
        countries.selectByIndex(3);
        Thread.sleep(1000);


    }

    @AfterAll
    static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
