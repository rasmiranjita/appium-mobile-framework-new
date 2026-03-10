package base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import swaglabs.swaglabs.DriverFactory;


public class BaseTest {
	protected AppiumDriver driver;
	
	    @BeforeClass
	    public void setUp() {
	        System.out.println("Setup started");

	        try {
	        	driver= DriverFactory.getDriver();
	            System.out.println("Driver initialized successfully");
	        } catch (Throwable t) {
	            System.out.println("Driver initialization failed");
	            t.printStackTrace();
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }


}
