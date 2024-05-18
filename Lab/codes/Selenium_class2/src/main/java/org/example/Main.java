package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click(); //ClickMe button

        Thread.sleep(5000);

        //driver.switchTo().alert().accept();//closes popup by using OK button
        driver.switchTo().alert().dismiss();//closes popup by using Cancel button
    }
}