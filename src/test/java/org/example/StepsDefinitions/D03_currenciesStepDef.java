package org.example.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D03_currenciesStepDef {
    P03_homePage homePage = null;

    @Given("user go to home page")
    public void userGoToHomePage(){
        homePage = new P03_homePage(Hooks.driver);
    }

    @When("user changes currency")
    public void userChangeCurrency() {
        homePage.changeCurrency();
    }

    @Then("check changes")
    public void checkChanges() {
        homePage.checkCurrencyChanges();
    }
}
