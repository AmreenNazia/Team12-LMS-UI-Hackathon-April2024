package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;

public class POM_LoginPage {

	WebDriver driver;

	public POM_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login")
	WebElement login;

	public String getLoginPage() {
		String Title = driver.getTitle();
		return Title;
	}

	public void entervalidCredentials(String validUserName, String ValidPassword) {
		ElementsUtil.typeInputIntoElement(driver, username, validUserName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, password, ValidPassword, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public void login() {
		ElementsUtil.ScrolltoElementandClick(driver, login, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getDashBoardTitle() {
		String DashboardTitle = driver.getTitle();
		return DashboardTitle;
	}
	
}
