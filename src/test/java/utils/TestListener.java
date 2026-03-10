package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import swaglabs.swaglabs.DriverFactory;


public class TestListener implements ITestListener{

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        String screenshot = ScreenshotUtil.captureScreenshot(
        		DriverFactory.getDriver(),
                result.getMethod().getMethodName()
                );

        test.addScreenCaptureFromPath(screenshot);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String screenshot = ScreenshotUtil.captureScreenshot(
        		DriverFactory.getDriver(),
                result.getMethod().getMethodName()
        );

        test.addScreenCaptureFromPath(screenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }

}
