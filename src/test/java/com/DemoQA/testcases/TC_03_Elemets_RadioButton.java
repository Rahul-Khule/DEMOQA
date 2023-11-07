package com.DemoQA.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoQA.pageobjects.Elements_RadioButton_Page_Objects;

public class TC_03_Elemets_RadioButton extends Base_Class{
	@Test(priority = 1)
	public void test_elemets_YES_radio_button() throws IOException, InterruptedException {
	//create page objects
	Elements_RadioButton_Page_Objects radio = new Elements_RadioButton_Page_Objects(driver);
	radio.click_checkboxsection();
	logger.info("clicked on check box section");
	
	radio.click_yesRadioButton();
	logger.info("clicked on yes radio button");
	Thread.sleep(5000);
	if (driver.findElement(By.xpath("//span[text()=\"Yes\"]")).getText().contains("1")) {
		Assert.assertTrue(true);
		logger.info("---------------------successfully clicked on yes radio button-----------------");
	}
	else {
		cpatureSS(driver, "test_elemets_YES_radio_button");
		logger.info("------------------Failed to click on yes radio button--------------------");
		Assert.assertTrue(false);
	}
	
	}
	
	@Test(priority = 2)
	public void test_elemets_Impressive_radio_button() throws IOException, InterruptedException {
	//create page objects
	Elements_RadioButton_Page_Objects radio = new Elements_RadioButton_Page_Objects(driver);
	radio.click_checkboxsection();
	logger.info("clicked on check box section");
	
	radio.click_impressiveRadioButton();
	
	logger.info("clicked on Impressive radio button");
	Thread.sleep(5000);
	if (driver.findElement(By.xpath("//span[text()=\"Impressive\"]")).getText().contains("1")) {
		Assert.assertTrue(true);
		logger.info("---------------------successfully clicked on impressive radio button---------------------------");
	}
	else {
		cpatureSS(driver, "test_elemets_Impressive_radio_button");
		logger.info("-----------------------Failed to click on impressive radio button-----------------------");
		Assert.assertTrue(false);
	}
	
	}
}
