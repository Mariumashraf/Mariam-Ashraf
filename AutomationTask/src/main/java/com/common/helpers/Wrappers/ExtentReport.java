package com.common.helpers.Wrappers;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalTime;

public class ExtentReport {
    public static ExtentReports extent; // create reports
    public static ExtentTest logger; // create test cases


    public void startReport(String filePath, String testName) {
        // true means delete the old report
        extent = new ExtentReports(filePath, true);
        extent.addSystemInfo("OS", "Windows");
        extent.addSystemInfo("Owner", "MariUm Ashraf");
        extent.addSystemInfo("Test Name", testName);
    }

    public void setup(Method method) {
        logger = extent.startTest(method.getName());
    }


    public void logResult(Method method, ITestResult result, boolean takeScreenShot) throws IOException {
        if (takeScreenShot) {
            LocalTime now = LocalTime.now();
            String screenShotName = method.getName()+ now.getSecond();
            TakeScreenShot.takeSnapShot(screenShotName);
            if (result.getStatus() == ITestResult.SUCCESS) {
                logger.log(LogStatus.PASS, "Test Passed");
                logger.log(LogStatus.PASS, "<a href='" + screenShotName + ".png"
                        + "'download><span class='lable info'>SnapShot</span></a>");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                logger.log(LogStatus.FAIL, "Test Failed" + " The testcase is failed because of " + result.getThrowable());
                logger.log(LogStatus.FAIL, "<a href='" + screenShotName+ ".png"
                        + "'download><span class='lable info'>SnapShot</span></a>");
            } else {
                logger.log(LogStatus.SKIP, "Test Skipped" + " Test Skipped because of " + result.getThrowable());
                logger.log(LogStatus.SKIP, "<a href='" + screenShotName + ".png"
                        + "'download><span class='lable info'>SnapShot</span></a>");
            }
        } else {
            if (result.getStatus() == ITestResult.SUCCESS) {
                logger.log(LogStatus.PASS, "Test Passed");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                logger.log(LogStatus.FAIL, "Test Failed" + " The testcase is failed because of " + result.getThrowable());
            } else {
                logger.log(LogStatus.SKIP, "Test Skipped" + " Test Skipped because of " + result.getThrowable());
            }

        }
        extent.endTest(logger);
    }


    public void endReport() {
        extent.flush();
    }
}
