package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserEditPage;
import com.PageObjects.POM_UserPage;

public class pageObjectManager {

	WebDriver driver;
	POM_LoginPage loginpage;
	POM_UserPage userpage;
	POM_UserEditPage userEditPage;
	public pageObjectManager(WebDriver driver) {
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

	public POM_UserEditPage getUserEditPage() {
		if(userEditPage == null) {
			userEditPage = new POM_UserEditPage(driver);
		}
		return userEditPage;
	}

}
