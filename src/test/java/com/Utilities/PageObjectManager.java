package com.Utilities;

import org.openqa.selenium.WebDriver;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserPage;

public class PageObjectManager {
	
		WebDriver driver;
		private POM_LoginPage loginpage;
		private POM_UserPage userPage;
		
		public PageObjectManager(WebDriver driver)
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
		public POM_UserPage getuser() {
			if(userPage==null)
			{
				userPage = new POM_UserPage(driver);
			}
			return userPage;
		}

}
