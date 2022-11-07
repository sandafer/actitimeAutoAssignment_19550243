package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogonPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    String sheetName = "Users";
    TestUtil testUtil;


    public LogonPageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();

    }


    @Test(priority = 1)
    public void loginPageLogoTest() {
        SoftAssert softAssertion= new SoftAssert();
        boolean flag = loginPage.validateActiTimeLogo();
        softAssertion.assertTrue(flag);
        softAssertion.assertAll();
    }


    @DataProvider

    public Object[][] getactiTimeTestData() {
        Object data[][] = testUtil.getTestData(sheetName);

        return data;


    }

    @Test(priority = 2, dataProvider = "getactiTimeTestData")
    public void LoginTest(String userName, String password) {

        homePage = loginPage.loging(userName, password);
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
