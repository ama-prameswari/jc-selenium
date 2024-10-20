package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumCollection {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
/*
        // Collection + Negative Login Test
        List<WebElement> listInput = driver.findElements(By.xpath("//input"));
        System.out.println("Jumlah tag html input = " + listInput.size());

        for (int i = 0; i < listInput.size(); i++) {
            System.out.println(listInput.get(i).getAttribute("type"));
        }

        for (WebElement input : listInput) {
            System.out.println(input.getAttribute("type"));
        }

        for (int i = 0; i < listInput.size(); i++) { // 3 < 3
            listInput.get(i).sendKeys("invalid");
        }

        driver.findElement(By.xpath("//button[@type=submit]")).click();
        String txtInvalid = driver.findElement(By.xpath("//p[contains(@class,'alert-content-text')]")).getText();
        System.out.println(txtInvalid);

        // Positive Login Test
        LoginPage.loginUser(driver, "Admin", "admin123")
        String dashboardTitle = driver.findElement(By.xpath("//h6[contains(@class, 'header')]")).getText();
        System.out.println(dashboardTitle);
        LoginPage.customAssertEquals(dashboardTitle, "Dashboard")
        ;*/


        /*
        // Test Tokopedia
        driver.get("https://www.tokopedia.com/");
        List<WebElement> trends = driver.findElements(By.xpath("//a[@data-testid='trendkingKeywordList']"));
        System.out.println(trends.size());

        for (WebElement trend : trends) {
            System.out.println("Trend: " + trend.getText());
        }

        trends.get(4).click();

        // replace dan convert
        String price = "Rp3.699.000";
//        System.out.println(price.replace("Rp", ""));
        String priceClear = price.replace("Rp", "");
//        String priceConvert = priceClear.replace(".", "");
        double priceConvert = Double.parseDouble(priceClear.replace(".", ""));
//        System.out.println(priceConvert);
        System.out.println(priceConvert+1000);*/


        /*
        // List Menu
        LoginPage.loginUser(driver, "Admin", "admin123");

        List<WebElement> menu = driver.findElements(By.xpath("//span[contains(@class, 'main-menu-item')]"));
        System.out.println(menu.size());

        for (WebElement listMenu : menu) {
            System.out.println("List Menu: " + listMenu.getText());
        }*/


          // sendkeys ->ctrlA
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.CONTROL+"A");
        Utils.delay(3);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.DELETE);
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.BACK_SPACE); // bisa pakai ini juga
        Utils.delay(5);


        // delay 5 detik
        Utils.delay(5);

        // close the browser
        driver.quit();
        System.out.println("Quit Browser");

    }

}
