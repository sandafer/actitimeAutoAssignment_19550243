package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UsersPage extends TestBase {


    @FindBy(xpath = "//*[@class='pagetitle']//span[text() = \"List of Users\"]")
    WebElement usersPageTitle;
    @FindBy(xpath = "//table[@class='userListTable canEditUsers sortByName']")
    WebElement usersTable;
    @FindBy(className = "userListRow")
    List<WebElement> userList;


    // Call init
    public UsersPage() {

        PageFactory.initElements(driver, this);

    }

    // Methods
    public Boolean validateUserPageTitle() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return usersPageTitle.isDisplayed();
    }

    public Boolean validateUserTable() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return usersTable.isDisplayed();
    }

    public Boolean validateUserListCount() {
        if (userList.size() == 0) {
            return false;
        } else
            return true;
    }
}
