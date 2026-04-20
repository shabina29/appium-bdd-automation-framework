package com.framework.stepdefinitions;



import org.testng.Assert;

import com.framework.screens.android.AppLaunch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AppLaunchSteps {

AppLaunch appLaunch = new AppLaunch();

@Given("User launches the application")
public void user_launches_the_application() {
    // Driver is already launched from Hooks
    System.out.println("Application launched");
}

@Then("User should see the ApiDemos home screen")
public void user_should_see_the_home_screen() {

boolean result = appLaunch.isHomeScreenDisplayed();

Assert.assertTrue(result, "Home screen is not displayed");


}



}
