package com.traveltestautomation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest {

    @Test
    public static void verify_Flight_HomePageDisplay() throws InterruptedException {


       //Firefox Driver
        System.setProperty("webdriver.gecko.driver", "<Firefox Driver Path");
        WebDriver driver=new FirefoxDriver();


        driver.navigate().to("http://www.phptravels.net");
        driver.manage().window().maximize();

        //Identify element using xpath
        // Tours menu

        driver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/div/div[2]/ul/li[3]/a")).click();

        //Wait using Thread.sleep
        Thread.sleep(8000);

        //Identify element using css
        //Select From location
        WebElement fromLocation= driver.findElement(By.xpath("//*[contains(@class,'captext ellipsis go-right')]/span"));
        fromLocation.click();

        //Explicit wait implementation
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@type,'text') and contains(@name,'txtSearch')]")));
        myDynamicElement.click();

        //Enter the tour search location as Hongkong
        myDynamicElement.sendKeys("Hong Kong");

        //Identifying elements using classname
        //Click on search
        driver.findElement(By.className("icon_set_1_icon-78")).click();

        //validation of search set
        //Implicit wait implementation
        Thread.sleep(3000);
        String searchTxt=driver.findElement(By.xpath("//*[contains(@class,'captext ellipsis go-right')]")).getText();


        //Validated the search details
        Assert.assertEquals(searchTxt,"Hong Kong");

        driver.close();
        driver.quit();

    }
}
