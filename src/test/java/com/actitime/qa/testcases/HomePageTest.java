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
    UsersPage usersPage;
    ReportsPage reportsPage;
    public HomePageTest() {
        super();

    }


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        usersPage = new UsersPage();
        reportsPage = new ReportsPage();

    }


    @Test(priority = 1)
    public void homePageLogoTest() {

        boolean flag = homePage.validateActiTimeLogo();
        Assert.assertTrue(flag, "Cannot find the Logo");

    }

    @Test(priority = 2)
    public void homePageUsersLinkTest() {

        homePage.clickOnUsersLink();
        Assert.assertTrue(usersPage.validateUserPageTitle(), "Cannot find the Users section page title");
        Assert.assertTrue(usersPage.validateUserTable(), "Cannot find the Users Table");
        Assert.assertTrue(usersPage.validateUserListCount(), "List of users in Users Table is zero");


    }

    @Test(priority = 3)
    public void homePageReportsLinkTest() {

        homePage.clickOnReportsLink();
        Assert.assertTrue(reportsPage.validateReportPageTitle(), "Cannot find the Reports section page title");
        Assert.assertTrue(reportsPage.validateLeaveChart(), "Cannot find the Leave Chart in Reports section");
        reportsPage.clickLeaveChart();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}
