package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	private static final Logger logger =
	        LogManager.getLogger(RegistrationPage.class);
	WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By registerLink=By.linkText("Register");
	By firstName=By.id("customer.firstName");
	By lastName=By.id("customer.lastName");
	By address=By.id("customer.address.street");
	By city=By.id("customer.address.city");
	By state=By.id("customer.address.state");
	By zipCode=By.id("customer.address.zipCode");
	By phoneNumber =By.id("customer.phoneNumber");
	By ssn=By.id("customer.ssn");
	By username=By.name("customer.username");
	By password=By.name("customer.password");
	By confirmPassword=By.id("repeatedPassword");
    By registerBtn = By.xpath("//input[@value='Register']");
    public void clickRegisterLink() {
    	logger.info("Clicking Register Button");
        driver.findElement(registerLink).click();
    }
    public void registerUser(String fName, String lName,
            String addr, String cityName,
            String stateName, String zip,
            String phoneNum, String ssnNum,
            String user, String pass) {
    	logger.info("Entering Registration Details");
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(address).sendKeys(addr);
		driver.findElement(city).sendKeys(cityName);
		driver.findElement(state).sendKeys(stateName);
		driver.findElement(zipCode).sendKeys(zip);
		driver.findElement(phoneNumber).sendKeys(phoneNum);
		driver.findElement(ssn).sendKeys(ssnNum);
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirmPassword).sendKeys(pass);
		
		driver.findElement(registerBtn).click();
    }
}
