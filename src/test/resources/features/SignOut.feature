@SignOut
Feature: SignOut
  As a Signed In User of the application
  I want to Sign Out successfully

  Background: User is signed in and is on Homepage
    Given I am a signed in user

  @SuccessfulSignOut
  Scenario: Successful Sign Out
    When I hover over my profile icon
    And I click on Sign out button
    Then I should be successfully signed out