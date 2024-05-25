@SignIn
Feature: SignIn
  As a Registered User of the application
  I want to validate the Sign In functionality
  In order to check if it works as desired

  Background: A Registered User navigates to SignIn page
    Given I navigate to the "/sign-in" page

  @SuccessfulSignIn
  Scenario Outline: Successful login using valid credentials
    When I fill in "#sign-in__email" with "<email>"
    And I fill in "#sign-in__password" with "<password>"
    And I click on the ".form__button" button
    Then I should be successfully signed in
    Examples:
      | email          | password      |
      | test@gmail.com | F6dvj!FGE9MYR |

  @FailedSignIn
  Scenario Outline: Failed login using wrong credentials
    When I fill in "#sign-in__email" with "<email>"
    And I fill in "#sign-in__password" with "<password>"
    And I click on the ".form__button" button
    Then I should land on the "/sign-in" page
    And I should see "alert" message as "<alert>"
    Examples:
      | email            | password | alert                                                             |
      | test@example.com | test     | Invalid email or password. Please check your input and try again. |

  @DisabledSignIn
  Scenario Outline: Disabled SignIn when one of the required fields is left blank
    When I fill in "#sign-in__email" with "<email>"
    And I fill in "#sign-in__password" with "<password>"
    And I click on the ".form__button" button
    Then I should see "<form error>" message for <input field> field
    Examples:
      | email                 | password  | form error          | input field |
      |                       | Asdf@1234 | Enter a valid email | 0           |
      | asdf.asdf@example.com |           | Enter a password    | 1           |
