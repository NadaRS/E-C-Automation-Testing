package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class P01_register {
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public P01_register(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "FirstName")
    WebElement firstNamePageFactory;

    public WebElement createFirstNameElement(){
        return firstNamePageFactory;
    }
    @FindBy(id = "LastName")
    WebElement lastNamePageFactory;

    public WebElement createLastNameElement(){
        return lastNamePageFactory;
    }

    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDayPageFactory;

    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonthPageFactory;

    @FindBy(name = "DateOfBirthYear")
    WebElement dateOfBirthYearPageFactory;

    @FindBy(id = "Email")
    WebElement emailPageFactory;

    public WebElement createEmailElement(){
        return emailPageFactory;
    }

    @FindBy(id = "Password")
    WebElement passwordPageFactory;

    public WebElement createPasswordElement(){
        return passwordPageFactory;
    }

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordPageFactory;

    public WebElement createConfirmPasswordElement(){
        return confirmPasswordPageFactory;
    }

    public void enterFirstNameAndLastNameSteps(String firstname, String lastname){
        firstNamePageFactory.clear();
        firstNamePageFactory.sendKeys(firstname);
        lastNamePageFactory.clear();
        lastNamePageFactory.sendKeys(lastname);
    }
    public void createDateOfBirth(){
        Select select = new Select(dateOfBirthDayPageFactory);
        select.selectByIndex(10); // select by index: this is day 10

        select = new Select(dateOfBirthMonthPageFactory);
        select.selectByValue("3"); // select by value and it should be String: this is March

        select = new Select(dateOfBirthYearPageFactory);
        select.selectByVisibleText("1998"); // select by linkText and it should be String
    }

    public void enterEmail(String email){
        emailPageFactory.clear();
        emailPageFactory.sendKeys(email);
    }

    public void enterPasswordFields(String password, String confirmPassword){
        passwordPageFactory.clear();
        passwordPageFactory.sendKeys(password);
        confirmPasswordPageFactory.clear();
        confirmPasswordPageFactory.sendKeys(confirmPassword);
    }

    public void checkSuccessMessage() {
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText(); //div[class=result]
        softAssert.assertTrue(actualResult.contains(expectedResult), "Error Message: Message Text is wrong or Failed");

        String actualColor = driver.findElement(By.className("result")).getCssValue("color");
        String expectedColor = "rgba(76, 177, 124, 1)";
//        System.out.println("actualColor  "+actualColor);
//        System.out.println("expectedColor  "+expectedColor);
        softAssert.assertEquals(actualColor,expectedColor, "Error Message: Wrong Color");

        softAssert.assertAll();
    }

}
