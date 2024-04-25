package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;

public class POM_LoginPage {
	
	WebDriver driver;
	
	public POM_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement txt_user;
	@FindBy(xpath ="//input[@id='password']")
	WebElement txt_password;
	@FindBy(xpath ="//button[@id='login']")
	WebElement btn_login;
	

	public String getLoginPage() {
		return driver.getTitle();
	}

	 public void enterValidCredentials(String validUserName,String validPwd) {
		 ElementsUtil.typeInputIntoElement(driver, txt_user,validUserName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, txt_password,validPwd, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 
	 }
	public void login() {
		
		ElementsUtil.ScrolltoElementandClick(driver, btn_login, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	public String getHomePageTitle() {
		return driver.getTitle();// DashBoard Page
	}
	
	
}
