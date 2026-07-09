package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAndPaymentPage extends BasePage {

    public DeliveryAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    private final String HOW_TO_ORDER = "//button[@class='sp-tablinks active']";

    public WebElement howToOrder() {
        return visibilityOfElementByXpath(HOW_TO_ORDER);
    }

    public boolean howToOrderDisplayed() {
        return howToOrder().isDisplayed();
    }

    public String howToOrderText() {
        return howToOrder().getText();
    }

    public boolean pageTitleContains(String title) {
        return driver.getTitle().contains(title);
    }
}
