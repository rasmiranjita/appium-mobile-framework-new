package swaglabs.swaglabs;

import java.net.URI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

	public class DriverFactory {
	    private static AppiumDriver driver;

	    public static AppiumDriver getDriver() {
	        if (driver == null) {
	            try {
	            	  UiAutomator2Options options = new UiAutomator2Options();

	                  options.setPlatformName("Android");
	                  options.setDeviceName("emulator-5554");
	                  options.setAutomationName("UiAutomator2");
	                  options.setAppPackage("com.swaglabsmobileapp");
	                  options.setAppActivity("com.swaglabsmobileapp.SplashActivity");
	                  options.setApp("C:\\Users\\rasmi\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

	                  driver = new AndroidDriver(
	                	        URI.create("http://127.0.0.1:4723").toURL(),
	                	        options);
	                  
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }


}
