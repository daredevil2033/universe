@ForgotPassword
Feature: Forgot Password
  As a Registered User of the application
  I want to reset/regenerate my password via Forgot Password functionality

  @FailedForgotPassword
  Scenario Outline: Successful submit of forgot password form with unregistered email
    When I navigate to the "/forgot-password" page
    And I fill in "#forgot-password__email" with "<email>"
    And I click on the ".form__button" button
    Then I should land on the "/sign-in" page
    And I should see "alert" message as "<alert>"
    # There should be no way to determine whether an email is registered or not
    # This is confidential information and can be used against the user
    Examples:
      | email                    | alert                                                                      |
      | unregistered@example.com | We have sent you an email with instructions on how to reset your password. |