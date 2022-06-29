import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class forTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        //Thread.sleep(1500);
        System.out.println("heree");
        //driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]")).click();
        //System.out.println("here after");

        //driver.findElement(By.cssSelector("a[rel=\"0\"]")).click();
        driver.findElements(By.className("add-to-wishlist-button")).get(2).click();
        System.out.println("here after");


    }
}
