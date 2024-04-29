package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserEditPage;
import com.PageObjects.POM_UserPage;

public class PageObjectManager {
	
	WebDriver driver;
	 
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public POM_LoginPage getLoginPage() {
		POM_LoginPage loginpage = null;
		if(loginpage==null) {
			loginpage = new POM_LoginPage(driver);
		}
		return loginpage;	
	}
	
	public POM_UserPage getUserPage() {
		POM_UserPage userPage = null;
		if(userPage==null) {
			userPage = new POM_UserPage(driver);
		}
		return userPage;	
	}
	
	public POM_UserEditPage getUserEditPage() {
		POM_UserEditPage userEditPage = null;
		if(userEditPage==null) {
			userEditPage = new POM_UserEditPage(driver);
		}
		return userEditPage;	
	}

}
