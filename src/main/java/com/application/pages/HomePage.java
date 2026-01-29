package com.application.pages;

import com.application.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By homeText = By.xpath("//section[@id='sidebar']//p[text()=' Home | ']");

    public boolean isHomeTextDisplayed(){
        WebElement ele = WaitUtils.waitForVisibility(homeText);
        return ele.isDisplayed();
    }
}
