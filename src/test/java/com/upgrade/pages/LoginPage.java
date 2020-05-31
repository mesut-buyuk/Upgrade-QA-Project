package com.upgrade.pages;

import com.upgrade.utitilies.BrowserUtils;
import com.upgrade.utitilies.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserUtils {
    public LoginPage() {
        //it's mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(), this);
    }
    InfoGetLoanPage info = new InfoGetLoanPage();

    private static Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//*[@id='header-nav-toggle']/following-sibling::label")
    public WebElement menuBar;

    @FindBy(xpath = "//a[contains(text(),'Sign Out')]")
    public WebElement signOut;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[contains(text(),'Sign in to your account')]")
    public WebElement signIntoAccount;



    public void menuBarClick() {
        waitForVisibility(menuBar, 60);
        timeOut(2000);
        menuBar.click();
    }

    public void signOutClick() {
        waitForVisibility(signOut, 60);
        timeOut(2000);
        signOut.click();
    }

    public void enterUserName(String username) {
        waitForVisibility(userName, 60);
        userName.sendKeys(username);

    }

    public void enterPassword(String pass) {
        waitForVisibility(password, 60);
        password.sendKeys(pass);
    }
    public void signInAccount() {
        waitForVisibility(signIntoAccount, 60);
        signIntoAccount.click();
        timeOut(2000);
    }


}