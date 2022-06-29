package org.example.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = null;

    @Given("user is navigated to home page")
    public void userIsNavigatedToHomePage() {
        homePage = new P03_homePage(Hooks.driver);
    }

    @When("user click on Nokia slider")
    public void userClickOnNokiaSlider() {
        homePage.clickOnNokiaSlider();
    }

    @Then("Confirm Nokia false reaction")
    public void confirmFalseReaction() {
        homePage.checkNokiaFalseReaction();
    }

    @When("user click on iPhone slider")
    public void userClickOnIPhoneSlider() {
        homePage.clickOnIPhoneSlider();
    }

    @Then("Confirm iPhone false reaction")
    public void confirmIPhoneFalseReaction() {
        homePage.checkIPhoneFalseReaction();
    }
}
