package tests;

import basesClass.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class HomePageTest extends TestInit {

    public String alloUrl = "https://allo.ua/";

    @Test
    public void checkAlloLogoDisplay() {
        HomePage homePage = new HomePage(driver);
        
        openUrl(alloUrl);
        Assert.assertTrue(homePage.alloLogo().isDisplayed());
    }

    @Test
    public void searchHairdryerTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        String hairdryer = "Фен";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchField().isDisplayed());
        homePage.enterValuesInSearchField(hairdryer);
        homePage.clickSearchButton();

        Assert.assertTrue(searchResultPage.firstGoods().getText().contains(hairdryer), "First product does not contain 'Фен'");
    }
}
