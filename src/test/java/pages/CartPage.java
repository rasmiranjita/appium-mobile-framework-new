package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;
import org.testng.Assert;

public class CartPage {

	private AppiumDriver driver;
	private WaitHelper waitHelper;

	// Locator for product in cart by name
	private By cartProductName = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
	private By cartProductQuantity = By.xpath("(//android.widget.TextView[@text=\"1\"])[2]");
	private By cartBadgeCount = By.xpath("(//android.widget.TextView[@text=\"1\"])[1]");
	private By cartBadge = By.xpath(
			"//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

	public CartPage(AppiumDriver driver) {
		this.driver = driver;
		this.waitHelper = new WaitHelper(driver);
	}

	public void navigateToCart() {
		waitHelper.waitForVisibility(cartBadge, 10).click();
		
	}

	public String getCartProductName() {
		return waitHelper.waitForVisibility(cartProductName, 10).getText();
	}

	public String getCartProductQuantity() {
		return waitHelper.waitForVisibility(cartProductQuantity, 10).getText();
	}

	public void verifyProductInCart(String expectedName, String expectedQuantity) {
		String actualName = getCartProductName();
		String actualQuantity = getCartProductQuantity();

		Assert.assertEquals(actualName, expectedName, "Product name in cart is incorrect!");
		Assert.assertEquals(actualQuantity, expectedQuantity, "Product quantity in cart is incorrect!");
	}

	public String getCartBadgeCount() {
		try {
			WebElement badge = waitHelper.waitForVisibility(cartBadgeCount, 5);
			return badge.getText();
		} catch (Exception e) {
			return "0"; // no items in cart
		}
	}

}
