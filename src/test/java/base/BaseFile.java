package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class BaseFile {

    private static final Logger logger =
            LogManager.getLogger(BaseFile.class);

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("") String browser) {

        if (browser == null || browser.trim().isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }

        logger.info("Launching Browser: {}", browser);

        switch (browser.toLowerCase()) {

        case "chrome":
            driver = new ChromeDriver();
            break;

        case "edge":
            driver = new EdgeDriver();
            break;

        case "firefox":
            driver = new FirefoxDriver();
            break;

        default:
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("implicitWait"))));

        String url = ConfigReader.getProperty("url");

        logger.info("Opening URL: {}", url);

        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {

            logger.info("Closing Browser");

            driver.quit();
            driver = null;
        }
    }
}