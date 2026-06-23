package homePageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class customersMenuTest {

    @Test
    public void customersMenuTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://allo.ua/");

        Thread.sleep(2000);
        WebElement buyersButton = driver.findElement(By.xpath("//*[contains(text(),'Покупцям')]"));
        Assert.assertTrue(buyersButton.isDisplayed(), "Button 'Покупцям' is not visible");
        buyersButton.click();
        Thread.sleep(3000);

        WebElement deliveryItem = driver.findElement(By.xpath("//a[contains(@href,'shipment_payment')]"));
        Assert.assertTrue(deliveryItem.isDisplayed(), "Dropdown is not opened");

        deliveryItem.click();
        Thread.sleep(3000);

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Доставка і оплата"), "Title does not contain 'Доставка та оплата'");
        WebElement howToOrder = driver.findElement(By.id("defaultOpenDesc"));
        Assert.assertTrue(howToOrder.isDisplayed(), "How to order button not visible");
        Assert.assertEquals(howToOrder.getText().trim(), "Як оформити замовлення?");
        howToOrder.click();

        Thread.sleep(3000);

        driver.quit();
    }
}