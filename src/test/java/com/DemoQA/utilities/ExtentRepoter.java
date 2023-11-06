package com.DemoQA.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRepoter {
	public static ExtentReports generate_Extent_reports() {
		//6.create an object for extent reports
		ExtentReports extentreport =  new ExtentReports();
		
		//generate new report every time test runs
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timestamp+".html";
		File extentreportsfile = new File(System.getProperty("user.dir")+"\\ExtentReports\\"+repName);
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(extentreportsfile);
		
		//6.configure sparkreporter
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("DEMOQA login results");
		sparkreport.config().setDocumentTitle("DEMOQA automation report");
		sparkreport.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		//6.attach report
		extentreport.attachReporter(sparkreport);
		
		// 6.read values from properties file
		Properties conpro = new Properties();
		File f = new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(f);
		conpro.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		//6.addition info 
		extentreport.setSystemInfo("Application URL",conpro.getProperty("baseurl"));
		extentreport.setSystemInfo("Environment", "Windows");
		return extentreport;
	}
}
