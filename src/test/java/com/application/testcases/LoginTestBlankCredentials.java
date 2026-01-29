package com.application.testcases;

import com.application.base.Base;
import com.application.driver.Driver;
import com.application.pages.HomePage;
import com.application.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestBlankCredentials extends Base {
    LoginPage loginPage;
    HomePage homepage;


    @Test
    public void verifyLogin2(){
        loginPage = new LoginPage(Driver.getDriver());
        loginPage.login("","");
        Assert.assertTrue(loginPage.isEmailRequiredTextDisplayed());
        Assert.assertTrue(loginPage.isPasswordRequiredTextDisplayed());
    }
}
