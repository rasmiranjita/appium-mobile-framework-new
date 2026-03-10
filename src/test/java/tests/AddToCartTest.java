package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;

public class AddToCartTest extends BaseTest {

	private LoginPage loginPage;
	private ProductListPage productListPage;
	private CartPage cartPage;
	private String selectedProductName;

	@BeforeClass
	public void setupPages() {
		loginPage = new LoginPage(driver);
		productListPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
	}

	@Test
	public void testAddProductToCart() {
		// Step 0: Login
		loginPage.login();

		// Select product
		productListPage.clickOnProductList();

		// Verify product details page
		productListPage.verifyProductPriceAndNameAreDisplayed();

		// Add to cart
		productListPage.addToCart();

		// Navigate to cart (click cart button)
		cartPage.navigateToCart();

		// Validate correct quantity in the cart
		String cartCount = cartPage.getCartBadgeCount();
		Assert.assertEquals(cartCount, "1", "Cart badge did not update correctly!");

		//Verify product in cart
		selectedProductName = productListPage.getProductName();
		cartPage.verifyProductInCart(selectedProductName, "1"); // assuming quantity is 1
	}

}
