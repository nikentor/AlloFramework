package homePageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTest {

    @Test
    public void checkAlloLogoDisplay()  throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        sleep(5000);

        WebElement alloLogoLocator = driver.findElement(By.xpath("//a[@class='v-logo']"));

        Assert.assertTrue(alloLogoLocator.isDisplayed());

        driver.quit();


    }



}
