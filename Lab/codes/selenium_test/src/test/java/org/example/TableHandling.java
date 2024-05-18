package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TableHandling {
    private WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        Thread.sleep(2000);
        driver.get("file:///Users/nashu/Desktop/Source_code/software_testing/SoftwareTesting/Lab/codes/selenium_test/src/test/resources/table_demo.html");
        // driver.manage().window().maximize();
    }
    @Test
    public void testReadTTable() {
        // Locate the table
        WebElement table = driver.findElement(By.id("data-table"));

        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        System.out.println("Num of rows: "+ rows);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
