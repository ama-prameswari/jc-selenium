package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Exercise {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/webtables");

        // web scraping; locator: cssLocator
        String txtTitlePage = driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6")).getText();
        System.out.println(txtTitlePage);

        // get tag title
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // get current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }

}