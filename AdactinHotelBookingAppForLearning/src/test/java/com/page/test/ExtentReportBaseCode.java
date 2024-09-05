package com.page.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.page.object.BaseClass;
import com.page.object.ScreenshotCode;


public class ExtentReportBaseCode extends BaseClass{
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest logger;
	ScreenshotCode ss;
	String path = "/test-output/STMExtentReport.html";
	ExtentTest suiteTest;

	@BeforeSuite
	public void startReport() throws Exception {
		// Create an object of Extent Reports
		extent = new ExtentReports();

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + path);
		extent.attachReporter(spark);

		extent.setSystemInfo("Host Name", "MIERUKA");
		extent.setSystemInfo("Environment", "Quality");
		extent.setSystemInfo("User Name", "Deepan Raj");
		spark.config().setDocumentTitle("MIERUKA Report");

		// Name of the report
		spark.config().setReportName("FUNCTIONAL TESTING");
		// Dark Theme
		spark.config().setTheme(Theme.DARK);
		spark.config().setCss(".accordion>.card>.card-header>.card-title>a{color:#2df482}");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");

			// To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below ");
			// logger.addScreenCaptureFromPath(path)

			String screenshotPath = ss.passScreenCapture(driver, result.getName());
			// To add it in the extent report
			// logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			// logger.fail("Test failed",
			// MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Administrator\\eclipse-workspace\\L2MIERUKAV1\\recordings\\Event
			// Report.avi").build());

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

//	@AfterClass
//	public void last() throws Exception {
//		MyScreenRecorder.stopRecording();
//	}

	@AfterSuite
	public void endReport() throws Exception {
		extent.flush();
//		MyScreenRecorder.stopRecording();

		// Desktop.getDesktop().browse(new File(path).toURI());
	}
}
