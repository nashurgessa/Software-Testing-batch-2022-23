package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class MoreWebElementTest {
    WebDriver driver;
    WebDriverWait myWait;
    @BeforeClass
    void setUp() {
        driver = new EdgeDriver();
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(enabled = false)
    void formTest() throws InterruptedException{
        // name
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Neusoft");
        Thread.sleep(2000);
        // email
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("chala@nuit.edu.cn");
        Thread.sleep(2000);
        // phone
        WebElement  phone  = driver.findElement(By.id("phone"));
        phone.sendKeys("136201");
        Thread.sleep(2000);

        // Address
        WebElement address = driver.findElement(By.id("textarea"));
        address.sendKeys("Neusoft \n Institute");
        Thread.sleep(2000);

        // RadioButton
        WebElement genderMale = driver.findElement(By.id("male"));
        genderMale.click();
        Thread.sleep(2000);

        // RadioButton
        WebElement genderFemale = driver.findElement(By.id("female"));
        genderFemale.click();
        Thread.sleep(2000);

        // CheckBox
        WebElement sunday = driver.findElement(By.id("sunday"));
        WebElement wednesday = driver.findElement(By.id("wednesday"));

        sunday.click();
        wednesday.click();
        Thread.sleep(2000);

        // DropDown
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("China");
        Thread.sleep(2000);

        Select color = new Select(driver.findElement(By.id("colors")));
        color.selectByIndex(3);
        Thread.sleep(2000);

        // Day Picker
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("05/14/2024");
        // datePicker.click();
        Thread.sleep(2000);

        // link
        WebElement cart = driver.findElement(By.linkText("open cart"));
        cart.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("opencart"));
        Thread.sleep(2000);
        driver.navigate().back();
    }

    @Test(enabled = false)
    void orangeHRMTest() throws InterruptedException {
        //
        WebElement orangeHRM = driver.findElement(By.linkText("orange HRM"));
        orangeHRM.click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("orangehrmlive"));

        WebElement username = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        Thread.sleep(2000);

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        Thread.sleep(3000);

        WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginBtn.click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("orangehrmlive"));

        WebElement actionIcon = driver.findElement(By.id("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/span"));
        Thread.sleep(2000);
        actionIcon.click();

        WebElement btnLogout = driver.findElement(By.linkText("Logout"));
        btnLogout.click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test
    void searchBox()throws InterruptedException {
        // Locate the WebElement

        WebElement wikipediaSearch = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
        Thread.sleep(2000);
        wikipediaSearch.sendKeys("Selenium");

        WebElement iconSearch = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div/div[1]/div[1]/form/div/span[2]/span[2]/input"));
        iconSearch.click();
        Thread.sleep(2000);

        // Search result
        WebElement searchResults = driver.findElement(By.id("Wikipedia1_wikipedia-search-results"));

        List<WebElement> links = searchResults.findElements(By.tagName("a"));



    }

    @Test
    void newWindowTest() throws InterruptedException{
        // System.out.println(driver.getWindowHandle());
        WebElement btnNewWindow = driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button"));
        btnNewWindow.click();
        Thread.sleep(2000);

        String originalTab = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for  (String windowHandle: windowHandles) {
            if(!windowHandle.equals(originalTab)){
                driver.switchTo().window(windowHandle);
            }
            System.out.println(driver.getTitle());
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("opencart"));
    }


    @Test
    void alertTest() throws InterruptedException{
        WebElement confirmBtn  = driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[2]"));
        Thread.sleep(1000);
        confirmBtn.click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }
    @Test
    void actionTest() throws InterruptedException {
        Actions actions=  new Actions(driver);
        //WebElement btnCopyText = driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
        //
        //// double click
        //Thread.sleep(1000);
        //actions.doubleClick(btnCopyText).perform();
        //
        //Thread.sleep(5000);
        //
        //// drag DROP
        //WebElement source = driver.findElement(By.id("draggable"));
        //WebElement destination = driver.findElement(By.id("droppable"));
        //actions.dragAndDrop(source, destination).perform();
        //
        //Thread.sleep(5000);

        // slidebar
        WebElement slideBar = driver.findElement(By.id("slider"));
        actions.clickAndHold(slideBar).moveByOffset(60, 0).release().perform();
        Thread.sleep(5000);

    }

}
