package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import swaglabs.swaglabs.DriverFactory;
import utils.WaitHelper;

public class ProductPage {
	
	private AppiumDriver driver;
	private WaitHelper waitHelper;
	
   

    private By productPageLogo = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]");
   
    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    public boolean productPageLogoDisplayed() {
        WebElement logo = waitHelper.waitForVisibility(productPageLogo, 20);
        return logo.isDisplayed();
    }
}
