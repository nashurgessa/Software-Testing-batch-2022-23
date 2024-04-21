

## Selenium Training Tutorials

### Introduction
Selenium is one of the most popular automated testing suites. Selenium is designed in a way to support and encourage automation testing of functional aspects of web based applications and a wide range of browsers and platforms. 

- Due to its existence in the open source community, it has become one of the most accepted tools amongst the testing professionals.



**Why Selenium?**

As the current industry trends have shown that there is mass movement towards automation testing. The cluster of repetitive manual testing scenarios has raised a demand to bring in the practice of automating these manual scenarios.

The benefits of implementing automation test are many; let us take a look at them:

* Supports execution of repeated test cases
* Aids in testing a large test matrix
* Enables parallel execution
* Encourages unattended execution
* Improves accuracy thereby reducing human generated errors
* Saves time and money

**Selenium supports a broad range of browsers, technologies and platforms.**

![1713498526532](image/L19-L32Selenium_practice/1713498526532.png)

**Selenium Components**

Selenium is not just a single tool or a utility, rather a package of several testing tools and for the same reason it is referred to as a Suite. 

Each of these tools is designed to cater different testing and test environment requirements.

***The suite package constitutes of the following sets of tools:***

* Selenium Integrated Development Environment (IDE)
* Selenium Remote Control (RC)
* Selenium WebDriver
*  Selenium Grid

Selenium RC and WebDriver, in a combination are popularly known as Selenium 2. Selenium RC alone is also referred as Selenium 1.


![1713498266728](image/L19-L32Selenium_practice/1713498266728.png)

Fig 1:- 

###### 1. Selenium IDE (Integrated Development Environment)

* **Overview** : Selenium IDE is a browser extension for Firefox and Chrome that allows developers and testers to record, edit, and debug tests.
* **Features** : It provides a user-friendly interface for creating automated tests without requiring extensive programming knowledge. Tests are created using a record-and-playback technique, although users can also write tests using a scripting language called Selenese.
* **Usage** : Ideal for beginners in test automation or for creating simple test scripts quickly. However, it lacks the robustness needed for more complex test scenarios

![1713499134474](image/L19-L32Selenium_practice/1713499134474.png)

Fig 2:- 

###### 2. Selenium Remote Control (RC)
* **Overview** : Selenium RC was one of the first tools in the Selenium project that allowed testers to write automated web application UI tests in any programming language against any HTTP website using any mainstream JavaScript-enabled browser.
* **Features** : Selenium RC worked by using a server that automatically launches and kills browsers, and acts as a proxy for web requests from them.
* **Usage** : It has largely been deprecated and replaced by WebDriver due to its more modern and stable architecture.

![1713499086335](image/L19-L32Selenium_practice/1713499086335.png)

Fig 3:- 

There are a few pre-requisites to be in place before creating Selenium RC scripts:
 A Programming Language – Java, C#, Python etc.
 An Integrated Development Environment –Eclipse, Netbeans etc.
 A Testing Framework (optional) – JUnit, TestNG etc.
 And Selenium RC setup off course

![1713499182807](image/L19-L32Selenium_practice/1713499182807.png)

Fig 4:- 

###### 3. Selenium WebDriver
* **Overview** : Selenium WebDriver is the successor to Selenium RC and provides all the capabilities of RC but with better support for modern web testing needs. It does this by making direct calls to the browser using each browser’s native support for automation.
* **Features** : More realistic interaction with web pages than Selenium RC, as it does not rely on JavaScript for automation. It supports programming in various languages like Java, C#, Python, Ruby, and JavaScript.
* **Usage** : WebDriver can handle more complex and advanced web automation tasks. It is widely used in industry for creating robust, browser-based regression automation suites and tests.

![1713499271108](image/L19-L32Selenium_practice/1713499271108.png)

Fig 5:- 

###### 4. Selenium Grid

* **Overview** : Selenium Grid allows the Selenium WebDriver scripts to run on different machines and different browsers simultaneously / concurrently.
* **Features** : It supports distributed test execution. A central hub distributes the tests to multiple nodes (machines), allowing tests to run in parallel, reducing the time for test execution and providing cross-browser, cross-platform testing capabilities.
* **Usage** : Ideal for large test suites that need to be executed in multiple environments. It helps in speeding up the execution of a test suite by using multiple machines.


#### Selenium 3
Selenium 3 is an advance version of Selenium 2. It is a tool focused for automation of mobile and web applications. Stating that it supports mobile testing, we mean to say that the WebDriver API has been extended  to address the needs of mobile application testing.

![1713499481144](image/L19-L32Selenium_practice/1713499481144.png)

Fig 6:- Selenium 3 Architecture

#### Selenium 4
Selenium 4 was introduced by Simon Stewart in 2018. However the stable version of Selenium 4 was released in October 2021. One of the major changes made in Selenium 4 was the introduction of W3C Webdriver protocol which replaced the previously used JSON wire protocol in Selenium 3. This article highlights the major differences between Selenium 3 and Selenium 4. 

![1713499489780](image/L19-L32Selenium_practice/1713499489780.png)

Fig 7:- Selenium 4 Architecture


###### Environment and Technology Stack

|Category |	Supported Technologies|
|---------|-----------------------|
|Operating Systems|	Windows, macOS, Linux, Unix-like systems
|Browsers (Selenium 4)|	Google Chrome, Mozilla Firefox, Internet Explorer, Safari, Microsoft Edge|
|Browser Drivers|	ChromeDriver, GeckoDriver (Firefox), IEDriverServer (IE), SafariDriver, EdgeDriver|
|Programming Languages|	Java, C#, Python, Ruby, JavaScript (Node.js), Kotlin, PHP|
|Testing Frameworks|	JUnit, TestNG, PyTest, RSpec, NUnit, Mocha, Jasmine|
|CI/CD Tools|	Jenkins, Travis CI, CircleCI, GitLab CI, Bamboo|
|Cloud Platforms|	Sauce Labs, BrowserStack, CrossBrowserTesting|
|IDEs|	Eclipse, IntelliJ IDEA, Visual Studio, PyCharm, WebStorm, RubyMine|

> Selenium 4 further enhances support for the latest browser-specific drivers, ensuring compatibility and optimized performance across the most commonly used web browsers. This includes:
- Google Chrome: Via ChromeDriver.
- Mozilla Firefox: Via GeckoDriver.
- Microsoft Edge: Via EdgeDriver.
- Safari: Integrated directly into the browser with SafariDriver.
- Internet Explorer: Though less commonly used now, still supported via IEDriverServer.


### Getting Started with Selenium IDE (Installation and its Features)


###### Selenium IDE Download and Installation

###### Configuring WebDriver
As we would be using Java as the programming language for this series and in order to create test scripts in java, we would have to introduce language- specific client drivers. Thus, let us begin with the downloading of Selenium Java Client Libraries.

***Download the Selenium Java Client Libraries***
***Step 1:*** Go to Selenium’s official website and navigate to its download page –
“http://docs.seleniumhq.org/download/”. 
Refer the section in the below illustration where you can find Client Libraries listed for distinct programming languages. Click on the download link for Java Client Library.

![1713501102544](image/L19-L32Selenium_practice/1713501102544.png)

Fig 8:- 

***Step 2:*** Once downloaded, copy the folder and place it in the desired location on your file system.

***Step 3:*** Extract the zipped folder, a folder named as “Selenium-java-4.19.1.zip“can be seen. The folder embodies all the required jar files which enable users to create test scripts in Java.

Thus these libraries can be configured in Intellij IDE

![1713501882931](image/L19-L32Selenium_practice/1713501882931.png)

Fig 9:-

***Configuring Libraries with Intellij IDE***
Step 1: Navigate towards Intellij IDE. Create a new java based project following File -> New -> Java Project. 

![1713503296718](image/L19-L32Selenium_practice/1713503296718.png)

Refer the following figure for the same

![1713503425921](image/L19-L32Selenium_practice/1713503425921.png)

https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java

https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.19.1

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.19.1</version>
</dependency>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>

<-- OR -->

<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.1</version>
    <scope>test</scope>
</dependency>

```

---

![1713507241531](image/L19-L32Selenium_practice/1713507241531.png)

---

![1713503804642](image/L19-L32Selenium_practice/1713503804642.png) 

**Rename Main.java to SeleniumTest.Java**

---
Now, time to doawnload the driver

first check your browser version
edge://settings/?search=update

![1713508625010](image/L19-L32Selenium_practice/1713508625010.png)

---

![1713506964249](image/L19-L32Selenium_practice/1713506964249.png)

https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/?form=MA13LH

![1713508843935](image/L19-L32Selenium_practice/1713508843935.png)

then extract

![1713507087943](image/L19-L32Selenium_practice/1713507087943.png)

---

Right click on test

![1713507292245](image/L19-L32Selenium_practice/1713507292245.png)

![1713507336373](image/L19-L32Selenium_practice/1713507336373.png)

Select Enter and click **Enter** keey

---

![1713507382900](image/L19-L32Selenium_practice/1713507382900.png)

---

copy the drive into the resource folder

![1713507454937](image/L19-L32Selenium_practice/1713507454937.png)

---

![1713507491908](image/L19-L32Selenium_practice/1713507491908.png)

---

![1713507573902](image/L19-L32Selenium_practice/1713507573902.png)


---

```java
public class SeleniumTest {

    @Test
    void setUp() {
        // Set the system property for the Microsoft Edge driver
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");

        // Initialize the WebDriver instance using EdgeDriver
        WebDriver driver = new EdgeDriver();
    }

}
```

***Explanation:***
1. `System.setProperty(String key, String value)`:
> This method is used to set a system property, and in this case, it is setting the path to the Microsoft Edge driver executable.

2. `System.getProperty("user.dir")`:
> This method returns the current working directory of the user's project. It's a useful way to build paths that are relative to the project directory, making your code more portable.

3. `EdgeDriver`:
> This initializes a new instance of EdgeDriver, which will control the Edge browser. Make sure that the `msedgedriver.exe` matches the version of your Microsoft Edge browser and that it's located in the specified directory within your project.

```java
@Test
void setUp() {
	// Set the system property for the Microsoft Edge driver
	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");

	// Initialize the WebDriver instance using EdgeDriver
	WebDriver driver = new EdgeDriver();

	driver.get("https://www.baidu.com");
}
```

and now run

```java
@Test
void setUp() {
	// EdgeOptions options = new EdgeOptions();
	// options.addArguments("--remote-allow-origins=*");

	// Set the system property for the Microsoft Edge driver
	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");

	// Initialize the WebDriver instance using EdgeDriver
	WebDriver driver = new EdgeDriver(); // if allow origins, then EdgeDriver(allow)
	

	driver.get("https://www.baidu.com");
}
```

---

Now time to open and quit the browser

```java
package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SeleniumTest {

    private static EdgeOptions options;
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        options = new EdgeOptions();  // Initialize the EdgeOptions object
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver(options);  // Ensure EdgeDriver is imported

        driver.get("https://www.bing.com");
    }

    @Test
    void testSteps() {
        // Implement test steps here
    }

    @AfterAll
    static void tearDown() { 
        driver.quit();  // quit to completely exit the browser session
    }
}
```

---

#### Time to test searching functionality of the Bing


##### What is Document Object Model (Dom)?

![1713514029991](image/L19-L32Selenium_practice/1713514029991.png)

##### Locators
Identification of the correct `GUI` element on a web page is pre-requisite for creating any successful automation script. It is where locators come into the picture. 
- Locators are one of the essential components of Selenium infrastructure, which help Selenium scripts in uniquely identifying the WebElements(such as `TextBox`, `Button`, etc.)

![1713513977052](image/L19-L32Selenium_practice/1713513977052.png)


> **Attributes-based locators:**
Attributes-based locators utilize the attributes of HTML elements to identify them on a web page. Common attributes include:
> - Identifier: Combines the id and name attributes for a broad match.
> - Id: Targets the unique identifier of an element.
> - Name: Selects the **first** element with a specified `name` attribute.
> - Link: Identifies links by the text they display.
> - CSS: Uses CSS selectors to define elements' styles and identify them.

> **Structure-based locators:**
These locators depend on the web page's structural elements to locate HTML elements:
It rely on the structure of the page to find elements.
> - DOM: Accesses elements based on their hierarchical relationship in the page structure.
> - XPATH:  Navigates through elements and attributes in an XML-like structure.
> - CSS: Identifies elements using style selectors which are both fast and versatile.

###### Location Techniques
```html
<html>
	<body>
		<form id="loginForm">
			<input name="email" type="text"/>
			<input name="password" type="password"/>
			<input name="continue" type="submit" value="Login"/>
			<input name="clear" type="password" value="Login"/>
			<a href="continue.html">Continue</a>
			<a href="cancel.html">Cancel</a>
		</form>
	</body>
</html>
```

**Identifier:**
- Example: `identifier=loginForm`, `identifier=password`

**Id:**
- Example: `id=loginForm`

**Name:** 
- Example: `name=username`, `name=continue`.

**Link:**
- Example: `link=Continue`, `link=Cancel`

**DOM:** 
- Example: `dom = document.getElementByld('loginForm')`, </br> `dom = document.forms['loginForm']`

**CSS:** 
- Example: `css=form#loginForm > input[name='email']`..
> There are three important special characters in css selectors:
1. ‘^’: Matches elements whose attribute starts with the specified value.
2. ‘$’: Matches elements whose attribute ends with the specified value.
3. ‘*’: Matches elements containing the specified value in the attribute.
Example: `css=input[id$='mail']`, `css=input[id*='mail']`

**XPath Locator in Selenium:**
XPath allows navigation through the HTML structure of a page using path expressions:


- XPath is defined as XML path. It is a syntax or language for finding any element on the web page using the XML path expression.


Syntax XPath
```xml
XPath = //tag_name[@Attribute_name ="Value of attribute"]
```

![1713515188494](image/L19-L32Selenium_practice/1713515188494.png)

```xpath
//    ----> Select current node. tag_name --> Tagname of the particular node.
@ --> Select attribute. 
Attribute_name -> Attribute name of the node. 
Value of attribute -> Value of the attribute.
```

***Types of XPath:***
> **Absolute Xpath** 
Absolute XPath is the direct way of finding the element. Moreover, it starts from the first/root node of the XM4HTML document and goes all the way to the required node following one node at a time
>
> Example:
`/html/body/div/header/a/img`


> **Relative Xpath** 
Relative XPath starts from any node inside the HTML DOM; it need not start from the root node. It beings with a double forward slash.
>
> Example:
`//img[@src= "/images/Testerszone.jpg"]`


**Pre-defined XPath Syntax for Locators:**
> Using `text()`       : `//*[text()='testers zone']`
Using `name()`    : `//input[@name='username']`
Using `id()`         : `//input[@id= user-message]`
Using `class()`     : `//input[@class='user-message]`
`LinkText()`         : `//a[@href='http://testerszone.com/"] `

Note: We can use * in place of input, it will also work fine. Input is specific tag name but * is generic (point out all the available tags in the DOM) we can use for any tag name.

![1713516197781](image/L19-L32Selenium_practice/1713516197781.png)

---
Use of `contains()` in Xpath

The contains() function is utilized in XPath to match elements that include partial text or attribute values. This approach is particularly useful when dealing with elements that have long or dynamic text.

Examples:

> ***Using text():***
> - Syntax: `//*[contains(text(), 'testers')]`

> **Using name attribute:**
> - Syntax: `//input[contains(@name, 'Mith')]`

> **Using id attribute:**
> - Syntax: `//input[contains(@id, 'user-message')]`

> **Using class attribute:**
> - Syntax: `//input[contains(@class, 'user-message')]`

> **Using href attribute (similar to Partial-LinkText()):**
> - Syntax: `//a[contains(@href, 'testerszone.com')]`

---

Use of `starts-with()`
The `starts-with()` function is employed when the initial part of an attribute value or text associated with a web element is known. This method helps in targeting elements whose attributes begin with a specified text.

Syntax:
Example: `//a[starts-with(@id, 'link-testers_')]`

**Note:** inside the '' you have to mention the partial text value, make sure you are getting unique matching element with your xpath. Simillar way we have ends with also. We use end partial part of text.


---
Logical Operators in XPath

XPath supports logical operators such as `OR` and `AND` to combine multiple conditions:

`OR:` This operator is used when at least one of the conditions must be true. It helps in selecting elements that meet any of the specified criteria.

Syntax:
> Example: //*[@type='submit' or @name='btnReset']

`AND:` This operator is used when all specified conditions must be true. It is useful for more specific element targeting.

Syntax:
> Example: //input[@type='submit' and @name='btnLogin']

Note: sometime a single parameter in xpath does not yield a unique element then we follow these approaches.

---

![1713516451169](image/L19-L32Selenium_practice/1713516451169.png)

---

![1713516460685](image/L19-L32Selenium_practice/1713516460685.png)

---

![1713516467990](image/L19-L32Selenium_practice/1713516467990.png)

---

![1713516475879](image/L19-L32Selenium_practice/1713516475879.png)

---

![1713516485143](image/L19-L32Selenium_practice/1713516485143.png)

---

![1713516493324](image/L19-L32Selenium_practice/1713516493324.png)

---

![1713516503060](image/L19-L32Selenium_practice/1713516503060.png)

---

![1713516516033](image/L19-L32Selenium_practice/1713516516033.png)

---

![1713517195935](image/L19-L32Selenium_practice/1713517195935.png)

---

```html
<textarea id="sb_form_q" class="sb_form_q sb_form_ta" name="q" type="search" ... ></textarea>
```

get the xPath
```xml
//*[@id="sb_form_q"]
```


```java
public class SeleniumTest {

    private static EdgeOptions options;
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        options = new EdgeOptions();  // Initialize the EdgeOptions object
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver(options);  // Ensure EdgeDriver is imported

        driver.get("https://www.bing.com");
    }

    @Test
    void testSteps() throws InterruptedException {
        // Implement test steps here
        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
        Thread.sleep(2000);

        // Set the desired value in the textarea
        textArea.sendKeys("Neusoft institute guangdong");
		Thread.sleep(2000);

        // Simulate pressing the Enter key
        textArea.sendKeys(Keys.ENTER);

    }

    @AfterAll
    static void tearDown() {  // Renamed from tearUp to tearDown for clarity
        // driver.quit();  // Changed from close to quit to completely exit the browser session
    }

}
```

> @Timeout(//second)

```java
@Timeout(2)  // 2 seconds
@Test
void testSteps() throws InterruptedException {
	// Implement test steps here
	WebElement textArea = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
	Thread.sleep(2000);

	// Set the desired value in the textarea
	textArea.sendKeys("Neusoft institute guangdong");
	Thread.sleep(2000);

	// Simulate pressing the Enter key
	textArea.sendKeys(Keys.ENTER);
}
```

***Is the test passed  / failed?***
```


```

---
