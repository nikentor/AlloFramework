package alloTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlloTest {

    @Test
    public void changeCityToDniproTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        Thread.sleep(3000);

        WebElement alloLogoLocator = driver.findElement(By.xpath("//a[@class='v-logo']"));
        Assert.assertTrue(alloLogoLocator.isDisplayed(), "Allo logo is not visible");

        WebElement kyivButton = driver.findElement(By.xpath("//span[@class='mh-loc__label']"));
        kyivButton.click();
        Thread.sleep(3000);

        WebElement popup = driver.findElement(By.xpath("//section[@data-geo-tooltip='CitySelectTooltip']"));
        Assert.assertTrue(popup.getText().contains("Обрати місто"), "Popup text not correct");

        WebElement dniproButton = driver.findElement(By.xpath("//a[@data-geo-select-city='Дніпро']"));
        dniproButton.click();

        Thread.sleep(3000);

        WebElement location = driver.findElement(By.xpath("//span[@class='mh-loc__label']"));
        Assert.assertTrue(location.getText().contains("Дніпро"), "City not changed to Dnipro");

        driver.quit();
    }


    @Test
    public void searchHairdryerTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");

        WebElement searchField = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        Assert.assertTrue(searchField.isDisplayed(), "Search field is not displayed");

        searchField.sendKeys("Фен");

        WebElement searchButton = driver.findElement(By.xpath("//span[@class='search-form__submit-button-text']"));
        searchButton.click();

        Thread.sleep(3000);

        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='product-card'])[1]"));
        String productText = firstProduct.getText();

        Assert.assertTrue(productText.contains("Фен"), "First product does not contain 'Фен'");

        driver.quit();
    }


    @Test
    public void airPodsTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");

        WebElement searchField = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        searchField.sendKeys("AirPods 4");

        WebElement searchButton = driver.findElement(By.xpath("//span[@class='search-form__submit-button-text']"));
        searchButton.click();

        Thread.sleep(3000);

        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class='product-card__title'])[1]"));
        String productText = firstProduct.getText();

        Assert.assertTrue(productText.contains("AirPods 4"), "First product does not contain AirPods 4");

        firstProduct.click();

        WebElement productTitle = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));
        String actualProductName = productTitle.getText();

        Assert.assertEquals(actualProductName, productText, "Product name mismatch");

        driver.quit();
    }


    @Test
    public void customerMenuTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");

        WebElement buyersButton = driver.findElement(By.xpath("//a[@class='mh-button mh-button--open']"));
        Assert.assertTrue(buyersButton.isDisplayed(), "Buyers button is not displayed");

        buyersButton.click();
        Thread.sleep(3000);

        WebElement dropdownMenu = driver.findElement(By.xpath("//div[@class='mh-button__dropdown']"));
        Assert.assertTrue(dropdownMenu.isDisplayed(), "Dropdown menu is not displayed");

        WebElement shipmentPayment = driver.findElement(
                By.xpath("//div[@class='mh-button__dropdown']//a[@href='https://allo.ua/ua/help/shipment_payment/']")
        );

        Assert.assertTrue(shipmentPayment.isDisplayed(), "Shipment payment is not visible");

        shipmentPayment.click();

        Thread.sleep(3000);

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Доставка і оплата"), "Title is incorrect");

        WebElement howToOrder = driver.findElement(By.xpath("//button[@class='sp-tablinks active']"));
        String text = howToOrder.getText();

        Assert.assertTrue(howToOrder.isDisplayed(), "Tab not displayed");
        Assert.assertEquals(text, "Як оформити замовлення?", "Tab text mismatch");

        driver.quit();
    }
}