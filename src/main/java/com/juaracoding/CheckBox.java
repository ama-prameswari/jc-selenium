package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/checkbox");

        // locator: name
        // checklist Home
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > label")).click();
        // unchecklist Home
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > label")).click();
        // checklist: Desktop, Documents, Downloads
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > button")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > label")).click();
        // scroll vertical 200px
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > label")).click();

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
