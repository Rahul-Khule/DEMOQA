package com.DemoQA.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoQA.pageobjects.Elements_Button_Page_Objects;

public class TC_04_Elements_Buttons extends Base_Class {
	
	@Test(priority = 1)
	public void test_Double_click() throws IOException {
		Elements_Button_Page_Objects btn = new Elements_Button_Page_Objects(driver);
		//action class to click on button section
		driver.navigate().to(Buttonurl);
		logger.info("clicked on button section");
		
		//scrooll to the element
		//scroll to click
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.id("doubleClickBtn")); 
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
		//action class to double click element
		Actions act = new Actions(driver);
		act.doubleClick(btn.double_click()).perform();
		logger.info("double clicked the button");
		
		
		String dbl_msg =driver.findElement(By.xpath("//p[contains(text(),\"double click\")]")).getText();
		if (dbl_msg.contains("You have done a double click")) {
			Assert.assertTrue(true);
			logger.info("------------------TEST PASSED----------------");
		}
		else {
			cpatureSS(driver, "test_Double_click");
			logger.info("-----------------TEST FAILED-------------------");
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 2)
	public void test_Right_click() throws IOException {
		Elements_Button_Page_Objects btn = new Elements_Button_Page_Objects(driver);
		driver.navigate().to(Buttonurl);
		logger.info("clicked on button section");
				
		//scroll to click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("rightClickBtn")); 
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
				//action class to double click element
				Actions act = new Actions(driver);
				act.contextClick(btn.right_click()).perform();
				
		btn.right_click();
		logger.info("Right clicked the button");
		
		String dbl_msg =driver.findElement(By.id("rightClickMessage")).getText();
		if (dbl_msg.contains("You have done a right click")) {
			Assert.assertTrue(true);
			logger.info("------------------TEST PASSED----------------");
		}
		else {
			cpatureSS(driver, "test_Right_click");
			logger.info("-----------------TEST FAILED-------------------");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void test_click_ME() throws IOException {
		Elements_Button_Page_Objects btn = new Elements_Button_Page_Objects(driver);
		//action class to click on button section
		driver.navigate().to(Buttonurl);
		
		logger.info("clicked on button section");
		
		btn.clickME();
		logger.info("clicked the button");
		
		String dbl_msg =driver.findElement(By.id("dynamicClickMessage")).getText();
		if (dbl_msg.contains("You have done a dynamic click")) {
			Assert.assertTrue(true);
			logger.info("------------------TEST PASSED----------------");
		}
		else {
			cpatureSS(driver, "test_click_ME");
			logger.info("-----------------TEST FAILED-------------------");
			Assert.assertTrue(false);
		}
	}
	
	
}
