package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseClass;

import utilities.ExtentReporters;

public class Listeners extends BaseClass implements ITestListener {

	 WebDriver driver = null;
	
	 ExtentReports extentReport = ExtentReporters.getExtentReport();
	 
	 ExtentTest extendTest;
	 
	 ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	

	public void onFinish(ITestContext context) {
		
		
		extentReport.flush();
		
	}

	public void onStart(ITestContext result) {
		
		String testName = result.getName();
		
        extendTest = extentReport.createTest(testName);
        extentTestThread.set(extendTest);
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
	
	
		String testMethodName = result.getName();
		
//		extendTest.fail(result.getThrowable());
		
		extentTestThread.get().fail(result.getThrowable());
		
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			 
			String screenshotFilePath = takeScreenshot(testMethodName,driver);
			
		 extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	
	
	public void onTestSkipped(ITestResult result) {
		
	}
  
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
		// extendTest.log(Status.PASS,testName+"Test Passed");
		
		extentTestThread.get().log(Status.PASS,testName+"Test Passed");
			
	}

	

	
	
	
	
	
}
