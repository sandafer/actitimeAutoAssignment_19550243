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



}
