package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BMITest {

    WebDriver driver;
    WebDriverWait myWait;

    @BeforeClass
    void setUp(){
        driver = new EdgeDriver();
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.texasheart.org/heart-health/heart-information-center/topics/body-mass-index-bmi-calculator/");

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
        myWait.until((WebDriver d) -> !result.getAttribute("value").isEmpty());
        String resultText = result.getAttribute("value");

        assertEquals(22.85, Double.parseDouble(resultText), 0.2);
    }

    //@DataProvider(name = "bmi_datas")
    //public Object[][] bmiDatas() {
    //    return new Object[][]{
    //            {"student", "Password123", ""},
    //            {"invalidUser", "Password123", "Your username is invalid!"},
    //            {"student", "inavalidPassword", "Your password is invalid"},
    //    };
    //}

    @DataProvider(name="bmi_datas")
    public Object[][] bmiData() {
        return new Object[][] {
                {"180", "70", "21.6"},
                {"160", "80", "31.2"},
                {"170", "65", "22.5"}
        };
    }

    @Test(dataProvider = "bmi_datas")
    void testBM(String height, String weight, String result) {
        WebElement heightWeb = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[2]/input")));
        WebElement weightWeb = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[3]/input")));

        heightWeb.clear();
        weightWeb.clear();

        heightWeb.sendKeys(height);
        weightWeb.sendKeys(weight);

        WebElement btnCalculateBMI = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[4]/input")));
        btnCalculateBMI.click();

        WebElement result_ = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[2]/input")));
        // myWait.until((WebDriver d) -> !result_.getAttribute("value").isEmpty());
        assertEquals(Double.valueOf(result_.getAttribute("value")), Double.valueOf(result), 0.1);
    }

    @AfterClass
    void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
