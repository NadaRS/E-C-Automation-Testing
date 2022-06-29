package org.example.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D07_followUsStepDef {
    P03_homePage homePage = null;

    @Given("user will be navigated to home page")
    public void userWillBeNavigatedToHomePage() {
        homePage = new P03_homePage(Hooks.driver);
    }

    @When("user click on facebook")
    public void userClickOnFacebook() {
        homePage.chooseFacebook();
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String expectedURl) throws InterruptedException {
        homePage.checkIsOpenedInNewTab(expectedURl);
    }

    @When("user click on twitter")
    public void userClickOnTwitter() {
        homePage.chooseTwitter();
    }

    @When("user click on youTube")
    public void userClickOnYouTube() {
        homePage.chooseYouTube();
    }

    @When("user click on rss")
    public void userClickOnRss() {
        homePage.chooseRSS();
    }
}
