package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

public class DemoTestNG {

    private static WebDriver driver;
    private static EdgeOptions options;

    @BeforeClass
    static void setUp() throws InterruptedException {
        options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        // System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver(options);
        String appUrl = "https://www.bing.com";
        driver.get(appUrl);

        Thread.sleep(3000);
    }

    @Test
    void fo() {

    }

    @AfterClass
    static void tearDown(){
        driver.quit();;
    }

}
