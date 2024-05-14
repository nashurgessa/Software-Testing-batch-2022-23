package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FindingLinks {
    WebDriver driver;
    @BeforeClass
    void setUp() throws InterruptedException{
        driver = new EdgeDriver();
        Thread.sleep(1000);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(1000);
    }

    @Test
    void countNumberofLinks(){
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        for(WebElement  e: links) {
            System.out.println(e.getText());
        }
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
