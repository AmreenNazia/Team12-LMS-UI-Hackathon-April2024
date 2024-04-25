package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_LoginPage;

public class pageObjectManager {
	
	WebDriver driver;
	private POM_HomePage homepage;
	private POM_LoginPage loginpage;
	
	public pageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public POM_HomePage getHomePage() {
		if(homepage==null)
		{
			homepage = new POM_HomePage(driver);
		}
		return homepage;
		
	}
	public POM_LoginPage getLoginPage() {
		if(loginpage==null)
		{
			loginpage = new POM_LoginPage(driver);
		}
		return loginpage;
		
	}

}
