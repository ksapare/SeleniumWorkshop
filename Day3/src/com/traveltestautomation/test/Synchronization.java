package com.traveltestautomation.test;

import com.traveltestautomation.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.*;

public class Synchronization {

    @Test
    public static void verify_Flight_HomePageDisplay() throws InterruptedException {

      DOMConfigurator.configure("log4j.xml");
      Log.startTestCase("TC001 - Verify the Synchronization Test Case");
      Log.info("Logging Started");

      System.setProperty("webdriver.gecko.driver", "<Firefox Driver Path");
      Log.info("Initiated Firefox Driver");
      WebDriver driver=new FirefoxDriver();
      Log.info("...Opening Chrome Browser");

      try {
        driver.navigate().to("http://automationpractice.com1/index.php");
        Log.error("Could Not find the website");
        driver.manage().window().maximize();
      }

      catch(WebDriverException e) {
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
      }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      try {
        WebElement elementSignIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/b"));
        elementSignIn.click();
      }
      catch(NoSuchElementException e)
      {
        WebElement elementSignIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));
        elementSignIn.click();
      }

      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      WebElement elementCheck = driver.findElement(By.xpath(".//*[@id='center_column']/h1"));
      
      WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("email")));
      myDynamicElement.click();
      myDynamicElement.sendKeys("testingse@gmail.com");

      driver.findElement(By.id("passwd")).sendKeys("testing123");

      driver.findElement(By.name("SubmitLogin")).click();

      String cartAccount = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText();
      Log.info("Account" +cartAccount);
      Assert.assertEquals(cartAccount, "Sele Test", "Value Recieved from website");

      System.out.println(cartAccount);

      driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");

      driver.close();
      driver.quit();

    }
}

