package com.DemoQA.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoQA.pageobjects.Elements_Text_Box_Page_Objects;

public class TC_02_Elements_TextBOX_InvalidEmail_Field extends Base_Class{
	@Test
	public void test_Elements_TextBOX_InvalidEmail_Field() throws IOException {
		Elements_Text_Box_Page_Objects pgo = new Elements_Text_Box_Page_Objects(driver);
		pgo.setUserName(fullName);
		logger.info("Fullname entered");
		pgo.setEmail("people");
		logger.info("generated invalid email");
		pgo.setcurrentAddress(currAdd);
		logger.info("Current address entered");
		pgo.setPermanentAddress(perADD);
		logger.info("permanent address entered");
		//scroll to click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("submit")); 
		js.executeScript("arguments[0].scrollIntoView(true);", element);	
		pgo.click_Submit();
		logger.info("Clicked on submit");
		
			WebElement ele = driver.findElement(By.id("userEmail"));
			
			if (ele.getAttribute("class").contains("field-error")) {
				
				Assert.assertTrue(true);
				logger.info("-------------test passed-----------------");
			}
			else {
				cpatureSS(driver, "TC_02_Elements_TextBOX_InvalidEmail_Field");
				logger.info("----------------------test fail------------------");
				Assert.assertTrue(false);
				
				
				
			}
		 
		}
		
		
		
		
	}

