package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;
import utils.WaitHelper;

public class LoginTest extends BaseTest {
    private ProductPage productPage;
    private LoginPage loginPage;

    @BeforeClass
    public void setupPages() {
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login();

        //Verify successful login (Products page visible)
        boolean isVisible = productPage.productPageLogoDisplayed();
        Assert.assertTrue(isVisible, "Products page is not visible after login!");
    }
    
    @Test
    public void testInValidLogin() {
        loginPage.InValidLogin();

        boolean isErrorMsgVisible = loginPage.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMsgVisible, "Error message not displayed for invalid login!");
        
        String actualError = loginPage.getErrorMessageText();
        String expectedError = ConfigReader.getProperty("locked.user.error");

        Assert.assertEquals(actualError, expectedError,
                "Error message text does not match expected text!");
    }
    
    
    
}





