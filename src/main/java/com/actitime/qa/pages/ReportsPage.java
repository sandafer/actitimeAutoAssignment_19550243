package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ReportsPage extends TestBase {

    // Web Element Xpath

    @FindBy(xpath = "//*[@class='pagetitle'][text() = \"Reports Dashboard\"]")
    WebElement reportDashboardPageTitle;
    @FindBy(xpath = "//*[@id='reportConfig_119']")
    WebElement pastMonthsLeaveChartSection;
    @FindBy(xpath = "//*[@id='reportConfig_90']")
    WebElement attendanceChartSection;
    @FindBy(className = "reportName")
    WebElement reportNameInExpandedView;
    @FindBy(xpath = "//*[@id='createChartLightbox_cancelBtn']")
    WebElement cancelBtnInCreateChart;


    // Call init
    public ReportsPage() {

        PageFactory.initElements(driver, this);

    }

    // Methods
    public Boolean validateReportPageTitle() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return reportDashboardPageTitle.isDisplayed();
    }

    public Boolean validateLeaveChart() {
        return pastMonthsLeaveChartSection.isDisplayed();
    }

    public void clickLeaveChart() {
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        pastMonthsLeaveChartSection.click();
    }

    public String getReportName() {
        return reportNameInExpandedView.getText().trim();
    }

    public void clickAttendanceChart() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        attendanceChartSection.click();
    }

    public void clickCancelBtnInCreateChart() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        cancelBtnInCreateChart.click();
    }


}
