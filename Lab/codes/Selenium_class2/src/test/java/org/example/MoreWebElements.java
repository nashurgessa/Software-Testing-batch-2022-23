package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class MoreWebElements {
    WebDriver driver;
    //WebDriverWait myWait;
    @BeforeMethod
    void setUp(){
        driver = new EdgeDriver();
        //myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @AfterMethod
    void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }

    @Test
    public void testFormElements() {
        // Name
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("Gemachis");
        Assert.assertEquals(nameField.getAttribute("value"), "Gemachis");

        // Email
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("gem@example.com");
        Assert.assertEquals(emailField.getAttribute("value"), "gem@example.com");

        // Phone
        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys("1234567890");
        Assert.assertEquals(phoneField.getAttribute("value"), "1234567890");

        // Address
        WebElement addressField = driver.findElement(By.id("textarea"));
        addressField.sendKeys("123 Main St");
        Assert.assertEquals(addressField.getAttribute("value"), "123 Main St");

        // Gender
        WebElement genderMale = driver.findElement(By.id("male"));
        genderMale.click();
        Assert.assertTrue(genderMale.isSelected());

        //WebElement genderFemale = driver.findElement(By.id("female"));
        //genderFemale.click();
        //Assert.assertTrue(genderFemale.isSelected());

        // Days
        WebElement dayMonday = driver.findElement(By.id("monday"));
        dayMonday.click();
        Assert.assertTrue(dayMonday.isSelected());

        // Country
        Select countryDropdown = new Select(driver.findElement(By.id("country")));
        countryDropdown.selectByValue("china");
        Assert.assertEquals(countryDropdown.getFirstSelectedOption().getText(), "China");

        // Colors
        Select colorRed = new Select(driver.findElement(By.id("colors")));
        colorRed.selectByVisibleText("Green");
        Assert.assertEquals(colorRed.getFirstSelectedOption().getText(), "Green");

        // Date
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("05/17/2024");
        Assert.assertEquals(dateField.getAttribute("value"), "05/17/2024");

        // link
        WebElement openCartLink = driver.findElement(By.linkText("open cart"));
        openCartLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("opencart"));
        driver.navigate().back();

    }

    @Test
    public void testOrangeHRMLink() throws InterruptedException{
        String preOriginWindow = driver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        // Orange HRM link
        WebElement orangeHRMLink = driver.findElement(By.linkText("orange HRM"));
        orangeHRMLink.click();
        Thread.sleep(2000);
        // Switch to the new OrangeHRM page
        //for (String handle : driver.getWindowHandles()) {
        //    if (!handle.equals(preOriginWindow)) {
        //        driver.switchTo().window(handle);
        //        break;
        //    }
        //}
        // Wait for the page to load
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());

        // Wait for the login elements to be present
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        // Perform login on OrangeHRM
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

        System.out.println("On Login: "+ driver.getCurrentUrl());

        // wait.until(ExpectedConditions.urlContains("dashboard"));
        // Verify login by checking the URL contains 'dashboard'
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Thread.sleep(3000);
        //List<WebElement> links = driver.findElements(By.tagName("a"));
        //for (WebElement link: links){
        //    System.out.println(link.getText());
        //}
        // logout
        WebElement userAccount = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li"));
        userAccount.click();
        Thread.sleep(1000);

        WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
        logoutBtn.click();
        Thread.sleep(2000);
        System.out.println("After logout: " + driver.getCurrentUrl());

        // Close the OrangeHRM window and switch back to the original window
        // driver.close();
        driver.switchTo().window(preOriginWindow);
        System.out.println("After switched window: "+driver.getCurrentUrl());
        // Thread.sleep(5000);
        Thread.sleep(1000);
        driver.navigate().back(); // stack
        driver.navigate().back();  // stack
        driver.navigate().back(); // stack
    }

    @Test
    public void testSearchBox() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
        searchBox.sendKeys("Selenium");
        WebElement searchButton = driver.findElement(By.className("wikipedia-search-button"));
        searchButton.click();
        WebElement searchResult = driver.findElement(By.className("wikipedia-search-results"));
        Thread.sleep(5000);
        Assert.assertTrue(searchResult.isDisplayed(), "Search results should be displayed.");

        List<WebElement> search_results = driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']/a"));

        System.out.println(search_results.size());

        for(WebElement e:search_results)
        {
            String link=e.getText();
            driver.findElement(By.linkText(link)).click();
        }

    }

    @Test
    public void testNewBrowser() throws InterruptedException {
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button"));
        // get current window , unique identifier (window handle) for the current browser window or tab.
        String originalWindow = driver.getWindowHandle();

        btn.click();
        Thread.sleep(2000);
        //  wait.until(ExpectedConditions.numberOfWindowsToBe(2))
        // New Window/Tab:
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle: allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("opencart"));
        driver.close();
        Thread.sleep(2000);
        driver.switchTo().window(originalWindow);
    }

    @Test
    void testAlert() throws InterruptedException {
        // WebElement btnAlert = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[1]")));
        WebElement btnAlert = driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[2]"));
        btnAlert.click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept(); // closes popup by using OK button
        //driver.switchTo().alert().dismiss();//closes popup by using Cancel button
        Thread.sleep(5000);
        Assert.assertTrue(true, "Alert was successfully handled");
    }

    @Test
    void actions() throws InterruptedException {
        //WebElement field1 = driver.findElement(By.id("field1"));
        //Thread.sleep(2000);

        Actions actions = new Actions(driver);

        // Double click
        WebElement field2  = driver.findElement(By.id("field2"));
        WebElement doubleClickBtn  = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div/div[4]/div[1]/button"));
        actions.doubleClick(doubleClickBtn).perform();
        Assert.assertTrue(field2.getAttribute("value").contains("Hello"));
        Thread.sleep(3000);

        // Drag and Drop interaction
        WebElement source = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div/div[5]/div[1]/div[1]"));
        WebElement target = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div/div[5]/div[1]/div[2]"));
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(3000);

        // Slider interaction
        WebElement slider = driver.findElement(By.id("slider"));
        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();
    }

    @Test
    void frame() throws InterruptedException {
        // Switch to and interact with a frame
        driver.switchTo().frame(driver.findElement(By.id("frame-one796456169")));
        Thread.sleep(3000);
        WebElement frameButton = driver.findElement(By.id("FSsubmit"));
        frameButton.click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }


}
