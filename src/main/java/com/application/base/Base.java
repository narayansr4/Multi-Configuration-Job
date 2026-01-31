package com.application.base;

import com.application.driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    protected static Properties prop;


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
        String browser = System.getProperty("browser","chrome");
        //String browser = "chrome";
        switch (browser.toLowerCase()){

            case "edge" : WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                driver = new EdgeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default: WebDriverManager.chromedriver().setup();
                ChromeOptions options2 = new ChromeOptions();
                options2.addArguments("--headless=new");
                driver = new ChromeDriver(options2);
        }
        Driver.setDriver(driver);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(prop.getProperty("url"));
    }

    @AfterMethod
    public void teardown(){
        if (Driver.getDriver()!= null) {
            Driver.getDriver().quit();
            Driver.removeDriver();
        }
    }

    }