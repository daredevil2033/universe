@Comment
Feature: Add Comment on a Post
  As a Signed In User of the application
  I want to write a comment to a Post successfully

  Background: User sees a post on Homepage and clicks on it
    Given I am a signed in user
    And I should see the new post on the Homepage with the title "Post Title" and body "Post Body"

  @SuccessfulAddComment
  Scenario Outline: Successful Add Comment to a Post
    When I click on the ".card:nth-child(1) > .card__button" button
    Then I should land on the "/posts/1" page
    When I fill in ".comment-form__textarea" with "<comment>"
    And I click on the ".comment-form__button.button--primary" button
    Then I should see the comment "<comment>" added to the Post
    Examples:
      | comment |
      | asdf    |