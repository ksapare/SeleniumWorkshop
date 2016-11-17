package com.test;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browser {

    public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {

        /*System.setProperty("webdriver.gecko.driver", "/Users/z013th3/Documents/vDig/SeAuto/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setCapability("marionette", true);
        capabilities.setCapability("webdriver.gecko.driver", "/Users/z013th3/Documents/vDig/SeAuto/geckodriver");*/
        return new RemoteWebDriver(new URL("http://10.93.115.223:4444/wd/hub"), getBrowserCapabilities(browser));
        //return new RemoteWebDriver(new URL("http://http://10.92.244.212:4444/wd/hub"), capabilities);
    }

    private static DesiredCapabilities getBrowserCapabilities(String browserType) {
        switch (browserType) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/z013th3/Documents/vDig/SeAuto/geckodriver");
                System.out.println("Opening firefox driver");


                return DesiredCapabilities.firefox();
            case "chrome":
                System.out.println("Opening chrome driver");
                return DesiredCapabilities.chrome();
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
                return DesiredCapabilities.firefox();
        }
    }
}