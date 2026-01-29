package com.application.base;

import com.application.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static Properties prop;


    public Base() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\application\\config\\config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @BeforeMethod
    public void setup(){
        WebDriver driver = null;
        //String browser = System.getProperty("browser");
        String browser = "chrome";
        switch (browser){
            case "chrome" : driver = new ChromeDriver();
                break;
            case "edge" : driver = new EdgeDriver();
                break;
            case "firefox" : driver = new FirefoxDriver();
                break;
            default: System.out.println("Invalid Browser choice");
        }
        Driver.setDriver(driver);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(prop.getProperty("url"));
    }

    @AfterMethod
    public void teardown(){
        Driver.getDriver().quit();
        Driver.removeDriver();
    }

    }