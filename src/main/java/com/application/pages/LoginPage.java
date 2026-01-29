package com.application.pages;

import com.application.driver.Driver;
import com.application.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private  WebDriver driver;

    private By emailText = By.cssSelector("input#userEmail");

    private By passwordText = By.cssSelector("input#userPassword");

    private By loginBtn = By.cssSelector("input#login");

    private By emailReqText = By.xpath("//div[text()='*Email is required']");

    private By passwordReqText = By.xpath("//div[text()='*Password is required']");

    private By invalidAlert = By.xpath("//div[@id='toast-container']//div[text()=' Incorrect email or password. ']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public HomePage login(String email, String password){

        WaitUtils.waitForVisibility(emailText).sendKeys(email);
        //driver.findElement(emailText).sendKeys(email);
        driver.findElement(passwordText).sendKeys(password);
        driver.findElement(loginBtn).click();

        return new HomePage(driver);
    }

    public boolean isEmailRequiredTextDisplayed(){
        WebElement ele = WaitUtils.waitForVisibility(emailReqText);
        return ele.isDisplayed();
    }

    public boolean isPasswordRequiredTextDisplayed(){
        WebElement ele = WaitUtils.waitForVisibility(passwordReqText);
        return ele.isDisplayed();
    }

    public boolean isInvalidAlertDisplayed(){
        WebElement ele = WaitUtils.waitForVisibility(invalidAlert);
        return ele.isDisplayed();
    }
}
