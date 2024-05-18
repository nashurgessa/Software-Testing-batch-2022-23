package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableHandling {
    static WebDriver driver;

    @BeforeAll
    static void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Load
        driver.get("file:///Users/nashu/Desktop/Source_code/software_testing/DB-practices/Code/jdbc_demo/Selenium_class2/src/test/resources/table_demo.html");
        Thread.sleep(2000);
    }
    @Test
    void testTable() {
        // Locate the table
        WebElement table = driver.findElement(By.id("data-table"));
        // Fetch all row of the elements
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        // System.out.println("Num of rows: "+ rows.size()); // 4
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t\t");
            }
            System.out.println();
        }
    }
    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
