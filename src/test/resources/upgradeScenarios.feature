
Feature: Verify Loan Amount

  @VerifyLoanAmount
  Scenario: Verify via the UI that as a borrower - you are seeing loan offers, upon filling the required form fields with valid inputs
    Given Client wants to navigate to "https://www.credify.tech/phone/nonDMFunnel"
    And Client wants to enter loan amount as "2,000" and select purpose as Business
    #In the " Let's get started with some basic information " page, enter
   Then Client wants to enter first name as "Mesut1" and last name as "abcde"
   And Client wants to enter home address as "8685 Independence Parkway"
   And Client wants to enter DOB as "01/01/1965"
   And Client wants to enter annual income as "155,000"
   And Client wants to enter additional income as "6,000"
   And Client wants to enter email address as"candidate55@upgrade-challenge.com"
   And Client wants to enter password as "Amedli21"
   And Client wants to check the box for Terms of Use
   And Client wants to rate
  #4. From the /offer-page, store the Loan Amount, Monthly Payment, Term, Interest Rate and APR from the default
 # offer on top of the page.
  Then Client wants to enter Sign Out
  And Client wants to relogin to "https://www.credify.tech/portal/login"
  And Client wants to enter username as "candidate55@upgrade-challenge.com" and password as "Amedli21"
  And Client wants to sign in
  #6. Make sure you are on /offer-page
  #a. Validate that Loan Amount, APR, Loan Term and Monthly Payment matches with the info stored
  And Client wants to validate previous offer
