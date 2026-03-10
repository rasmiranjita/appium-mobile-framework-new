package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumBy;



import java.time.Duration;

import javax.sound.midi.Sequence;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitHelper;
import org.testng.Assert;

public class CheckoutPage {
	private AppiumDriver driver;
    private WaitHelper waitHelper;
    
 // Locators for checkout details
    private By firstNameField = AppiumBy.accessibilityId("test-First Name");
    private By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    private By postalCodeField = AppiumBy.xpath("test-Zip/Postal Code");
    private By continueButton = AppiumBy.accessibilityId("test-CONTINUE");
    private By finishButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");
    private By orderConfirmationTitle = By.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]");
    private By successMessage = By.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]");
    private By checkoutButton = By.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]");

    
    public CheckoutPage(AppiumDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }
    
    public void clickOnCheckOutButton() {
        waitHelper.waitForVisibility(checkoutButton, 10).click();
    }
    
    public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        waitHelper.waitForVisibility(firstNameField, 10).sendKeys(firstName);
        waitHelper.waitForVisibility(lastNameField, 10).sendKeys(lastName);
        waitHelper.waitForVisibility(postalCodeField, 10).sendKeys(postalCode);
        waitHelper.waitForVisibility(continueButton, 10).click();
    }
    
    public void completeOrder() {    	
    	driver.findElement(AppiumBy.androidUIAutomator(
    	        "new UiScrollable(new UiSelector().scrollable(true))"
    	        + ".setMaxSearchSwipes(10)"
    	        + ".scrollIntoView(new UiSelector().description(\"test-FINISH\"));"
    	));

    	By finishLocator = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");
    	WebElement finishButton = waitHelper.waitForVisibility(finishLocator, 20);

    	finishButton.click();
    }
    
    public void verifyOrderConfirmation() {
        // Verify order confirmation screen
        WebElement title = waitHelper.waitForVisibility(orderConfirmationTitle, 10);
        Assert.assertTrue(title.isDisplayed(), "Order confirmation title not displayed!");

        // Verify success message
        WebElement message = waitHelper.waitForVisibility(successMessage, 10);
        Assert.assertTrue(message.isDisplayed(), "Success message not displayed!");
    }

}
