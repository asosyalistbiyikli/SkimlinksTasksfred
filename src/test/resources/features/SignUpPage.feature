@feat/signup
Feature: Users should be able to SignUp

  Background:
    Given the publisher on the SignUp page
 @positive
  Scenario: SignUp with valid credentials
    When the publisher SignUp with valid credentials
    Then  the publisher should see Hi! message

 @negative
  Scenario: SignUp with invalid password credential

    When the publisher SignUp with invalid password credential
    Then the publisher should see password error message
    And the SignUp should not be clickable
  @negative
  Scenario: SignUp with invalid email credential

    When the publisher SignUp with invalid email credential
    Then the publisher should see email error message
    And the SignUp should not be clickable
  @negative
  Scenario: SignUp with without accepting privacy policy

    When the publisher enters valid credentials
    And the publisher does not accept privacy policy
    Then the SignUp should not be clickable
  @negative
  Scenario: SignUp with no credentials

    When the publisher SigUp with no credentials
    Then the publisher should see error messages
    And the SignUp should not be clickable