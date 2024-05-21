package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class AutomationTest {

    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    void testForm() throws InterruptedException{
        // name
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Neusoft");
        Thread.sleep(2000);

        // email
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("chala@nuit.edu.cn");
        Thread.sleep(2000);

        // phone
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("+861-136098099");
        Thread.sleep(2000);

        // Address
        WebElement address = driver.findElement(By.id("textarea"));
        address.sendKeys("Neusfot \n Institute");
        Thread.sleep(2000);

        // Gender, RadioButton
        WebElement male  = driver.findElement(By.id("male"));
        male.click();
        Thread.sleep(2000);

        WebElement female = driver.findElement(By.id("female"));
        female.click();
        Thread.sleep(2000);

        // date, CheckBox
        WebElement sunday = driver.findElement(By.id("sunday"));
        sunday.click();
        Thread.sleep(2000);

        // date, CheckBox
        WebElement wednesday = driver.findElement(By.id("wednesday"));
        wednesday.click();
        Thread.sleep(2000);

        // Country
        Select country= new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("China");
        Thread.sleep(2000);

        // Colors
        Select colors = new Select(driver.findElement(By.id("colors")));
        colors.selectByIndex(3);
        Thread.sleep(2000);

        // DatePicker
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("05/17/2024");
        Thread.sleep(2000);

        // link
        WebElement openCartLink = driver.findElement(By.linkText("open cart"));
        openCartLink.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("opencart"));
        Thread.sleep(2000);
        driver.navigate().back();
    }

    @Test
    void orangeHRMTest() throws InterruptedException {
        WebElement orangeHRMLink = driver.findElement(By.linkText("orange HRM"));
        orangeHRMLink.click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("orangehrmlive"));

        WebElement username = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        WebElement password = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        WebElement btnLogin = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

        Thread.sleep(1000);
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        Thread.sleep(2000);
        btnLogin.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        // Continue to logout
        WebElement profileIcon = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li"));
        Thread.sleep(2000);

        // logout btn
        WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
        logoutBtn.click();
        Thread.sleep(2000);

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }


    @Test
    void searchOnWikipedia() throws InterruptedException{
        WebElement textField = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
        textField.sendKeys("Java");
        Thread.sleep(2000);

        WebElement searchResults = driver.findElement(By.id("Wikipedia1_wikipedia-search-results"));
        Thread.sleep(4000);
        List<WebElement> search_results = searchResults.findElements(By.xpath("//*[@id='wikipedia-search-result-link']/a"));
        System.out.println(search_results.size());
        for (WebElement result: search_results) {
            System.out.println(result.getText());
        }
    }

    @Test
    void windowTest() throws InterruptedException {
        // System.out.println(driver.getWindowHandle());
        WebElement newTabBtn = driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button"));
        newTabBtn.click();

        String originalWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows.size());
        System.out.println("Original title: " +  driver.getTitle());
        for (String handle: allWindows){
            //System.out.println(handle);
            if(!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                System.out.println("New Window title: " + driver.getTitle());
            }
        }
    }

    @Test
    void testAlert() throws InterruptedException {
        // Locator
        WebElement btnAlert  = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div/div[3]/div[1]/button[2]"));
        btnAlert.click();
        Thread.sleep(2000);

        // driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

    }

    @Test
    void actionTest() throws InterruptedException {

        Actions action = new Actions(driver);

        //doubleclick
        WebElement copyTextBtn= driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
        action.doubleClick(copyTextBtn).perform();
        Thread.sleep(5000);

        // drag and drop
        WebElement source= driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
        action.dragAndDrop(source,destination).perform();
        Thread.sleep(5000);

        //  Slider
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
        action.clickAndHold(slider).moveByOffset(50, 0).release().perform();
        Thread.sleep(5000);

        // Resize
        WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]"));
        action.clickAndHold(resizable).moveByOffset(70, 150).release().perform();
        Thread.sleep(5000);

    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
