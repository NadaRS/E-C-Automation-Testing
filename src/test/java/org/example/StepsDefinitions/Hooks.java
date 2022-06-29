package org.example.StepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver = null;

    @Before
    public static void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver_linux64/chromedriver" ;
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
    }
    @After
    public void closeBrowser(){
        if (driver == null) {
            //System.out.println("Driver = "+driver);
        }
        else {
            driver.quit();
        }
    }
}
