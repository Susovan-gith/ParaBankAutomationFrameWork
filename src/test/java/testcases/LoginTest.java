package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseFile;
import pages.LoginPage;
import utilities.DataProviders;

public class LoginTest extends BaseFile {

    @Test(priority=2,
        dataProvider = "loginData",
        dataProviderClass = DataProviders.class
    )
    public void verifyLogin(String username,
                            String password) {

        LoginPage login =
                new LoginPage(BaseFile.getDriver());

        login.enterUsername(username);

        login.enterPassword(password);

        login.clickLogin();
    }
}