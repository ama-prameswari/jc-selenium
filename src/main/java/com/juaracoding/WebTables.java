package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTables {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/webtables");

        // Logo image
//        driver.findElement(By.cssSelector("#app > header > a > img"));

        // *** Positive Test Case ***
        // locator: id
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("johndoe@example.com");
        driver.findElement(By.id("age")).sendKeys("30");
        driver.findElement(By.id("salary")).sendKeys("50000");
        driver.findElement(By.id("department")).sendKeys("Engineering");
        driver.findElement(By.id("submit")).click();
        System.out.println("Successful add new record");

        // delay Add 2 detik
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        // *** Negative Test Case ***
//        // locator: id
//        System.out.println("\n--- Adding an Invalid Record (Missing Email) ---");
//        driver.findElement(By.id("addNewRecordButton")).click();
//        driver.findElement(By.id("firstName")).sendKeys("Bob");
//        driver.findElement(By.id("lastName")).sendKeys("Johnson");
//        driver.findElement(By.id("age")).sendKeys("30");
//        driver.findElement(By.id("salary")).sendKeys("50000");
//        driver.findElement(By.id("department")).sendKeys("IT");
//        driver.findElement(By.id("submit")).click(); // Try to submit without email
//        boolean isEmailFieldPresent = driver.findElements(By.cssSelector(".was-validated")).size() > 0;
//        if (isEmailFieldPresent) {
//            System.out.println("Failed to add: Missing email");
//        }

        // delay 2 detik
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // scroll vertical 250px
        js.executeScript("window.scrollBy(0,250)");

        // Edit the record (John Doe)
        // locator: id
        driver.findElement(By.id("edit-record-4")).click();
        WebElement departmentField = driver.findElement(By.id("department"));
        departmentField.clear();
        departmentField.sendKeys("IT");
        driver.findElement(By.id("submit")).click();
        System.out.println("Successful edit the record");

        // delay Edit 2 detik
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Delete the record (John Doe)
        driver.findElement(By.id("delete-record-4")).click();
        System.out.println("Successful delete the record");

        // delay Delete 2 detik
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Search across all columns
        // locator: id
        driver.findElement(By.id("searchBox")).sendKeys("Alden");
        driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);

        // Pagination
//        driver.findElement(By.xpath("//button[@id='next-btn']")).click();

        // delay Search 5 detik
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }
}