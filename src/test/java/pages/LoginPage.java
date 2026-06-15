package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private static final Logger logger =
	        LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By username = By.name("username");

    By password = By.name("password");

    By loginBtn = By.xpath("//input[@value='Log In']");

    By logoutLink = By.linkText("Log Out");

    public void enterUsername(String user) {
    	logger.info("Entering Username");
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
    	logger.info("Entering Passwprd");
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
    	logger.info("Click Login Button");
        driver.findElement(loginBtn).click();
    }
}