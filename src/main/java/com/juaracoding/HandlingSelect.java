package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingSelect {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/select-menu");

        String txtTitlePage = driver.findElement(By.xpath("//*[@id='selectMenuContainer']/h1")).getText();
        System.out.println(txtTitlePage);
        // ->//*[@id='selectMenuContainer']/h1 -> copy Xpath

        String txtTitle = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
        System.out.println(txtTitle);
        // ->//h1[@class='text-center'] -> selectorXpath

        js.executeScript("window.scrollBy(0,300)","");
        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColor);
        select.selectByIndex(7);
        Utils.delay(3);
        select.selectByValue("red"); // attribute value
        Utils.delay(3);
        select.selectByVisibleText("Indigo");

        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }

}