package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseFile;
import pages.BillPage;
import pages.LoginPage;
import utilities.DataProviders;
import utilities.ExcelUtils;

public class BillTest extends BaseFile {

    @Test(priority = 6,
            dataProvider = "billPayData",
            dataProviderClass = DataProviders.class)
    public void verifyBillPayment(
            String payeeName,
            String address,
            String city,
            String state,
            String zipCode,
            String phone,
            String accountNo,
            String amount) throws Exception {

        System.out.println("===== DATA FROM EXCEL =====");
        System.out.println("Payee Name : " + payeeName);
        System.out.println("Address    : " + address);
        System.out.println("City       : " + city);
        System.out.println("State      : " + state);
        System.out.println("Zip        : " + zipCode);
        System.out.println("Phone      : " + phone);
        System.out.println("Account No : " + accountNo);
        System.out.println("Amount     : " + amount);
        System.out.println("===========================");

        LoginPage login = new LoginPage(BaseFile.getDriver());

        login.enterUsername(
                ExcelUtils.getCellData("Login", 1, 0));

        login.enterPassword(
                ExcelUtils.getCellData("Login", 1, 1));

        login.clickLogin();

        BillPage billPay =
                new BillPage(BaseFile.getDriver());

        billPay.openBillPayPage();

        billPay.enterPayeeInformation(
                payeeName,
                address,
                city,
                state,
                zipCode,
                phone,
                accountNo,
                accountNo,
                amount);

        billPay.clickSendPayment();

       Thread.sleep(5000);

        String pageText =
        		BaseFile.getDriver().findElement(By.tagName("body"))
                        .getText();

        System.out.println(pageText);

        Assert.assertTrue(
                pageText.contains("Bill Payment Complete"),
                "Bill payment failed");
    }
}