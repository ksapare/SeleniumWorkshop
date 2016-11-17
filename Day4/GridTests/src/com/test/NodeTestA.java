package com.test;

//import org.apache.commons.logging.Log;
import com.test.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class NodeTestA {

    public static RemoteWebDriver driver;
    public static String appURL = "http://automationpractice.com/index.php";

    @BeforeClass
    @Parameters({ "browser" })
    public void setUp(String browser) throws MalformedURLException {
        DOMConfigurator.configure("log4j.xml");
        System.out.println("*******************");
        //System.setProperty("webdriver.gecko.driver", "/Users/z013th3/Documents/vDig/SeAuto/geckodriver");

        driver = Browser.getDriver(browser);
        driver.manage().window().maximize();
    }

    @Test
    public void testPageTitleInFirefox() throws InterruptedException {
        driver.navigate().to(appURL);
        Thread.sleep(10000);

        Log.startTestCase("TC001 - Verify the Synchronization Test Case");
        Log.info("Logging Started");
        String strPageTitle = driver.getTitle();
        //Assert.assertTrue(strPageTitle.equalsIgnoreCase("My Account"), "Page title doesn't match");
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

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        if(driver!=null) {
            System.out.println("Closing Firefox browser");
            Thread.sleep(5000);
            driver.quit();
        }
    }
}