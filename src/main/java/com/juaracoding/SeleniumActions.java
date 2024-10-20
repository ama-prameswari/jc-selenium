package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumActions {
    public static void main(String[] args) {
        // Actions -> moveToElement()

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://www.browserstack.com/");

       /* WebElement menuProduct = driver.findElement(By.xpath("//button[@id='products-dd-toggle']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuProduct).build().perform();*/


        /*WebElement menuDev = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuDev).build().perform();*/


        WebElement menuProduct = driver.findElement(By.xpath("//button[@id='products-dd-toggle']"));
        WebElement menuDev = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(menuProduct).build().perform();
        Utils.delay(3);
        actions.moveToElement(menuDev).build().perform();
        Utils.delay(3);

        List<WebElement> menuDeveloperList = driver.findElements(By.xpath("//div[@class='bstack-mm-sub-li']"));
        System.out.println(menuDeveloperList.size());
        menuDeveloperList.get(0).click();
        Utils.delay(2);
        driver.navigate().back();

        WebElement menuDevelopers = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));
        actions.moveToElement(menuDevelopers).build().perform();

        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }
}