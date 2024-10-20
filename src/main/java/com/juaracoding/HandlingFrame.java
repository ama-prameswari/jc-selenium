package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrame {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/frames");

        // frame
        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        driver.switchTo().defaultContent();

        // web scraping; locator: cssLocator
        String txtTitlePage = driver.findElement(By.cssSelector("#framesWrapper > h1")).getText();
        System.out.println(txtTitlePage);

        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }

}