@SignUp
Feature: SignUp
  As an Un-registered User of the application
  I want to validate the Sign Up functionality
  In order to check if it works as desired

  Background: User navigates to Sign Up page
    Given I navigate to the "/sign-up" page

  @SuccessfulSignUp
  Scenario Outline: Successful Sign Up using valid credentials
    When I fill in "#sign-up__first-name" with "<first-name>"
    And I fill in "#sign-up__last-name" with "<last-name>"
    And I fill in "#sign-up__email" with "<email>"
    And I fill in "#sign-up__password" with "<password>"
    And I fill in "#sign-up__confirm-password" with "<confirm-password>"
    And I click on the ".form__button" button
    Then I should be successfully registered
    Examples:
      | first-name | last-name | email                 | password  | confirm-password |
      | asdf       | asdf      | asdf.asdf@example.com | Asdf@1234 | Asdf@1234        |

  @DisabledSignUp
  Scenario Outline: Disabled Sign Up when one of the required fields is left blank
    When I fill in "#sign-up__first-name" with "<first-name>"
    And I fill in "#sign-up__last-name" with "<last-name>"
    And I fill in "#sign-up__email" with "<email>"
    And I fill in "#sign-up__password" with "<password>"
    And I fill in "#sign-up__confirm-password" with "<confirm-password>"
    And I click on the ".form__button" button
    Then I should see "<form error>" message for <input field> field
    Examples:
      | first-name | last-name | email                 | password  | confirm-password | form error             | input field |
      |            | asdf      | asdf.asdf@example.com | Asdf@1234 | Asdf@1234        | Enter first name       | 0           |
      | asdf       |           | asdf.asdf@example.com | Asdf@1234 | Asdf@1234        | Enter last name        | 1           |
      | asdf       | asdf      |                       | Asdf@1234 | Asdf@1234        | Enter a valid email    | 2           |
      | asdf       | asdf      | asdf.asdf@example.com |           |                  | Enter a password       | 3           |
      | asdf       | asdf      | asdf.asdf@example.com | Asdf@1234 |                  | Confirm your password  | 4           |
      | asdf       | asdf      | asdf.asdf@example.com |           | Asdf@1234        | Passwords do not match | 4           |