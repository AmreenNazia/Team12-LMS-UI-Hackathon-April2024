package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_UserAssignStudent;
import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_LoginPage;

public class pageObjectManager {
	
	WebDriver driver;
	private POM_LoginPage loginpage;
	private POM_HomePage homepage;
	private POM_UserAssignStudent userAssignStudentPage;
	
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
	
	public POM_HomePage getHomePage() {
		if(homepage==null)
		{
			homepage = new POM_HomePage(driver);
		}
		return homepage;
		
	}

	public POM_UserAssignStudent getUserAssignStudentPage() {
		if(userAssignStudentPage==null)
		{
			userAssignStudentPage = new POM_UserAssignStudent(driver);
		}
		return userAssignStudentPage;
		
	}


}
