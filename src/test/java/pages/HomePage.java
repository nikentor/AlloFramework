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

    public WebElement alloLogo() {
        return visibilityOfElementByXpath(ALLO_LOGO);
    }

    public WebElement searchField() {
        return visibilityOfElementByXpath(SEARCH_FIELD);
    }

    public WebElement searchButton() {
        return visibilityOfElementByXpath(SEARCH_BUTTON);
    }

    public void alloLogoDisplayed() {
        alloLogo().isDisplayed();
    }

    public void enterValuesInSearchField(String value) {
        searchField().sendKeys(value);
    }

    public void clickSearchButton() {
        searchButton().click();
    }
}