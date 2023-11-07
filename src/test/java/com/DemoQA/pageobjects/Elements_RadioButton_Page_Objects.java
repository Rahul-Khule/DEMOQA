package com.DemoQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_RadioButton_Page_Objects {
  WebDriver l_driver;
  public Elements_RadioButton_Page_Objects(WebDriver r_driver) {
	  l_driver = r_driver;
	  PageFactory.initElements(r_driver, this);
  }
  
  @FindBy(xpath = "//input[@id=\"yesRadio\"]/..//label[text()=\"Yes\"]")
  WebElement yesRadiobox;
  
  @FindBy(xpath = "//input[@id=\"impressiveRadio\"]/..//label[text()=\"Impressive\"]")
  WebElement impressiveRadiobox;
  
  @FindBy(xpath  = "//span[text()=\"Radio Button\"]")
  WebElement checkboxsection;
  
  
  
  //action
  public void click_yesRadioButton() {
	  yesRadiobox.click();
  }
  public void click_impressiveRadioButton() {
	  impressiveRadiobox.click();
  }
  public void click_checkboxsection() {
	  checkboxsection.click();
  }
  
  
}
