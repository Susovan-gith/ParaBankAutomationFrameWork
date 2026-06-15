package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage {

    WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger =
            LogManager.getLogger(TransferFundsPage.class);
    public TransferFundsPage(WebDriver driver) {
    	
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By transferFundsLink = By.linkText("Transfer Funds");

    By amount = By.id("amount");

    By fromAccount = By.id("fromAccountId");

    By toAccount = By.id("toAccountId");

    By transferButton =
            By.xpath("//input[@value='Transfer']");

    By successMessage =
            By.xpath("//h1[contains(text(),'Transfer Complete')]");

    
    public void enterAmount(String amt) {
    	logger.info("Entering Transfer Amount : " + amt);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                amount));

        driver.findElement(amount).clear();

        driver.findElement(amount).sendKeys(amt);
    }
    public void openTransferFunds() {
    	logger.info("Opening Transfer Funds Page");

        utilities.WaitUtils.waitForElement(
                driver,
                By.linkText("Transfer Funds"));

        driver.findElement(
                By.linkText("Transfer Funds"))
                .click();
    }

    public void selectAccounts() {

        Select from =
                new Select(driver.findElement(fromAccount));

        Select to =
                new Select(driver.findElement(toAccount));

        String fromAcc =
                from.getFirstSelectedOption().getText();

        for (WebElement option : to.getOptions()) {

            String toAcc = option.getText();

            if (!toAcc.equals(fromAcc)) {

                to.selectByVisibleText(toAcc);

                break;
            }
        }
    }
    public void selectFromAccount() {

        Select from =
                new Select(driver.findElement(fromAccount));

        from.selectByIndex(0);
    }

    public void selectToAccount() {

        Select to =
                new Select(driver.findElement(toAccount));

        to.selectByIndex(0);
    }

    public void clickTransfer() {
    	logger.info("Clicking Transfer Button");

        WebElement button =
                driver.findElement(transferButton);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                button);
    }

    public String getSuccessMessage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                successMessage));

        return driver.findElement(successMessage)
                     .getText();
    }

    public String getPageText() {

        return driver.findElement(By.tagName("body"))
                     .getText();
    }
}