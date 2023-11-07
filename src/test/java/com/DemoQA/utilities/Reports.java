package com.DemoQA.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Reports implements ITestListener{
		WebDriver driver;
		ExtentReports extentreport;
		ExtentTest extenttest;
		
		@Override
		public void onStart(ITestContext context) {
			//6.create reports class object
			extentreport= ExtentRepoter.generate_Extent_reports();
		}
		@Override
		public void onTestStart(ITestResult result) {
			//gets name of the test
			result.getName();
			extenttest = extentreport.createTest(result.getName());
			extenttest.log(Status.INFO, result.getName()+" Started executing");
		}
		@Override
		public void onTestSuccess(ITestResult result) {
			result.getName();
			extenttest.log(Status.PASS, result.getName()+" Got Passed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			String methodName = result.getMethod().getMethodName();
			
			extenttest.log(Status.FAIL, result.getName()+"got failed");
			//6 add ss in report
			String sspath = System.getProperty("user.dir")+"\\Screenshots\\"+methodName+".png";
			File f = new File(sspath);
			if (f.exists()) {
		        extenttest.log(Status.INFO, "Screenshot exists at: " + sspath);

		        // Add the screenshot to the report
		        extenttest.addScreenCaptureFromPath(sspath);
		    } else {
		        // Log an error message if the screenshot doesn't exist
		        extenttest.log(Status.INFO, "Screenshot not found at: " + sspath);
		    }
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			result.getName();
			extenttest.log(Status.INFO, result.getThrowable());
			extenttest.log(Status.SKIP, result.getName()+"got skipped");
		}


		@Override
		public void onFinish(ITestContext context) {
			extentreport.flush();
		}
}
