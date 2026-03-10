package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class ProductListPage {
	
	 private AppiumDriver driver;
	 private WaitHelper waitHelper;

	    // Locator for all products in the list
	    private By ProductListButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView");
	    private By ProductDetailsButton = By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]");
	    private By backToProductText = By.xpath("//android.widget.TextView[@text=\"BACK TO PRODUCTS\"]");
	    private By productPrice = By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");
	    private By productName = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
	    private By addToCartButton = By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]");

	    
	    public ProductListPage(AppiumDriver driver) {
	        this.driver = driver;
	        this.waitHelper = new WaitHelper(driver);
	    }

	    public void clickOnProductList()
	    {
	    	 // Wait for product list button to be visible and click
	        waitHelper.waitForVisibility(ProductListButton, 10).click();

	        // Wait for product details button to be visible and click
	        waitHelper.waitForVisibility(ProductDetailsButton, 10).click();
	    }
	    
	    public void verifyProductPriceAndNameAreDisplayed()
	    {
	    	 // Wait for product name and price to be visible
	        boolean isNameVisible = waitHelper.waitForVisibility(productName, 10).isDisplayed();
	        boolean isPriceVisible = waitHelper.waitForVisibility(productPrice, 10).isDisplayed();

	        // Assert that both are displayed
	        if (!isNameVisible || !isPriceVisible) {
	            throw new AssertionError("Product name or price is not displayed!");
	        }
	    }
	    
	    public void addToCart()
	    {
	    	waitHelper.waitForVisibility(addToCartButton, 10).click();
	    }
	    
	    
	    public boolean isPageLoaded() {
	        // Page is considered loaded if both name and price are visible
	        return waitHelper.waitForVisibility(backToProductText, 10).isDisplayed();
	    }
	    
	    // get product name
	    public String getProductName() {
	        return waitHelper.waitForVisibility(productName, 10)
	                         .findElement(productName)
	                         .getText();
	    }
	    
	    
}

