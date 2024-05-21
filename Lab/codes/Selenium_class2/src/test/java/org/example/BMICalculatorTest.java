package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class BMICalculatorTest {
    WebDriver driver;
    WebDriverWait myWait;
    @BeforeClass
    void setUp() {
        driver = new EdgeDriver();
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.texasheart.org/heart-health/heart-information-center/topics/body-mass-index-bmi-calculator/");
    }

    @Test(dataProvider = "bmi_data")
    void testBMIWithDifferentInputs(String h, String w, String bmiResult) {
        WebElement height = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[2]/input")));
        WebElement weight = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/article/div/div/form/fieldset/div[2]/div[1]/div[2]/div[3]/input")));

        height.clear();
        weight.clear();

        height.sendKeys(h);
        weight.sendKeys(w);
        WebElement calculateBtn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.cta")));

        calculateBtn.click();

        WebElement result = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/article/div/div/form/fieldset/div[2]/div[2]/input")));
        myWait.until((WebDriver  d) ->  !result.getAttribute("value").isEmpty());
        Assert.assertEquals(Double.parseDouble(bmiResult),Double.parseDouble(result.getAttribute("value")), 0.2);

    }
    @DataProvider(name="bmi_data")
    public Object[][] bmiInputData() {
        return new Object[][]{
                {"180", "70", "21.6"},
                {"160", "80", "31.2"},
                {"170", "65", "22.5"}
        };
    }


    @AfterClass
    void tearDown() {
        if(driver != null) {
            driver.quit();

        }
    }
}
