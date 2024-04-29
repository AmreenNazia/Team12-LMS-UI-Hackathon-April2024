package com.PageObjects;

import org.openqa.selenium.WebDriver;

public class POM_HomePage {

	WebDriver driver;

	public POM_HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
