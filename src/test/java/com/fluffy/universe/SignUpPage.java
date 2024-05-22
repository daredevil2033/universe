package com.fluffy.universe;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    private SelenideElement firstName = $("#sign-up__first-name");
    private SelenideElement lastName = $("#sign-up__last-name");
    private SelenideElement email = $("#sign-up__email");
    private SelenideElement password = $("#sign-up__password");
    private SelenideElement confirmPassword = $("#sign-up__confirm-password");
    private SelenideElement signUpButton = $(".form__button");

    public void open() {
        com.codeborne.selenide.Selenide.open("http://localhost:7000/sign-up");
    }

    public void enterFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }

    public void enterLastName(String lastName) {
        this.lastName.setValue(lastName);
    }

    public void enterEmail(String email) {
        this.email.setValue(email);
    }

    public void enterPassword(String password) {
        this.password.setValue(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        this.confirmPassword.setValue(confirmPassword);
    }

    public void clickSignUpButton() {
        this.signUpButton.click();
    }
}
