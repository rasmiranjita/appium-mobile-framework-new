package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductListPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest{

	private LoginPage loginPage;
	private ProductListPage productListPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;

	@BeforeClass
	public void setupPages() {
		loginPage = new LoginPage(driver);
		productListPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

	@Test
	public void testCheckoutFlow() throws InterruptedException {
		// Login
		loginPage.login();

		// Select product
		productListPage.clickOnProductList();

		// Verify product details page
		productListPage.verifyProductPriceAndNameAreDisplayed();

		// Add to cart
		productListPage.addToCart();

		// Navigate to cart (click cart button)
		cartPage.navigateToCart();

		//proceed to checkout
		checkoutPage.clickOnCheckOutButton();

		//Fill checkout details
		checkoutPage.fillCheckoutDetails(
		        ConfigReader.getProperty("firstname"),
		        ConfigReader.getProperty("lastname"),
		        ConfigReader.getProperty("zipcode")
		);

		//Complete the order
		checkoutPage.completeOrder();

		//Verify order confirmation
		checkoutPage.verifyOrderConfirmation();
	}

}
