package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown {
    static WebDriver driver;
    @BeforeAll
    static void setUp() {
        driver = new EdgeDriver();  // Ensure EdgeDriver is imported

        driver.get("http://127.0.0.1:3000/Lab/codes/frontend/index_test.html");

        // maximize the window
        driver.manage().window().maximize();
    }

    @Test
    void testComboBox() throws InterruptedException {
        // Go to Bing
        driver.findElement(By.linkText("Bing")).click();

        // navigate back to previous page
        driver.navigate().back();
        Thread.sleep(3000);

        // Select the first operator using "select by value"
        Select selectByValue = new Select(driver.findElement(By.id("SelectId_One")));
        selectByValue.selectByValue("greenValue");
        Thread.sleep(3000);

        // Select the second operator using "select by visible text"
        Select visibleText = new Select(driver.findElement(By.id("SelectID_Two")));
        visibleText.selectByVisibleText("Lime");
        Thread.sleep(3000);

        // Select third dropDown using "select by index"
        Select selectedIndex = new Select(driver.findElement(By.id("SelectID_Three")));
        selectedIndex.selectByIndex(2);
        Thread.sleep(3000);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
