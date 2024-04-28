package com.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(id = "errormessage")
	WebElement errorMesgText;
	@FindBy(id = "mat-error-0")
	WebElement userErrorMesg;
	@FindBy(id = "mat-error-1")
	WebElement pswdErrorMesg;

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
 

	public void enterInvalidCredentials(String invalidUserName, String inValidPassword) {
		ElementsUtil.typeInputIntoElement(driver, username, invalidUserName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, password, inValidPassword, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getErrorMessage() {
		String errorMessage = ElementsUtil
				.waitForElementVisibility(driver, errorMesgText, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
		return errorMessage;
	}

	public void enterPassword(String ValidPassword) {
		ElementsUtil.typeInputIntoElement(driver, password, ValidPassword, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getuserErrorMessage() {

		String userTexterrorMessage = ElementsUtil
				.waitForElementVisibility(driver, userErrorMesg, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
		return userTexterrorMessage;
	}

	public void enterUser(String ValidUserName) {
		ElementsUtil.typeInputIntoElement(driver, username, ValidUserName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getPswdErrorMessage() {
		String getPswderrorMessage = ElementsUtil
				.waitForElementVisibility(driver, pswdErrorMesg, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
		return getPswderrorMessage;
	}

	public void keyboardAction() {
		login.sendKeys(Keys.ENTER);
	}

	public void mouseAction() {
		Actions action = new Actions(driver);
		action.click(login).build().perform();
	}

}
 
  }
 
