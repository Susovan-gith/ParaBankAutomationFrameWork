package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountViewPage {

    WebDriver driver;

    public AccountViewPage(WebDriver driver) {
        this.driver = driver;
    }

    By accountsOverviewHeading =
            By.xpath("//h1[contains(text(),'Accounts Overview')]");

    public boolean isviewDisplayed() {

        return driver.findElement(accountsOverviewHeading)
                .isDisplayed();
    }
}