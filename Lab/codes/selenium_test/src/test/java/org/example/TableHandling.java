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
    public void setUp() {
        // System.setProperty("webdriver.edge.driver", "path_to_edgedriver");
        driver = new EdgeDriver();
        driver.get("http://localhost:63342/selenium_test/Lab/codes/selenium_test/src/test/resources/table_demo.html?_ijt=acb4345dflv9fivlmand66qimj&_ij_reload=RELOAD_ON_SAVE");
        driver.manage().window().maximize();
    }

    @Test
    public void testReadTTable() {
        // Locate the table
        WebElement table = driver.findElement(By.id("data-table"));

        // Fetch all row of the elements
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // print data from eaach row
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));

            for (WebElement col: cols) {
                System.out.print(col.getText() + "\t\t");
            }
            System.out.println();
        }
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

}
