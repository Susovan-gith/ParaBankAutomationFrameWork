package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseFile;
import pages.AccountViewPage;
import pages.LoginPage;
import utilities.DataProviders;

public class AccountViewTest extends BaseFile {

    @Test(priority=3,dataProvider = "loginData",
          dataProviderClass = DataProviders.class)

    public void verifyAccountOverview(
            String username,
            String password) {

        LoginPage login =
                new LoginPage(BaseFile.getDriver());

        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        AccountViewPage accountPage =
                new AccountViewPage(BaseFile.getDriver());

        Assert.assertTrue(
                accountPage.isviewDisplayed());     
    }
}