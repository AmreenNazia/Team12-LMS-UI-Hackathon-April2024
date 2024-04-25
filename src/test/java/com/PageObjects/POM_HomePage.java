package com.PageObjects;

import org.openqa.selenium.WebDriver;

public class POM_HomePage {
	
	WebDriver driver;
	
	public POM_HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}

}
