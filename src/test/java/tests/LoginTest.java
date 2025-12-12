package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        extentTest.info("Starting Login Test");
        loginPage.navigateToLoginPage();
        extentTest.info("Entering Username and Password");
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        extentTest.info("Login Successful");
        homePage.clickTimeLink();
        extentTest.info("All actions performed successfully");
        // Test implementation will go here
    }
    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        extentTest.info("Starting Login Test");
        loginPage.navigateToLoginPage();
        extentTest.info("Entering Username and Password");
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        homePage.clickTimeLink();
        extentTest.info("All actions performed successfully");
        // Test implementation will go here
    }

    @Test
    public void test3() {
        extentTest.skip("Skipping this test case");
    }
}
