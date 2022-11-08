package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TimeTrackPage extends TestBase {
    @FindBy(xpath = "//td[@class='pagetitle'][text() = \"Enter Time-Track\"]")
    WebElement timeTrackPageTitle;
    @FindBy(linkText = "Approve Time-Track")
    WebElement approveTimeTrackNav;
    // Start Approve time page
    @FindBy(xpath = "//*[@class='pagetitle'][text() = 'Approve Time-Track']")
    WebElement approveTimeTrackPageTitle;
    @FindBy(id = "approveButton")
    WebElement approveBtn;
    @FindBy(id = "rejectButton")
    WebElement rejectBtn;
    @FindBy(id = "approveTTTable")
    WebElement approveTable;
    @FindBy(className = "userNameInfo")
    List<WebElement> userNameListInApproveTable;
    @FindBy(className = "noRecordsRow")
    WebElement unoRecordsRowInApproveTable;
    @FindBy(xpath = "//table[@id='approveTTTable']//tbody[@class='data']//td//input[@type='checkbox']")
    WebElement approveTableFirstUserCheckBox;
    // Call init
    public TimeTrackPage() {

        PageFactory.initElements(driver, this);

    }

    // Methods
    public Boolean validateTimeTrackPageTitle() {
        return timeTrackPageTitle.isDisplayed();
    }

    public Boolean validateApproveTimeTrackNav() {
        return approveTimeTrackNav.isDisplayed();
    }

    public void clickApproveTimeTrackPanel() {
        approveTimeTrackNav.click();
    }

    // Methods
    public Boolean validateApproveTimeTrackPageTitle() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return approveTimeTrackPageTitle.isDisplayed();
    }

    public Boolean validateApproveTable() {
        return approveTable.isDisplayed();
    }

    public void clickApproveBtn() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        approveBtn.click();
    }

    public void clickRejectBtn() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        rejectBtn.click();
    }

    public void selectFirstUserCheckBox() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (userNameListInApproveTable.size() > 0) {
            approveTableFirstUserCheckBox.click();
        } else {
            System.out.println("----List of users in Approve table is zero----");
            System.exit(0);
        }
    }

    public Boolean validateUserNameListCount() {
        if (userNameListInApproveTable.size() == 0) {
            return false;
        } else
            return true;
    }


}
