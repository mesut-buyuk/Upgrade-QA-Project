package com.upgrade.steps_definitions;


import com.upgrade.pages.InfoGetLoanPage;
import com.upgrade.pages.LoginPage;
import com.upgrade.utitilies.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class Upgrade_Steps {

    InfoGetLoanPage infoGetLoanPage = new InfoGetLoanPage();
    Map<String,String> scopeData = new HashMap<>();

    LoginPage loginPage = new LoginPage();
    Driver urlDriver = new Driver();

    @Given("Client wants to navigate to {string}")
    public void client_wants_to_navigate_to(String url) {
        urlDriver.navigation(url);

    }

    @And("Client wants to enter loan amount as {string} and select purpose as Business")
    public void client_wants_to_enter_loan_amount_as_and_select_purpose_as_Business(String amount) {
        infoGetLoanPage.enterYourLoanAmount(amount);
        infoGetLoanPage.selectPurpose();
        infoGetLoanPage.clickSubmit();
    }

    @Then("Client wants to enter first name as {string} and last name as {string}")
    public void client_wants_to_enter_first_name_as_and_last_name_as(String name, String last) {
        infoGetLoanPage.enterFirstAndLastName(name,last);
    }

    @And("Client wants to enter home address as {string}")
    public void client_wants_to_enter_home_address_as(String adres) {
        infoGetLoanPage.enterAddress(adres);
    }

    @And("Client wants to enter DOB as {string}")
    public void client_wants_to_enter_DOB_as(String dbo) {
        infoGetLoanPage.enterDBO(dbo);
        infoGetLoanPage.clickContinue();
    }

    @And("Client wants to enter annual income as {string}")
    public void client_wants_to_enter_annual_income_as(String income) {
        infoGetLoanPage.enterAnnualIncome(income);
    }

    @And("Client wants to enter additional income as {string}")
    public void client_wants_to_enter_additional_income_as(String income) {
        infoGetLoanPage.enterAdditionalIncome(income);
        infoGetLoanPage.clickContinue2();
    }

    @And("Client wants to enter email address as{string}")
    public void client_wants_to_enter_email_address_as(String email) {
        infoGetLoanPage.enterEmail(email);
    }

    @And("Client wants to enter password as {string}")
    public void client_wants_to_enter_password_as(String password) {
        infoGetLoanPage.enterPassword(password);
    }

    @And("Client wants to check the box for Terms of Use")
    public void client_wants_to_check_the_box_for_Terms_of_Use() {

        infoGetLoanPage.clickAgreements();
    }

    @And("Client wants to rate")
    public void client_wants_to_rate() {
        infoGetLoanPage.clickSubmit2();
        try {
            scopeData.put("success",infoGetLoanPage.saveOffer2());
        }catch (Exception e){
            scopeData.put("fail",infoGetLoanPage.saveOffer());
        }

    }

    @Then("Client wants to enter Sign Out")
    public void client_wants_to_enter_Sign_Out() {
        loginPage.menuBarClick();
        loginPage.signOutClick();
    }

    @And("Client wants to relogin to {string}")
    public void client_wants_to_relogin_to(String url) {
        urlDriver.navigation(url);
    }

    @Then("Client wants to enter username as {string} and password as {string}")
    public void client_wants_to_enter_username_as_and_password_as(String username, String pass) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(pass);
    }

    @And("Client wants to sign in")
    public void client_wants_to_sign_in() {
        loginPage.signInAccount();
    }

    @And("Client wants to validate previous offer")
    public void client_wants_to_validate_previous_offer() {
      if  ( scopeData.get("success") != null){
          Assert.assertEquals(infoGetLoanPage.saveOffer2(),scopeData.get("success"));
          System.out.println("Loan Pre Approved");
      }else {
          Assert.assertEquals(infoGetLoanPage.saveOffer2(),scopeData.get("fail"));
          System.out.println("Loan Did Not Approved");
      }

    }


}
