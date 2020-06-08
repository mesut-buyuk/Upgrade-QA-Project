Feature: API Testing

  @APITest
  Scenario: Login with authorized and unauthorized user
    Given Client wants to Login with authorized user
    And Client wants to Login with unauthorized user