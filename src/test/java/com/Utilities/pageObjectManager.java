package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_LoginPage;

public class pageObjectManager {
	
	WebDriver driver;
	 
	
	public pageObjectManager(WebDriver driver)
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
public POM_UserPage getuser() {
			if(userpage==null)
			{
				userpage = new POM_UserPage(driver);
			}
			return userpage;
		}



}
