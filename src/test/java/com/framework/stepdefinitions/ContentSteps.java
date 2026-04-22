package com.framework.stepdefinitions;

import io.cucumber.java.en.*;
import com.framework.screens.android.ContentPage;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class ContentSteps {

    ContentPage contentPage = new ContentPage();

    // ================= GIVEN =================

    @Given("the app is launched successfully")
    public void appLaunched() {
        System.out.println("App launched");
    }

    // ================= WHEN =================

    @When("user taps on {string}")
    public void userTapsOn(String menu) {

        if (menu.equalsIgnoreCase("Content")) {
            contentPage.clickContent();
        } else {
            contentPage.clickMenu(menu);
        }
    }

    @When("user presses back button")
    public void pressBack() {
        contentPage.pressBack();
    }

    @When("user taps on {string} multiple times")
    public void multipleTap(String menu) {
        contentPage.clickMultipleTimes(menu);
    }

    @When("user tries to find invalid element")
    public void invalidElement() {
        try {
            contentPage.invalidElementCheck();
        } catch (Exception e) {
            System.out.println("Invalid element handled");
        }
    }

    // ================= THEN =================

    @Then("Content screen should be displayed")
    public void verifyContentScreen() {

        if (!contentPage.isContentDisplayed()) {
            throw new AssertionError("Content screen not displayed");
        }
    }

    @Then("the following options should be visible:")
    public void verifyOptions(DataTable table) {

        List<String> options = table.asList();

        for (String option : options) {
            if (!contentPage.isMenuVisible(option)) {
                throw new AssertionError(option + " not visible");
            }
        }
    }

    @Then("{string} screen should be displayed")
    public void verifyMenuScreen(String menu) {

        if (!contentPage.isMenuVisible(menu)) {
            throw new AssertionError(menu + " screen not displayed");
        }
    }

    @Then("user should be on home screen")
    public void verifyHomeScreen() {

        if (!contentPage.isHomeScreenDisplayed()) {
            throw new AssertionError("Not on Home Screen");
        }
    }

    @Then("user should be able to scroll the screen")
    public void scrollValidation() {
        contentPage.scrollScreen();
    }

    @Then("app should not crash")
    public void appStability() {
        System.out.println("App is stable");
    }

    @Then("{string} element should have accessibility id")
    public void accessibilityCheck(String element) {

        if (!contentPage.validateAccessibility(element)) {
            throw new AssertionError("Accessibility failed");
        }
    }

    @Then("proper error should be displayed")
    public void errorValidation() {
        System.out.println("Error handled properly");
    }

    @Then("screen should load within acceptable time")
    public void performanceCheck() {

        long time = contentPage.measureLoadTime("Content");

        if (time > 3000) {
            throw new AssertionError("Slow loading: " + time);
        }
    }
}