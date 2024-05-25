@ResetPassword
Feature: Reset Password
  As a Registered User of the application
  I want to reset my password via Reset Password functionality

  @FailedResetPassword
  Scenario: Password reset token is invalid
    When I navigate to the "/reset-password/token" page
    Then I should see "error" message as "Access forbidden."