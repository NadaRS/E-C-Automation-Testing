package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class P02_login {
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public P02_login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement emailPageFactory;

    @FindBy(id = "Password")
    WebElement passwordPageFactory;

    public void enterEmail(String email){
        emailPageFactory.clear();
        emailPageFactory.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordPageFactory.clear();
        passwordPageFactory.sendKeys(password);
    }

    public void checkSuccessMessage() {
        //first assertion
        String expectedResult = "https://demo.nopcommerce.com/";
        String actualResult = driver.getCurrentUrl();
        softAssert.assertTrue(actualResult.contains(expectedResult), "Error Message: Message Text is wrong or Failed");
        System.out.println("expectedResult  "+expectedResult +"  actualResult  "+actualResult);
        //second assertion
        softAssert.assertTrue(driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed());

        softAssert.assertAll();
    }
    public void checkFailureMessage() {
        //first assertion
        String expectedResult = "Login was unsuccessful.";
        String actualResult = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText();
        softAssert.assertTrue(actualResult.contains(expectedResult), "Error Message: Message Text is wrong or Failed");
        //second assertion
        String actualColorRGBA = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getCssValue("color");
        String actualColor = Color.fromString(actualColorRGBA).asHex();
        String expectedColor = "#e4434b";
//        System.out.println("actualColorRGBA  "+actualColorRGBA);
//        System.out.println("actualColor  "+actualColor);
        softAssert.assertEquals(actualColor,expectedColor, "Error Message: Wrong Color");

        softAssert.assertAll();
    }
}
