package basesClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestInit {

    public WebDriver driver;
    public String alloUrl = "https://allo.ua/";

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        openUrl(alloUrl);

        String source = driver.getPageSource();

        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("TITLE: " + driver.getTitle());
        System.out.println("SOURCE LENGTH: " + source.length());

        System.out.println("HAS LOGO: " + source.contains("v-logo"));
        System.out.println("HAS SEARCH: " + source.contains("search-form__input"));
        System.out.println("HAS BUYERS BUTTON: " + source.contains("mh-button--open"));

        System.out.println("LOGO ELEMENTS: " +
                driver.findElements(org.openqa.selenium.By.cssSelector("[class*='v-logo']")).size());

        System.out.println("SEARCH ELEMENTS: " +
                driver.findElements(org.openqa.selenium.By.cssSelector("[id*='search-form__input']")).size());

        System.out.println("BUYERS ELEMENTS: " +
                driver.findElements(org.openqa.selenium.By.cssSelector("[class*='mh-button']")).size());
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void openUrl(String url) {
        driver.get(url);
    }
}
