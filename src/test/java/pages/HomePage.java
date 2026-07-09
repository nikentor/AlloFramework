package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String ALLO_LOGO = "//a[@class='v-logo']";
    private final String SEARCH_FIELD = "//input[@id='search-form__input']";
    private final String SEARCH_BUTTON = "//span[@class='search-form__submit-button-text']";
    private final String CITY_LABEL = "//span[@class='mh-loc__label']";
    private final String DNIPRO_BUTTON = "//a[@data-geo-select-city='Дніпро']";
    private final String CHOOSE_CITY_TEXT = "//h3[@class='geo__title']";
    private final String BUYERS_BUTTON = "//a[@class='mh-button mh-button--open']";
    private final String DROPDOWN_MENU = "//div[@class='mh-button__dropdown']";
    private final String SHIPMENT_PAYMENT = "//div[@class='mh-button__dropdown']//a[@href='https://allo.ua/ua/help/shipment_payment/']";

    public WebElement alloLogo() {
        return visibilityOfElementByXpath(ALLO_LOGO);
    }

    public WebElement searchField() {
        return visibilityOfElementByXpath(SEARCH_FIELD);
    }

    public WebElement searchButton() {
        return visibilityOfElementByXpath(SEARCH_BUTTON);
    }

    public WebElement cityButton() {
        return visibilityOfElementByXpath(CITY_LABEL);
    }

    public WebElement dniproButton() {
        return visibilityOfElementByXpath(DNIPRO_BUTTON);
    }

    public WebElement chooseCity() {
        return visibilityOfElementByXpath(CHOOSE_CITY_TEXT);
    }

    public WebElement cityName() {
        return visibilityOfElementByXpath(CITY_LABEL);
    }

    public WebElement buyersButton() {
        return visibilityOfElementByXpath(BUYERS_BUTTON);
    }

    public WebElement dropDownMenu() {
        return visibilityOfElementByXpath(DROPDOWN_MENU);
    }

    public WebElement shipmentPayment() {
        return visibilityOfElementByXpath(SHIPMENT_PAYMENT);
    }

    public boolean alloLogoDisplayed() {
        return alloLogo().isDisplayed();
    }

    public boolean searchFieldDisplayed() {
        return searchField().isDisplayed();
    }

    public boolean buyersButtonDisplayed() {
        return buyersButton().isDisplayed();
    }

    public boolean dropDownMenuDisplayed() {
        return dropDownMenu().isDisplayed();
    }

    public boolean shipmentPaymentDisplayed() {
        return shipmentPayment().isDisplayed();
    }

    public void enterValuesInSearchField(String value) {
        searchField().sendKeys(value);
    }

    public void clickSearchButton() {
        searchButton().click();
    }

    public boolean chooseCityDisplayed() {
        return chooseCity().isDisplayed();
    }

    public void clickCityButton() {
        cityButton().click();
    }

    public void clickDniproButton() {
        dniproButton().click();
    }

    public void clickBuyersButton() {
        buyersButton().click();
    }

    public void clickShipmentPayment() {
        shipmentPayment().click();
    }
}