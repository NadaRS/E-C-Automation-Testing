package org.example.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage homePage = null;

    @Given("user goes to home page")
    public void userGoToHomePage(){
        homePage = new P03_homePage(Hooks.driver);
    }

    @When("user enters product name {string} in search field")
    public void userEntersProductNameInSearchField(String productName) throws InterruptedException {
        homePage.search(productName);
    }

    @When("user enters product sku {string} in search field")
    public void userEntersProductSkuInSearchField(String sku) throws InterruptedException {
        homePage.skuSearch(sku);
    }
}
