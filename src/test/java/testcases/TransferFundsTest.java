package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseFile;
import pages.LoginPage;
import pages.TransferFundsPage;
import utilities.DataProviders;

public class TransferFundsTest extends BaseFile {

    @Test(
            priority = 5,
            dataProvider = "transferData",
            dataProviderClass = DataProviders.class
    )
    public void verifyTransferFunds(
            String username,
            String password,
            String amount) throws InterruptedException {

        LoginPage login =
                new LoginPage(BaseFile.getDriver());

        login.enterUsername(username);

        login.enterPassword(password);

        login.clickLogin();
    }
}