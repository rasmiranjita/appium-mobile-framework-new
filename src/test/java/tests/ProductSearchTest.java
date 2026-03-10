package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ProductListPage;
import pages.LoginPage;

public class ProductSearchTest extends BaseTest {

	private LoginPage loginPage;
	private ProductListPage productListPage;

	@BeforeClass
	public void setupPages() {
		loginPage = new LoginPage(driver);
		productListPage = new ProductListPage(driver);

	}
	
	 @Test
	    public void testProductSearchAndDetails() {
	        //Login first
	        loginPage.login();

	        //click on product to navigate inside product
	        productListPage.clickOnProductList();
	        
	        //verify product price and name are displayed
	        productListPage.verifyProductPriceAndNameAreDisplayed();

	        //Verify product list page
	        Assert.assertTrue(productListPage.isPageLoaded(), "Product details page did not load correctly.");

	        
	    }

}
