package com.application.driver;

import com.application.base.Base;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }
    public static WebDriver getDriver(){
        return driver.get();
    }
    public static void removeDriver(){
        driver.remove();
    }


}
