package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserPage;

public class pageObjectManager {
	
	WebDriver driver;
	private POM_LoginPage loginpage;
	private POM_UserPage userpage;
	
	public pageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public POM_LoginPage getPage_01() {
		if(loginpage==null)
		{
			loginpage = new POM_LoginPage(driver);
		}
		return loginpage;
		
	}
	public POM_UserPage getpage_02() {
		if(userpage==null)
		{
			userpage = new POM_UserPage(driver);
		}
		return userpage;
	}

}
