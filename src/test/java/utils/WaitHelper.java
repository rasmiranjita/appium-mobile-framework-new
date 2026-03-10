package utils;

import io.appium.java_client.AppiumDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitHelper {

    private AppiumDriver driver;
    private int defaultTimeout = 20; // default timeout in seconds

    // Constructor
    public WaitHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    // Wait with custom timeout
    public WebElement waitForVisibility(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait with default timeout
    public WebElement waitForVisibility(By locator) {
        return waitForVisibility(locator, defaultTimeout);
    }



	
	

}
