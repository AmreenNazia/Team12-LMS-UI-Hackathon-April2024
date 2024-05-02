package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_ProgramPage;


public class pageObjectManager {
	
	WebDriver driver;
	private POM_LoginPage loginpage;
	private POM_ProgramPage programpage;
	private POM_Dashboard dashboard;
	
	public pageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public POM_LoginPage getlogin() {
		if(loginpage==null)
		{
			loginpage = new POM_LoginPage(driver);
		}
		return loginpage;
		
	}
	public POM_ProgramPage getprogram() {
		if(programpage==null)
		{
			programpage = new POM_ProgramPage(driver);
		}
		return programpage;
	}
	public POM_Dashboard getdashboardPage() {
		if(dashboard==null)
		{
			dashboard = new POM_Dashboard(driver);
		}
		return dashboard;
		
	}
}