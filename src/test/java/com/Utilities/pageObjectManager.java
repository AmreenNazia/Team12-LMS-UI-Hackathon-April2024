package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_BatchPage;
import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;

public class pageObjectManager {
	
	WebDriver driver;
 
	private POM_LoginPage loginpage;
	private POM_Dashboard dashboard;
	private POM_BatchPage batchPage;
 
	 
 
	
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
 
	
	public POM_Dashboard getdashboardPage() {
		if(dashboard==null)
		{
			dashboard = new POM_Dashboard(driver);
		}
		return dashboard;
		
	}
	
	public POM_BatchPage getBatchPage() {
		if(batchPage==null)
		{
			batchPage = new POM_BatchPage(driver);
		}
		return batchPage;
		
	}
	
 
public POM_UserPage getuser() {
			if(userpage==null)
			{
				userpage = new POM_UserPage(driver);
			}
			return userpage;
		}

 

}
