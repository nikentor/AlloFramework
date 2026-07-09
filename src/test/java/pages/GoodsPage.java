package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoodsPage extends BasePage {

    public GoodsPage(WebDriver driver) {
        super(driver);
    }

    private final String GOODS_TITLE = "//h1[@class='p-view__header-title']";

    public WebElement firstGoodsTitle() {
        return visibilityOfElementByXpath(GOODS_TITLE);
    }

    public String getNameGoods() {
        return firstGoodsTitle().getText();
    }
}
