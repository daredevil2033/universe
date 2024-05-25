@Post
Feature: Add Post
  As a Signed In User of the application
  I want to write a Post successfully

  Background: User is signed in and is on Homepage
    Given I am a signed in user

  @SuccessfulLandOnAddPost
  Scenario: Successful landing on Create a Post
    When I click on the ".header__link--primary" button
    Then I should land on the "/posts/create" page

  @SuccessfulAddPost
  Scenario Outline: Successful creation of a Post
    When I click on the ".header__link--primary" button
    And I fill in ".post-form__title" with "<post title>"
    And I fill in ".post-form__description" with "<post body>"
    And I click on the ".post-form__button.button--primary" button
    Then I should land on the "/" page
    And I should see "alert" message as "Blog post published successfully."
    And I should see the new post on the Homepage with the title "<post title>" and body "<post body>"
    Examples:
      | post title | post body |
      | Test Title | Test Body |
	  