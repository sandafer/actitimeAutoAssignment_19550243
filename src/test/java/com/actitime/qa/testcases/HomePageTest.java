package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();

    }


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));


    }


    @Test(priority = 1)
    public void homePageLogoTest() {

        boolean flag = homePage.validateActiTimeLogo();
        Assert.assertTrue(flag, "Cannot find the Logo");

    }



    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}
