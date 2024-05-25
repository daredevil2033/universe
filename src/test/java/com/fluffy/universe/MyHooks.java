package com.fluffy.universe;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MyHooks {
    @Before
    public void setUp() {
        System.out.println("Setting up the test");
        Configuration.baseUrl = "http://localhost:7000";
        open("");
        getWebDriver().manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Tearing down the test");
        if (scenario.isFailed()) {
            System.out.println("Test failed");
            scenario.attach(screenshot(scenario.getName().replace(" ", "_")), "image/png", "screenshot");
        }
        closeWebDriver();
    }
}
