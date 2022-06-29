package org.example.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage = null;

    @Given("user navigates to home page")
    public void userNavigatesToHomePage() throws InterruptedException {
        homePage = new P03_homePage(Hooks.driver);
    }

    @When("user choose a category")
    public void userChooseACategory() throws InterruptedException {
        homePage.hoverACategory();
    }
}
