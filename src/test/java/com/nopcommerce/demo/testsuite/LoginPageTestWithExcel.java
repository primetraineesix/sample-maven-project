package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.excelutility.ExcelUtility;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
public class LoginPageTestWithExcel extends TestBase {

    public static final String File_Path = System.getProperty("user.dir") +"/src/test/java/resources/testdata/ExcelData.xlsx";


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setExcel(){
        // Tell the code about the location of Excel file
        try {
            ExcelUtility.setExcelFile(File_Path, "LoginTests");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = ExcelUtility.getTestData("Invalid_Login");
        return data;
    }

    @Test(dataProvider = "credentials")
    public void doLogin(String username, String password) {
        homePage.clickOnLoginLink();
        loginPage.loginToApplication(username, password);
    }

}
