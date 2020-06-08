package com.upgrade.pages;

import com.upgrade.utitilies.BrowserUtils;
import com.upgrade.utitilies.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class InfoGetLoanPage extends BrowserUtils {

    public InfoGetLoanPage() {
        //it's mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(), this);
    }



    private static Logger logger = Logger.getLogger(InfoGetLoanPage.class);
    //this is for seeing logs comments

    @FindBy(tagName = "select")
    public WebElement selectPurpose;

    @FindBy(xpath = "//*[contains(text(),'Check your rate')]")
    public WebElement checkYourRate;

    @FindBy(name = "desiredAmount")
    public WebElement desiredAmount;

    @FindBy(xpath ="//*[@name='borrowerFirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@name='borrowerLastName']")
    public WebElement lastName;

    @FindBy(id = "borrowerStreet")
    public WebElement address1;

    @FindBy(xpath = "//*[@name='borrowerDateOfBirth']")
    public WebElement DOB;

    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    public WebElement continueApp;

    @FindBy(xpath = "//*[@name='borrowerIncome']")
    public WebElement annualIncome;

    @FindBy(xpath = "//*[@name='borrowerAdditionalIncome']")
    public WebElement additionalIncome;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement emailAddress;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordAddress;

   // @FindBy(xpath = "//*[@name='agreements']")
    @FindBy(xpath = "//*[@name='agreements']/following-sibling::div[1]")
    public WebElement agreementAddress;

    @FindBy(xpath = "//button[contains(text(),'Check Your Rate')]")
    WebElement checkYourRate2;

    @FindBy(xpath = "//*[@id='root']/div/main/div/div[1]/div/h2']")
    public WebElement failOffer;

    @FindBy(xpath = "//*[@data-auto='userLoanAmount']")
    WebElement successOffer;

    public void enterYourLoanAmount(String amount){
        waitForVisibility(desiredAmount,60);
        desiredAmount.sendKeys(amount);
    }

    public void selectPurpose(){
        Select select = new Select(selectPurpose);
        select.selectByValue("SMALL_BUSINESS");
    }

    public void clickSubmit(){
        waitForVisibility(checkYourRate,60);
        checkYourRate.click();
    }
    public void clickSubmit2(){
        waitForVisibility(checkYourRate2,60);
        checkYourRate2.click();
    }

    public void enterFirstAndLastName(String name, String last){
        waitForVisibility(firstName,60);
        firstName.sendKeys(name);
        lastName.sendKeys(last);
    }

    public void enterAddress(String address){
        waitForVisibility(address1,60);
        address1.sendKeys(address);
        timeOut(2000);
        address1.sendKeys(Keys.ARROW_DOWN);
        timeOut(2000);
        address1.sendKeys(Keys.ENTER);
    }

    public void enterDBO(String dbo){
        waitForVisibility(DOB,60);
        DOB.sendKeys(dbo);
    }

    public void clickContinue(){
        waitForVisibility(continueApp,60);
        timeOut(2000);
        continueApp.click();
    }
    @FindBy(xpath = "//*[@id='root']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/button")
    WebElement continueApp2;

    public void clickContinue2(){
        waitForVisibility(continueApp,60);
        timeOut(2000);
        int i =0;
        while (i<2) {
            timeOut(1000);
            try {
                continueApp2.click();
            }catch (Exception e){
                e.printStackTrace();
            }
            i++;

        }
    }

    public void enterAnnualIncome(String income) {
        waitForVisibility(annualIncome,60);
        annualIncome.sendKeys(income);
    }
    public void enterAdditionalIncome(String income) {
        waitForVisibility(additionalIncome,6);
        additionalIncome.sendKeys(income);
    }

    public void enterEmail(String email) {
        waitForVisibility(emailAddress,60);
        emailAddress.sendKeys(email);
    }
    public void enterPassword(String password) {
        waitForVisibility(passwordAddress,60);
        passwordAddress.sendKeys(password);
    }
    public void clickAgreements() {

        timeOut(2000);
        agreementAddress.click();
    }
    public String saveOffer(){
        timeOut(6000);
        return failOffer.getText();
    }

    public String saveOffer2(){
        timeOut(6000);
        return successOffer.getText();
    }




}
