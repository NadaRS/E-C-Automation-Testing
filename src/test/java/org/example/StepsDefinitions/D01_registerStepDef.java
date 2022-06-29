package org.example.StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_register;
import org.openqa.selenium.By;

public class D01_registerStepDef {
    P01_register registerPage = null;
    
    @Given("user go to register page")
    public void goToRegisterPage(){
        registerPage = new P01_register(Hooks.driver);
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click(); //clicks on register in home Page
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        Hooks.driver.findElement(By.id("gender-female")).click();
    }

    @When("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstname, String lastname) {
        registerPage.enterFirstNameAndLastNameSteps(firstname,lastname);
    }

    @When("user enter date of birth")
    public void userEnterDateOfBirth() {
        registerPage.createDateOfBirth();
    }

    @When("user enter email {string} field")
    public void userEnterEmailField(String email) throws InterruptedException {
        registerPage.enterEmail(email);
        Thread.sleep(2000);
    }

    @When("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String password, String confirmPassword) {
        registerPage.enterPasswordFields(password, confirmPassword);
    }

    @Then("user clicks on register button")
    public void userClicksOnRegisterButton() {
        Hooks.driver.findElement(By.id("register-button")).click();
    }

    @And("success message is displayed")
    public void successMessageIsDisplayed() throws InterruptedException {
        registerPage.checkSuccessMessage();
        Hooks.driver.findElement(By.cssSelector("a[class=\"button-1 register-continue-button\"]")).click();
        //driver.findElement(By.className("button-1 register-continue-button")).click();//a[class="button-1 register-continue-button"]
        Thread.sleep(3000);
    }
}
