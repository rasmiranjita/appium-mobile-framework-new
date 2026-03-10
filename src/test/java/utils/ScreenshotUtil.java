package utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;

public class ScreenshotUtil {
	
	public static String captureScreenshot(AppiumDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String screenshotPath = System.getProperty("user.dir") +
                "/test-output/screenshots/" + testName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }

}
