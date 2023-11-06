package com.DemoQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_Text_Box_Page_Objects {
 
	WebDriver l_driver;
	public Elements_Text_Box_Page_Objects(WebDriver r_driver) {
		l_driver = r_driver;
		PageFactory.initElements(r_driver, this);
	}
	
	//find elements
	@FindBy(id = "userName")
	WebElement username;
	
	@FindBy(id = "userEmail")
	WebElement email;
	
	@FindBy(id = "currentAddress")
	WebElement currentAddress;
	
	@FindBy(id = "permanentAddress")
	WebElement permanentAddress;
	
	@FindBy(id = "submit")
	WebElement submit;
	
	//action methods 
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	public void setEmail(String email1) {
		email.sendKeys(email1);
	}
	public void setcurrentAddress(String cAdd) {
		currentAddress.sendKeys(cAdd);
	}
	public void setPermanentAddress(String pADD) {
		permanentAddress.sendKeys(pADD);
	}
	public void click_Submit() {
		submit.click();
	}
	
	
}
