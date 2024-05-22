package com.fluffy.universe;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreatePostPage {
    private SelenideElement postTitle = $(".post-form__title");
    private SelenideElement postBody = $(".post-form__description");
    private SelenideElement createPostButton = $(".post-form__button:nth-child(2)");

    public void open() {
        com.codeborne.selenide.Selenide.open("http://localhost:7000/posts/create");
    }

    public void enterPostTitle(String title) {
        postTitle.setValue(title);
    }

    public void enterPostBody(String body) {
        postBody.setValue(body);
    }

    public void clickCreatePostButton() {
        createPostButton.click();
    }
}
