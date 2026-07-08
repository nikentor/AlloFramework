package tests;

import basesClass.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestInit {

    public String alloUrl = "https://allo.ua/";

    @Test
    public void checkAlloLogoDisplay() {

        HomePage homePage = new HomePage(driver);
        openUrl(alloUrl);
        Assert.assertTrue(homePage.alloLogo().isDisplayed());
    }
}