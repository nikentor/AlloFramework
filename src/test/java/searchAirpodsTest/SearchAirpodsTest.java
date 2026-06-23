package homePageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchAirpodsTest {

    @Test
    public void searchAirPodsTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");
        WebElement alloLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='v-logo']")));
        Assert.assertTrue(alloLogo.isDisplayed(), "Allo logo is not visible");
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-form__input")));
        searchInput.sendKeys("AirPods Pro 3");
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        List<WebElement> products = driver.findElements(By.cssSelector(".product-card__title"));
        Assert.assertFalse(products.isEmpty(), "No products found");
        String firstText = products.get(0).getText();
        System.out.println("First product: " + firstText);
        Assert.assertTrue(firstText.toLowerCase().contains("airpods pro 3"),"First product does not contain AirPods. Actual: " + firstText);

        products.get(0).click();
        Thread.sleep(2000);

        WebElement productTitle = driver.findElement(By.cssSelector("h1"));
        String actualProductName = productTitle.getText();
        Assert.assertTrue(actualProductName.contains("AirPods Pro 3"),"Product names do not match!");

        driver.quit();
    }
}