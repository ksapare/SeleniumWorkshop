package com.testautomation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataParamsTestB {
    @Parameters({ "browser" })
    @Test
    public void testCaseOne(String browser) {
        System.out.println("browser passed as :- " + browser);
    }

    @Parameters({ "username", "password" })
    @Test
    public void testCaseTwo(String username, String password) {
        System.out.println("Parameter for User Name passed as :- " + username);
        System.out.println("Parameter for Password passed as :- " + password);

        System.out.println("Hello Selenium");

        System.setProperty("webdriver.gecko.driver", "/Users/z013th3/SeTests/Day5/lib/firefoxdriver/geckodriver");

        WebDriver driver=new FirefoxDriver();

        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement elementSignIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));
        elementSignIn.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement elementCheck = driver.findElement(By.xpath(".//*[@id='center_column']/h1"));

        WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("email")));
        myDynamicElement.click();
        myDynamicElement.sendKeys(username);

        driver.findElement(By.id("passwd")).sendKeys(password);

        driver.findElement(By.name("SubmitLogin")).click();

        String cartAccount = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText();
        Assert.assertEquals(cartAccount, "Sele Test", "Value Recieved from website");

        System.out.println(cartAccount);

        driver.close();
        driver.quit();
    }
}