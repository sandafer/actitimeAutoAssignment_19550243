package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.*;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TimeSheetApproveRejectPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TimeTrackPage timeTrackPage;
    public TimeSheetApproveRejectPageTest() {
        super();

    }


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        timeTrackPage = new TimeTrackPage();

    }

    @Test
    public void validateRejectTimeTest() {
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("AAAAAAAAAAAAAAA");
        homePage.clickOnTimeTrackLink();
        softAssertion.assertTrue(timeTrackPage.validateTimeTrackPageTitle(), "Cannot find the Time Track section page title");
        softAssertion.assertTrue(timeTrackPage.validateApproveTimeTrackNav(), "Cannot find the Approve time track Navigation panel");
        timeTrackPage.clickApproveTimeTrackPanel();


        softAssertion.assertTrue(timeTrackPage.validateApproveTimeTrackPageTitle(), "Cannot find the Approve Time Track section page title");
        softAssertion.assertTrue(timeTrackPage.validateApproveTable(), "Cannot find the Approve Time Track table");
        softAssertion.assertTrue(timeTrackPage.validateUserNameListCount(), "List of users in Approve table is zero");

        timeTrackPage.selectFirstUserCheckBox();
        timeTrackPage.clickRejectBtn();
        softAssertion.assertAll();
    }
    @Test(dependsOnMethods={"validateRejectTimeTest"})
    public void validateRejectedTimeTestIsNotAllowedToBeRejectedAgain() {
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("BBBBBBBBBBBBBBBBBBBBB");
        homePage.clickOnTimeTrackLink();
        timeTrackPage.clickApproveTimeTrackPanel();

        try{
            timeTrackPage.selectFirstUserCheckBox();
            timeTrackPage.clickRejectBtn();
            System.out.println("Waiting for Alert");
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert data: " + alertText);
            softAssertion.assertEquals(alertText, "This operation was not applied to the entries because their current status coincides with the operation status.", "Incorrect Alert text is displayed");
            alert.accept();
        }
        catch (Exception e){
            System.out.println("Alert not Displayed");
        }
        softAssertion.assertAll();

    }
    @Test(dependsOnMethods={"validateRejectedTimeTestIsNotAllowedToBeRejectedAgain"})
    public void validateApproveTimeTest() {
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("CCCCCCCCCCCCCCCCCCC");
        homePage.clickOnTimeTrackLink();
        timeTrackPage.clickApproveTimeTrackPanel();

        driver.navigate().refresh();
        timeTrackPage.selectFirstUserCheckBox();
        timeTrackPage.clickApproveBtn();

        softAssertion.assertAll();
    }

        @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}
