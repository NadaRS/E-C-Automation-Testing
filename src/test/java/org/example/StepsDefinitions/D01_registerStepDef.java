package org.example.StepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D01_registerStepDef {
    WebDriver driver = null;
    P01_register registerPage = null;
    
    @Given("user go to register page")
    public void goToRegisterPage() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver_linux64/chromedriver" ;
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
        registerPage = new P01_register(driver);
        driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        driver.findElement(By.id("gender-female")).click();
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
        driver.findElement(By.id("register-button")).click();
    }

    @And("success message is displayed")
    public void successMessageIsDisplayed() throws InterruptedException {
        registerPage.checkSuccessMessage();
        driver.findElement(By.cssSelector("a[class=\"button-1 register-continue-button\"]")).click();
        //driver.findElement(By.className("button-1 register-continue-button")).click();//a[class="button-1 register-continue-button"]
        Thread.sleep(3000);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
