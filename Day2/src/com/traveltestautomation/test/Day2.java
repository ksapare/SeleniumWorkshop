package com.traveltestautomation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Day2 - Excercises for element locators and assertions
 */
public class Day2 {

    @Test
    public static void verify_Flight_HomePageDisplay() throws InterruptedException {

        //Firefox Driver
        System.setProperty("webdriver.gecko.driver", "/Users/z013th3/Documents/vDig/SeAuto/geckodriver");
        WebDriver driver=new FirefoxDriver();


        driver.navigate().to("http://phptravels.net");
        driver.manage().window().maximize();

        //Identify element using id
        //Get default passenger count value
        String strPassengerCount = driver.findElement(By.id("adults")).getAttribute("Value");

        //Identify element using name
        //Get default checkin date
        String strCheckinDate = driver.findElement(By.name("checkin")).getAttribute("Value");

        //output values to console
        System.out.println (strPassengerCount);
        System.out.println (strCheckinDate);

        //Assert if default values are correct
        Assert.assertEquals(strPassengerCount,"2","Default passenger count needs to be 2");
        Assert.assertTrue(strCheckinDate.equals("15/11/2016"),"Check-in date has to be today's date");


        //Identify element using xpath
        // Tours menu

        driver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/div/div[2]/ul/li[3]/a")).click();

        //Wait using Thread.sleep
        Thread.sleep(8000);

        //Identify element using css
        //Select From location
        WebElement fromLocation= driver.findElement(By.xpath("//*[contains(@class,'captext ellipsis go-right')]/span"));

        fromLocation.click();

        Thread.sleep(5000);
        WebElement myDynamicElement = driver.findElement(By.xpath("//*[contains(@type,'text') and contains(@name,'txtSearch')]"));
        myDynamicElement.click();

        //Enter the tour search location as Hongkong
        myDynamicElement.sendKeys("Hong Kong");

        //Identifying elements using classname
        //Click on search
        driver.findElement(By.className("icon_set_1_icon-78")).click();

        //validation of search set
        //Implicit wait implementation
        Thread.sleep(5000);
        String searchTxt=driver.findElement(By.xpath("//*[contains(@class,'captext ellipsis go-right')]")).getText();


        //Validated the search details
        Assert.assertEquals(searchTxt,"Hong Kong");

        driver.close();
        driver.quit();

    }
}
