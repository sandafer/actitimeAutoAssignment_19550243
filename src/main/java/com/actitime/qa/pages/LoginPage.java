package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - Object Repository

    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    WebElement userName;


    @FindBy(xpath = "//input[@type='password'and @name='pwd']")
    WebElement passWord;

    @FindBy(xpath = "//a[@id='loginButton']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name='remember']")
    WebElement keepmeLoggedinCheckBox;

    @FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
    WebElement forgotYourPasswordLink;


    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;

    @FindBy(xpath = "//span[@class='errormsg']")
    WebElement loginErrorMsg;
    //initialization

    public LoginPage() {

        PageFactory.initElements(driver, this);


    }

    //Action/Methods

    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();

    }

    public HomePage loging(String uName, String pword) {

        userName.sendKeys(uName);
        passWord.sendKeys(pword);
        loginButton.click();
        return new HomePage();

    }

    public void invalidLogging(String uName, String password) throws InterruptedException {

        userName.sendKeys(uName);
        passWord.sendKeys(password);
        loginButton.click();
        Thread.sleep(200);

    }

    public String validateInvalidLogin() {
        String errorMsgText = "";
        if (loginErrorMsg.isDisplayed()) {
            errorMsgText = loginErrorMsg.getText();
        }
        return errorMsgText;
    }
}
