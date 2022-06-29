package org.example.Pages;

import org.example.StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;


public class P03_homePage {
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public P03_homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //F03_currencies
    @FindBy(id = "customerCurrency")
    WebElement customerCurrencyPageFactory;
    public void changeCurrency(){
//        driver.findElement(By.id("customerCurrency")).click();
//        driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")).click();
        //OR
        Select select = new Select(customerCurrencyPageFactory);
        select.selectByVisibleText("Euro");
    }

    //F03_currencies
    public void checkCurrencyChanges() {
        //get size/count of elements with the same cssSelector
        int count = driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size();
        for (int i=0; i<count; i++){
            String cssSelectorText = driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(i).getText();
            Assert.assertTrue(cssSelectorText.contains("€"),"Currency does not changed to €.");
        }
    }

    //F04_search | user could search for products names
    //id of search field
    //By id = By.id("small-searchterms");
   // WebElement searchFieldPageFactory = driver.findElement(By.id("small-searchterms"));
    By class_name = By.cssSelector("h2[class=\"product-title\"]");
    public void search(String productName) throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys(productName);
        driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);

        //Assert 1
        String urlText = driver.getCurrentUrl();
//        System.out.println("urlText "+urlText);
        softAssert.assertTrue(urlText.contains(productName),"Product is incorrect");
        //Assert 2
        int count = driver.findElements(class_name).size();
        for (int i=0; i<count; i++){
            String productTitleText = driver.findElements(class_name).get(i).getText().toLowerCase();
//            System.out.println("productTitleText  "+productTitleText +"  productName  "+productName);
            softAssert.assertTrue(productTitleText.contains(productName),"Product is incorrect");
            Thread.sleep(1100);
        }
        softAssert.assertAll();
    }

    //F04_search | user could search for products sku
    public void skuSearch(String sku) throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys(sku);
        driver.findElement(By.id("small-searchterms")).submit();

        //Assert 1
        int count = driver.findElements(class_name).size();
        System.out.println("count "+ count);
        softAssert.assertTrue(count <= 1 , "Error: sku must relate to only one product.");
        //Assert 2
//        System.out.println("before click");
//        driver.findElement(By.cssSelector("h2[class=\"product-title\"]")).findElement(By.partialLinkText(sku.toLowerCase())).click();
//        System.out.println("after click");
//        System.out.println(" CurrentUrl "+driver.getCurrentUrl());
//        String skuText = driver.findElement(By.cssSelector("span[class=\"value\"]")).getText();
//        System.out.println("skuText "+ skuText + "  sku   "+sku);
//        softAssert.assertTrue(skuText.contains(sku), "Error: sku does not match text");
//        softAssert.assertAll();
    }

    //F05_hoverCategories
    public void hoverACategory() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        WebElement computers = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
        action.moveToElement(computers).perform();
        Thread.sleep(1000);
        String expectedSubCategoryText = Hooks.driver.findElement(By.cssSelector("ul[class=\"sublist first-level\"] a[href=\"/desktops\"]")).getText().toLowerCase().trim();
        //System.out.println("expectedSubCategoryText" + expectedSubCategoryText);

        //navigates to desktops
        Hooks.driver.findElement(By.cssSelector("ul[class=\"sublist first-level\"] a[href=\"/desktops\"]")).click();

        String actualSubCategoryText = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText().toLowerCase().trim();
        //System.out.println("actualSubCategoryText" + actualSubCategoryText);
        Assert.assertTrue(actualSubCategoryText.contains(expectedSubCategoryText), "Not same Sub-Category Text.");
        Thread.sleep(1000);
    }

    //F06_sliders -- Nokia
    public void clickOnNokiaSlider(){
        driver.findElement(By.cssSelector("a[rel=\"0\"]")).click();
    }

    //F06_sliders -- Nokia
    public void checkNokiaFalseReaction(){
        String expectedURl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualURl = driver.getCurrentUrl();
        Assert.assertFalse(actualURl.contains(expectedURl), "Error:It is expected different URLs");
    }

    //F06_sliders -- iPhone
    public void clickOnIPhoneSlider(){
        driver.findElement(By.cssSelector("a[rel=\"1\"]")).click();
    }

    //F06_sliders -- iPhone
    public void checkIPhoneFalseReaction(){
        String expectedURl = "https://demo.nopcommerce.com/iphone-6";
        String actualURl = driver.getCurrentUrl();
        Assert.assertFalse(actualURl.contains(expectedURl), "Error:It is expected different URLs");
    }

    //F07_FollowUs -- Facebook
    public void chooseFacebook(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
    }
    //This method will be used for Facebook, Twitter, RSS and YouTube
    public void checkIsOpenedInNewTab(String theExpectedURl) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1).toString());

        //Assert
        String expectedURl = theExpectedURl;
        System.out.println("expectedURl  "+expectedURl);
        String actualURl = driver.getCurrentUrl();
        System.out.println("actualURl  "+actualURl);
        System.out.println(Hooks.driver.getTitle());
        Assert.assertEquals(actualURl , expectedURl);
        driver.close(); //closes one tab
        Hooks.driver.switchTo().window(Tabs.get(0).toString());
        System.out.println("CurrentURl  "+Hooks.driver.getCurrentUrl());
        System.out.println(Hooks.driver.getTitle());
        Thread.sleep(2000);
    }
    //F07_FollowUs -- Twitter
    public void chooseTwitter(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")).click();
    }

    //F07_FollowUs -- RSS
    public void chooseRSS(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]")).click();
    }

    //F07_FollowUs -- YouTube
    public void chooseYouTube(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")).click();
    }

    //F08_Wishlist -- HTC One M8 Android L 5.0 Lollipop
    public void addProductToWishlist(){
        Hooks.driver.findElements(By.className("add-to-wishlist-button")).get(2).click();
    }

    public void checkSuccessMessageIsVisible() throws InterruptedException {
        Thread.sleep(2000);
        //Assert1
        softAssert.assertTrue(Hooks.driver.findElement(By.className("content")).isDisplayed());
        //Assert2
        String expectedHexColor = "#4bb07a";
        String actualRGBAColor = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
        String actualHexColor = Color.fromString(actualRGBAColor).asHex();
        softAssert.assertEquals(actualHexColor,expectedHexColor, "Error Message: Wrong Color");
        softAssert.assertAll();
    }

    //F08_Wishlist -- HTC One M8 Android L 5.0 Lollipop scenario 2
    public void clickOnWishlistTabOnTopOfThePage() throws InterruptedException {
        Thread.sleep(2000);
        WebElement successBar = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
        //explicit Wait for success green bar to disappear
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(successBar));

        //Then user  can press on wishList
        Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]")).click();

        String qtyValue = Hooks.driver.findElement(By.className("qty-input")).getAttribute("value");
        int qtyNumber = Integer.parseInt(qtyValue);
        //System.out.println(qtyNumber + "  qtyValue");
        Assert.assertTrue((qtyNumber>0), "Error: qtyNumber is not bigger than zero.");
    }
}
