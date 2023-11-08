package com.DemoQA.testcases;


import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoQA.pageobjects.Elements_Links_Page_Objects;

public class TC_05_Elements_Links extends Base_Class{
	
	@Test(priority = 1)
	public void test_HomePG_Link() throws IOException {
		Elements_Links_Page_Objects links = new Elements_Links_Page_Objects(driver);
		
		//scrooll to the element
			//scroll to click
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//span[text()=\"Links\"]")); 
			js.executeScript("arguments[0].scrollIntoView(true);", element);
	
		
		driver.findElement(By.xpath("//span[text()=\"Links\"]")).click();
		logger.info("Clicked on links section");
		links.clickonHomeLink();
		logger.info("Clicked on HOMEPG LINK");
		
		
		 // Switch to the new tab or window
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        String newWindowHandle = "";
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(newWindowHandle);
        
        String expectedLink = "https://demoqa.com/";
        String currentlink = driver.getCurrentUrl();
        System.out.println(currentlink);
		
		if (currentlink.equals(expectedLink)) {
			Assert.assertTrue(true);
			logger.info("--------------------Test Passed-------------------");
		}
		else {
			cpatureSS(driver, "test_HomePG_Link");
			logger.info("-------------------Test FAILED----------------------");
			Assert.assertTrue(false);
		}
		///switch to main window
		driver.switchTo().window(mainWindowHandle);
	}
	
	
	
	@Test(priority = 2)
	public void test_HomePG_DynamicLink() throws IOException {
		Elements_Links_Page_Objects links = new Elements_Links_Page_Objects(driver);
		
		//scrooll to the element
			//scroll to click
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//span[text()=\"Links\"]")); 
			js.executeScript("arguments[0].scrollIntoView(true);", element);
	
		
		driver.findElement(By.xpath("//span[text()=\"Links\"]")).click();
		logger.info("Clicked on links section");
		
		
		//action class as its a dynamic link
		
		Actions act = new Actions(driver);
		act.click(links.clickonHomeLinkDynamic()).perform();
		
		logger.info("Clicked on Dynamic HOMEPG LINK");
		
		
		 // Switch to the new tab or window
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        String newWindowHandle = "";
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(newWindowHandle);
        
        String expectedLink = "https://demoqa.com/";
        String currentlink = driver.getCurrentUrl();
        System.out.println(currentlink);
		
		if (currentlink.equals(expectedLink)) {
			Assert.assertTrue(true);
			logger.info("--------------------Test Passed-------------------");
		}
		else {
			cpatureSS(driver, "test_HomePG_Link");
			logger.info("-------------------Test FAILED----------------------");
			Assert.assertTrue(false);
		}
		//switch to main window
		driver.switchTo().window(mainWindowHandle);
	}	
}
