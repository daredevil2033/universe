@Profile
Feature: View/Edit Profile
  As a Registered User of the application
  I want to view and update my profile

  Background: User is logged in and is on Homepage
    Given I am a signed in user

  @ViewProfile
  Scenario: Successful View Profile
    When I hover over my profile icon
    And I click on My profile button
    Then I should land on the "/account" page
    And I should see "Account" heading on the Profile page
    And Email field should be prepopulated and set as disabled on the Profile page

  @EdiProfile
  Scenario Outline: Successful Edit Profile
    When I hover over my profile icon
    And I click on My profile button
    And I fill in "#account__first-name" with "<firstname>"
    And I fill in "#account__last-name" with "<lastname>"
    And I select "<gender>" in "#account__gender"
    And I fill in "#account__birthday" with "<birthday>"
    And I fill in "#account__address" with "<address>"
    And I fill in "#account__website" with "<website>"
    And I click on the ".button--primary" button
    Then I should land on the "/account" page
    And I should see "alert" message as "User account data updated successfully."
    Examples:
      | firstname | lastname | birthday   | gender | address | website             |
      | Van       | Kov      | 2000-09-11 | Male   | U-99    | https://example.com |
    
    