package com.Utilities;

import org.openqa.selenium.WebDriver;



import com.PageObjects.POM_HomePageNew;

import com.PageObjects.POM_ProgramPage;

import com.PageObjects.POM_BatchPage;
import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserEditPage;
import com.PageObjects.POM_UserPage;



public class pageObjectManager {

	WebDriver driver;


	private POM_HomePageNew homepage;

	private POM_ProgramPage programpage;


  private POM_LoginPage loginpage;
	private POM_Dashboard dashboard;
	private POM_BatchPage batchPage;
  private  POM_UserPage userpage;
	private POM_UserEditPage userEditPage;





	public pageObjectManager(WebDriver driver)
	{

		this.driver = driver;
	}


	public POM_LoginPage getLoginPage() {
		if (loginpage == null) {

			loginpage = new POM_LoginPage(driver);
		}
		return loginpage;

	}


	public POM_UserPage getuser() {
		if (userpage == null) {
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

	public POM_UserAssignStudent getUserAssignStudentPage() {
		if(userAssignStudentPage==null)
		{
			userAssignStudentPage = new POM_UserAssignStudent(driver);
		}
		return userAssignStudentPage;

	}


	public POM_UserEditPage getUserEditPage() {
		if (userEditPage == null) {
			userEditPage = new POM_UserEditPage(driver);
		}
		return userEditPage;
	}




	public POM_HomePageNew getHomePage() {
		if(homepage==null)
		{
			homepage = new POM_HomePageNew(driver);

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
