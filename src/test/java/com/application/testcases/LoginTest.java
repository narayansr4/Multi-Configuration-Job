package com.application.testcases;

import com.application.base.Base;
import com.application.driver.Driver;
import com.application.pages.HomePage;
import com.application.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    LoginPage loginPage;
    HomePage homepage;


    @Test
    public void verifyLogin(){
        loginPage = new LoginPage(Driver.getDriver());
        homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(homepage.isHomeTextDisplayed());
    }
}
