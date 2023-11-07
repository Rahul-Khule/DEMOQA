package com.DemoQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_Button_Page_Objects {
	
	WebDriver ldriver;
	public Elements_Button_Page_Objects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	//find elements
	@FindBy(xpath = "//span[text()=\"Buttons\"]")
	WebElement buttonsection;
	
	@FindBy(id = "doubleClickBtn")
	WebElement doubleClick;
	
	@FindBy(id = "rightClickBtn")
	WebElement rightClickBtn;
	
	@FindBy(xpath = "//button[text()=\"Click Me\"]")
	WebElement clickME;
	
	//actions
	public void clickME() {
		clickME.click();
	}
	
	public WebElement double_click() {
		return doubleClick;
	}
	
	public WebElement right_click() {
		return rightClickBtn;
	}
	
	public WebElement button_Section() {
		return buttonsection;
	}
	
	
}
