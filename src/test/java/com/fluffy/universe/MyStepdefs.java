package com.fluffy.universe;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {

    @Then("I should be successfully registered")
    public void iShouldBeSuccessfullyRegistered() {
        iShouldSeeMessageAs("alert", "You have successfully signed up. Welcome to our community!");
        iShouldBeSuccessfullySignedIn();
    }

    @Then("I should be successfully signed in")
    public void iShouldBeSuccessfullySignedIn() {
        iShouldLandOnThePage("/");
        $(".header__link--primary").shouldHave(text("New post"));
    }

    @Given("I am a signed in user")
    public void iAmASignedInUser() {
        open("/sign-in");
        $("#sign-in__email").setValue("test@gmail.com");
        $("#sign-in__password").setValue("F6dvj!FGE9MYR");
        $(".form__button").click();
    }

    @Then("I should be successfully signed out")
    public void iShouldBeSuccessfullySignedOut() {
        $(".header__link--primary").shouldHave(text("Sign up"));
    }

    @Given("I navigate to the {string} page")
    public void iNavigateToThePage(String arg0) {
        open(arg0);
    }

    @Then("I should land on the {string} page")
    public void iShouldLandOnThePage(String arg0) {
        String baseUrl = "http://localhost:7000";
        assertEquals(baseUrl + arg0, url());
    }

    @When("I fill in {string} with {string}")
    public void iFillInWith(String arg0, String arg1) {
        $(arg0).setValue(arg1);
    }

    @When("I hover over my profile icon")
    public void iHoverOverMyProfileIcon() {
        $(".dropdown").hover();
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String arg0) {
        $(arg0).click();
    }

    @And("I should see {string} message as {string}")
    public void iShouldSeeMessageAs(String arg0, String arg1) {
        if (arg0.equals("alert")) {
            $(".alert__description").shouldHave(text(arg1));
        } else if (arg0.equals("error")) {
            $(".error__heading").shouldHave(text(arg1));
        }
    }

    @Then("I should see {string} message for {int} field")
    public void iShouldSeeMessageForField(String arg0, int arg1) {
        $$(".form__feedback").get(arg1).shouldHave(text(arg0));
    }

    @And("I should see the new post on the Homepage with the title {string} and body {string}")
    public void iShouldSeeTheNewPostOnTheHomepageWithTheTitleAndBody(String arg0, String arg1) {
        $$(".card").findBy(text(arg0)).$(".card__description").shouldHave(text(arg1));
    }

    @Then("I should see the comment {string} added to the Post")
    public void iShouldSeeTheCommentAddedToThePost(String arg0) {
        assertTrue($$(".comment__description").findBy(text(arg0)).exists());
    }

    @And("I should see {string} heading on the Profile page")
    public void iShouldSeeHeadingOnTheProfilePage(String arg0) {
        $(".account-form__heading").shouldHave(text(arg0));
    }

    @And("Email field should be prepopulated and set as disabled on the Profile page")
    public void emailFieldShouldBePrepopulatedAndSetAsDisabledOnTheProfilePage() {
        $("#account__email").shouldHave(value("test@gmail.com"), disabled);
    }

    @And("I select {string} in {string}")
    public void iSelectIn(String arg0, String arg1) {
        $(arg1).selectOption(arg0);
    }

    @And("I click on My profile button")
    public void iClickOnMyProfileButton() {
        $$(".dropdown__link").get(0).click();
    }

    @And("I click on Sign out button")
    public void iClickOnSignOutButton() {
        $$(".dropdown__link").get(2).click();
    }
}
