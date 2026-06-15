package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillPage {

	private static final Logger logger =
	        LogManager.getLogger(BillPage.class);
    WebDriver driver;

    public BillPage(WebDriver driver) {

        this.driver = driver;
    }
    By payeeName =
            By.name("payee.name");

    By address =
            By.name("payee.address.street");

    By city =
            By.name("payee.address.city");

    By state =
            By.name("payee.address.state");

    By zipCode =
            By.name("payee.address.zipCode");

    By phone =
            By.name("payee.phoneNumber");

    By account =
            By.name("payee.accountNumber");

    By verifyAccount =
            By.name("verifyAccount");

    By amount =
            By.name("amount");

    By fromAccount =
            By.name("fromAccountId");

    By sendPayment =
            By.cssSelector(
                    "input[value='Send Payment']");  
    public void enterPayeeInformation(
            String payee,
            String addr,
            String cityName,
            String stateName,
            String zipcode,
            String phoneNo,
            String accountNo,
            String verifyAccountNo,
            String amt) {
    	logger.info("Entering Payee Information");
        driver.findElement(payeeName)
                .sendKeys(payee);

        driver.findElement(address)
                .sendKeys(addr);

        driver.findElement(city)
                .sendKeys(cityName);

        driver.findElement(state)
                .sendKeys(stateName);

        driver.findElement(zipCode)
                .sendKeys(zipcode);

        driver.findElement(phone)
                .sendKeys(phoneNo);

        driver.findElement(account)
                .sendKeys(accountNo);

        driver.findElement(verifyAccount)
                .sendKeys(verifyAccountNo);

        driver.findElement(amount)
                .sendKeys(amt);

        Select dropdown =
                new Select(
                        driver.findElement(fromAccount));

        dropdown.selectByIndex(0);
    }
    public void openBillPayPage() {
    	logger.info("Opening Bill Pay Page");

        driver.findElement(
                By.linkText("Bill Pay"))
                .click();
    }
 
    public void clickSendPayment() {
    	logger.info("Sending Bill Payment");
        driver.findElement(sendPayment)
                .click();
    }
}