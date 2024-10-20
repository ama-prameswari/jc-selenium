package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBox {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/text-box");

        // locator: name
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("admin@juaracoding.co.id");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta Indonesia");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta Indonesia");

        // scroll vertical 300px
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("submit")).click();


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
