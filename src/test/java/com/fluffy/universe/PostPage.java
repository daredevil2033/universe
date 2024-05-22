package com.fluffy.universe;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PostPage {
    private SelenideElement commentField = $(".comment-form__textarea");
    private SelenideElement commentButton = $(".comment-form__button:nth-child(1)");

    public void open(int postId) {
        com.codeborne.selenide.Selenide.open("http://localhost:7000/posts/" + postId);
    }

    public void enterComment(String comment) {
        commentField.setValue(comment);
    }

    public void clickCommentButton() {
        commentButton.click();
    }
}
