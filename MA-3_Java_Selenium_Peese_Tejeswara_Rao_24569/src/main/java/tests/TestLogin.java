package tests;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;  // ✅ Added JUnit for assertions
import pages.LoginPage;
import pages.HomePage;  // ✅ Need HomePage to verify login success
import utilities.BaseClass;

public class TestLogin {
    public static void main(String[] args) {
        // Initialize WebDriver
        BaseClass.initialize();  
        WebDriver driver = BaseClass.getDriver();  

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("lovelyteja86884@gmail.com");
        loginPage.enterPassword("TejaRao@9876");
        loginPage.clickLogin();

        // ✅ Verifying successful login
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue("Login failed!", homePage.isUserLoggedIn()); 

        // ✅ Close browser after test
        BaseClass.tearDown();  
    }
}
