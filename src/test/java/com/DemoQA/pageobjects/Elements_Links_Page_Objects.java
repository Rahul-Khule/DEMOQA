package com.DemoQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_Links_Page_Objects {

	WebDriver ldriver;
	public Elements_Links_Page_Objects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements( rdriver,this);
	}
	//find elements
	@FindBy(id = "simpleLink")
	WebElement homelink;
	
	@FindBy(xpath =  "//a[@id=\"dynamicLink\"]")
	WebElement homeDynamaicLink;
	
	@FindBy(xpath =  "//a[@id=\"created\"]")
	WebElement createdLink;
	
	//action
	public void clickonHomeLink() {
		homelink.click();
	}
	public WebElement clickonHomeLinkDynamic() {
		return homeDynamaicLink;
	}
	public void clickonCreatedLink() {
		createdLink.click();
	}
}
