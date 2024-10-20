package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);
        Utils.delay(3);
        driver.switchTo().window(tab.get(0));
        String txtTitlePage = driver.findElement(By.cssSelector("#browserWindows > h1")).getText();
        System.out.println(txtTitlePage);

        // navigation
        js.executeScript("window.scrollBy(0,500)", ""); // scroll
//        WebElement menuModalDialog = driver.findElement(By.cssSelector("#item-4"));
//        js.executeScript("arguments[0].click();", menuModalDialog);
        driver.get("https://demoqa.com/modal-dialogs");
        System.out.println("Current URL: " + driver.getCurrentUrl()); // Modal dialog
        driver.findElement(By.id("smallModal")).click();
        Utils.delay(3);
        driver.findElement(By.id("closeSmallModal")).click();
        Utils.delay(3);

        driver.navigate().back();
        System.out.println("Current URL: " + driver.getCurrentUrl()); // Browser Windows
        driver.navigate().refresh();

        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }

}