package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/radio-button");

        // locator: cssSelector
        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > "
                + "div:nth-child(2) > div:nth-child(2) > label")).click();
        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > "
                + "div:nth-child(3) > div:nth-child(3) > label")).click();

        // delay 5 detik
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");

    }
}
