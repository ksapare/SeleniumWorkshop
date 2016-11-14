package com.traveltestautomation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * This program Opens the browser and website.
 */
public class OpenBrowser {
    @Test
    public static void verify_Flight_HomePageDisplay() throws InterruptedException {

        System.out.println("Hello Selenium");

        System.setProperty("webdriver.gecko.driver", "<FirefoxDriver Path>");

        WebDriver driver=new FirefoxDriver();

        driver.navigate().to("http://www.phptravels.net");
        driver.manage().window().maximize();

        //Identify element using xpath
        // Tours menu
        driver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/div/div[2]/ul/li[3]/a")).click();

        //Wait using Thread.sleep
        Thread.sleep(8000);

        driver.close();
        driver.quit();

    }
}
