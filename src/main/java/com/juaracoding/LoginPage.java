package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");

//        driver.get("https://www.saucedemo.com/v1/");
//
//        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
//        username.sendKeys("standard_user");
//        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("secret_sauce");
//        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
//        loginBtn.click();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Negative Test: Invalid Login
        loginUser(driver, "invalid", "invalid123");


        // Positive Test: Valid Login
        loginUser(driver, "Admin", "admin123");


//        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//        username.sendKeys("Admin");
//        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//        password.sendKeys("admin123");
//        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
//        loginBtn.click();

//        String txtDashboard = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        // jika menemukan value panjang, gunakan 'contains'
        String txtDashboard = driver.findElement(By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb')]")).getText();
        System.out.println(txtDashboard);

        // customAssertEquals(txtDashboard, "Dashboard") = jika true Passed, false Failed
        customAssertEquals(txtDashboard, "Dashboard");


       /*
        // bila ingin run positive case setelah itu negative case, lakukan logout dahulu setelah itu negative
        // Positive Login Test
        loginUser(driver, "Admin", "admin123");
        String dashboardTitle = driver.findElement(By.xpath("//h6[contains(@class, 'header')]")).getText();
        System.out.println(dashboardTitle);
        customAssertEquals(dashboardTitle, "Dashboard");

        // Logout
        driver.findElement(By.xpath("//i[contains(@class, 'userdropdown')]")).click();
        driver.findElement(By.linkText("Logout")).click();

        // Negative Login Test
        loginUser(driver, "invalid", "invalid");
        String invalidAlert = driver.findElement(By.xpath("//p[contains(@class, 'alert-content')]")).getText();
        System.out.println(invalidAlert);
        customAssertEquals(invalidAlert, "Invalid credentials");
        */

        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");
    }

    public static void loginUser(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // Method customAssertEquals(txtDashboard, "Dashboard") = jika true Passed, false Failed
    public static void customAssertEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

}