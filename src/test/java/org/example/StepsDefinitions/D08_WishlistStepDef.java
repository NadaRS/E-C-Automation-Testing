package org.example.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage homePage = null;

    @Given("user would be navigated to home page")
    public void userWouldBeNavigatedToHomePage() {
        homePage = new P03_homePage(Hooks.driver);
    }

    @When("user add product to Wishlist")
    public void userAddProductToWishlist() {
        homePage.addProductToWishlist();
    }

    @Then("Wishlist notification success is visible")
    public void wishlistNotificationSuccessIsVisible() throws InterruptedException {
        homePage.checkSuccessMessageIsVisible();
    }

    @Then("user click on Wishlist tab on top of the page")
    public void userClickOnWishlistTabOnTopOfThePage() throws InterruptedException {
        homePage.clickOnWishlistTabOnTopOfThePage();
    }
}
