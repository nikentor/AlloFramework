package homePageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SearchHairdryerTest {

    @Test
    public void checkHairdryerSearch()  throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://allo.ua/");
            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-form__input")));
            searchField.sendKeys("Фен");
            searchField.sendKeys(Keys.ENTER);
            List<WebElement> products = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".product-card__title"), 0));
            String firstText = products.get(0).getText();
            Assert.assertTrue(firstText.contains("Фен"));
        } finally {
            driver.quit();
        }

    }



}
