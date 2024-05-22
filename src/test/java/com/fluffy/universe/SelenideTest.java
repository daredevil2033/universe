package com.fluffy.universe;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = Browsers.CHROME;
        open("http://localhost:7000/");
        getWebDriver().manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void SignUpTest() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.open();
        signUpPage.enterFirstName("FirstName");
        signUpPage.enterLastName("LastName");
        signUpPage.enterEmail("test@gmail.com");
        signUpPage.enterPassword("F6dvj!FGE9MYR");
        signUpPage.enterConfirmPassword("F6dvj!FGE9MYR");
        screenshot("BeforeSignUp");
        signUpPage.clickSignUpButton();
        screenshot("AfterSignUp");
    }

    @Test
    public void CreatePostTest() {
        CreatePostPage createPostPage = new CreatePostPage();
        createPostPage.open();
        createPostPage.enterPostTitle("Post Title");
        createPostPage.enterPostBody("Post Body");
        screenshot("BeforeCreatePost");
        createPostPage.clickCreatePostButton();
        screenshot("AfterCreatePost");
    }

    @Test
    public void CommentPostTest() {
        PostPage postPage = new PostPage();
        postPage.open(1);
        postPage.enterComment("Post Comment");
        screenshot("BeforeCommentPost");
        postPage.clickCommentButton();
        screenshot("AfterCommentPost");
    }
}