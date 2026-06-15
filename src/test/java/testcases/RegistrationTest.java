package testcases;

import org.testng.annotations.Test;

import base.BaseFile;
import pages.RegistrationPage;
import utilities.DataProviders;

public class RegistrationTest extends BaseFile {

    @Test(priority=1,dataProvider = "registrationData",
          dataProviderClass = DataProviders.class)

    public void verifyRegistration(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phone,
            String ssn,
            String username,
            String password) {

        RegistrationPage register =
                new RegistrationPage(BaseFile.getDriver());

        register.clickRegisterLink();

        register.registerUser(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phone,
                ssn,
                username,
                password);
    }
}