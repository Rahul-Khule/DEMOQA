package com.DemoQA.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoQA.pageobjects.Elements_Text_Box_Page_Objects;

public class TC_01_Elements_TextBOX extends Base_Class{
	
	@Test
	public void test_elements_text_box() throws IOException {
		//create page objects
		Elements_Text_Box_Page_Objects pgo = new Elements_Text_Box_Page_Objects(driver);
		pgo.setUserName(fullName);
		logger.info("Fullname entered");
		pgo.setEmail(generateRandomEmail());
		logger.info("generated random email");
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
		
		if (driver.findElement(By.xpath("//p[@id='name']")).getText().contains(fullName)) {
			Assert.assertTrue(true);
			logger.info("-------------test passed-----------------");
		}
		else {
			cpatureSS(driver, "test_elements_text_box");
			logger.info("----------------------test fail------------------");
			Assert.assertTrue(false);
			
		}
	
	}
}
