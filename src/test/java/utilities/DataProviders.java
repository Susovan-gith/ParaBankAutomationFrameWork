package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {

        return new Object[][] {

            {
                ExcelUtils.getCellData("Registration",1,0),
                ExcelUtils.getCellData("Registration",1,1),
                ExcelUtils.getCellData("Registration",1,2),
                ExcelUtils.getCellData("Registration",1,3),
                ExcelUtils.getCellData("Registration",1,4),
                ExcelUtils.getCellData("Registration",1,5),
                ExcelUtils.getCellData("Registration",1,6),
                ExcelUtils.getCellData("Registration",1,7),
                ExcelUtils.getCellData("Registration",1,8),
                ExcelUtils.getCellData("Registration",1,9)
            }
        };
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {

            {
                ExcelUtils.getCellData("Login",1,0),
                ExcelUtils.getCellData("Login",1,1)
            }
        };
    }

    @DataProvider(name = "transferData")
    public Object[][] getTransferData() {

        return new Object[][] {

            {
                ExcelUtils.getCellData("Transfer",1,0),
                ExcelUtils.getCellData("Transfer",1,1),
                ExcelUtils.getCellData("Transfer",1,2)
            }
        };
    }

    @DataProvider(name = "billPayData")
    public Object[][] getBillPayData() {

        return new Object[][] {

            {
                ExcelUtils.getCellData("BillPay",1,0),
                ExcelUtils.getCellData("BillPay",1,1),
                ExcelUtils.getCellData("BillPay",1,2),
                ExcelUtils.getCellData("BillPay",1,3),
                ExcelUtils.getCellData("BillPay",1,4),
                ExcelUtils.getCellData("BillPay",1,5),
                ExcelUtils.getCellData("BillPay",1,6),
                ExcelUtils.getCellData("BillPay",1,7)
            }
        };
    }
}