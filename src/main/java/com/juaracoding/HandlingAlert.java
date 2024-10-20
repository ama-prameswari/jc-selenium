package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingAlert {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/alerts");

        // alert button
        driver.findElement(By.id("alertButton")).click();
        Utils.delay(3);
        driver.switchTo().alert().accept(); // OK
        System.out.println("Alert Button");

        // timer alert button
        driver.findElement(By.id("timerAlertButton")).click();
        Utils.delay(5);
        driver.switchTo().alert().accept(); // OK
        System.out.println("Timer Alert Button");

        js.executeScript("window.scrollBy(0,200)");

        // timer alert button
        driver.findElement(By.id("confirmButton")).click();
        Utils.delay(3);
        driver.switchTo().alert().accept(); // Cancel
        System.out.println("Confirm Button");

        // prompt button
        driver.findElement(By.id("promtButton")).sendKeys("Hello Alert!");
        driver.findElement(By.id("promtButton")).sendKeys(Keys.ENTER);
        Utils.delay(5);
        driver.switchTo().alert().accept();
        System.out.println("Prompt Button");


        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }

}