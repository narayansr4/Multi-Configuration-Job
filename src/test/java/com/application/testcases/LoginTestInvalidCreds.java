package com.application.testcases;

import com.application.base.Base;
import com.application.driver.Driver;
import com.application.pages.HomePage;
import com.application.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestInvalidCreds extends Base {
    LoginPage loginPage;
    HomePage homepage;


    @Test
    public void verifyLogin5(){
        loginPage = new LoginPage(Driver.getDriver());
        homepage = loginPage.login("aa@gmail.com", "abc");
        Assert.assertTrue(loginPage.isInvalidAlertDisplayed());
    }
}
