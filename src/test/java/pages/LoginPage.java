package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import swaglabs.swaglabs.DriverFactory;
import utils.WaitHelper;

public class LoginPage {

	private AppiumDriver driver;
	private WaitHelper waitHelper;

	private By standardUser = By.xpath("//android.widget.TextView[@text=\"standard_user\"]");
	private By lockedOutUser = By.xpath("//android.widget.TextView[@text=\"locked_out_user\"]");
	private By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
	private By errorMessage = By.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]");

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
		this.waitHelper = new WaitHelper(driver);
	}

	public void login() {
		waitHelper.waitForVisibility(standardUser, 10).click();
		waitHelper.waitForVisibility(loginButton, 10).click();
	}

	public void InValidLogin() {
		waitHelper.waitForVisibility(lockedOutUser, 10).click();
		waitHelper.waitForVisibility(loginButton, 10).click();
	}

	public boolean isErrorMessageDisplayed() {
		try {
			WebElement error = waitHelper.waitForVisibility(errorMessage, 5);
			return error.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getErrorMessageText() {
		try {
			return waitHelper.waitForVisibility(errorMessage, 5).getText();
		} catch (Exception e) {
			return null;
		}
	}

}
