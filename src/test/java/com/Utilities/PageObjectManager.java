package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserPage;

public class PageObjectManager {
	
	WebDriver driver;
	private POM_HomePage homepage;
	private POM_LoginPage loginpage;
	private POM_UserPage userpage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public POM_LoginPage getLoginPage() {
		if(loginpage==null)
		{
			loginpage = new POM_LoginPage(driver);
		}
		return loginpage;
		
	}
	
	public POM_UserPage getUserPage() {
		if(userpage==null)
		{
			userpage = new POM_UserPage(driver);
		}
		return userpage;
	}
	
	public POM_HomePage getHomePage() {
		if(homepage==null)
		{
			homepage = new POM_HomePage(driver);
		}
		return homepage;
	}

}
