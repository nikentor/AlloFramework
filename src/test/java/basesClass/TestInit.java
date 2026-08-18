package basesClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestInit {

    public WebDriver driver;
    public String alloUrl = "https://allo.ua/";


    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if ("true".equals(System.getenv("CI"))) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        openUrl(alloUrl);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void openUrl(String url) {
        driver.get(url);

        System.out.println("CI = " + System.getenv("CI"));
        System.out.println("URL = " + driver.getCurrentUrl());
        System.out.println("TITLE = " + driver.getTitle());
    }
}