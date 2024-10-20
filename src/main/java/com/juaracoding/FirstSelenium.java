package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        // locator: name
//        driver.findElement(By.name("q")).sendKeys("Selenium");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // linkText taghtml <a>gmail</a>
        driver.findElement(By.linkText("Gmail")).click();

        // delay 5 detik
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}