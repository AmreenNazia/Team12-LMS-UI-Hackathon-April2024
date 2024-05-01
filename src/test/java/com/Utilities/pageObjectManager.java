package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_HomePageNew;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_ProgramPage;

public class pageObjectManager {
	
	WebDriver driver;
	private POM_HomePageNew homepage;
	private POM_LoginPage loginpage;
	private POM_ProgramPage programpage;
	private POM_Dashboard dashboard;
	
	public pageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public POM_HomePageNew getHomePage() {
		if(homepage==null)
		{
			homepage = new POM_HomePageNew(driver);
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
	
	public POM_Dashboard getDashboardPage() {
		if(dashboard==null)
		{
		dashboard = new POM_Dashboard(driver);
		}
		return dashboard;

		}

	public POM_ProgramPage getProgramPage() {
		if(programpage==null)
		{
			programpage = new POM_ProgramPage(driver);
		}
		return programpage;
		
	}

}
