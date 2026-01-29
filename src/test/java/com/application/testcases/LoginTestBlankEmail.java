package com.application.testcases;

import com.application.base.Base;
import com.application.driver.Driver;
import com.application.pages.HomePage;
import com.application.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestBlankEmail extends Base {
    LoginPage loginPage;
    HomePage homepage;


    @Test
    public void verifyLogin3(){
        loginPage = new LoginPage(Driver.getDriver());
        homepage = loginPage.login("", prop.getProperty("password"));
        Assert.assertTrue(loginPage.isEmailRequiredTextDisplayed());
    }
}
