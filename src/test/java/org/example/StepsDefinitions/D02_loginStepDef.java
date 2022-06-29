package org.example.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_login;
import org.openqa.selenium.By;

public class D02_loginStepDef {
    P02_login loginPage = null;

    @Given("user go to login page")
    public void userGoToLoginPage(){
        loginPage = new P02_login(Hooks.driver);
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click(); //clicks on login in home Page
    }

    @When("user login with {string} and {string}")
    public void userLoginWithAnd(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Then("user press on login button")
    public void userPressOnLoginButton() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();
        Thread.sleep(2000);
    }

    @And("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() throws InterruptedException {
        loginPage.checkSuccessMessage();
        Thread.sleep(3000);
    }

    @And("user could not login to the system")
    public void userCouldNotLoginToTheSystem() throws InterruptedException {
        loginPage.checkFailureMessage();
        Thread.sleep(3000);
    }

}
