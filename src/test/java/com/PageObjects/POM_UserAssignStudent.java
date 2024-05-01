package com.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;

public class POM_UserAssignStudent {
	private WebDriver driver;

	@FindBy(xpath = "//button[@id='user']")
	private static WebElement userButton;

	@FindBy(xpath = "//div[@class='signin-content']//mat-card-title/div[1]")
	private WebElement manageuser;

	@FindBy(xpath = "//*[@label='Assign Student']")
	private WebElement assignStudent;

	@FindBy(xpath = "//p-dialog//div//span[text()='Assign Student']")
	private WebElement PopUpAssignStudent;

	@FindBy(xpath = " //div[@class='p-dialog-header-icons ng-tns-c132-8']/button/span")
	private WebElement CloseButton;

	@FindBy(xpath = "//*[@label='Save']")
	private WebElement SaveButton;

	@FindBy(xpath = "//*[@label='Cancel']")
	private WebElement CancelButton;

	@FindBy(xpath = "//*[@id=\"roleId\"]")
	private WebElement UserRole;

	@FindBy(xpath = "//form//label")
	private List<WebElement> allfields_Assignstudent;

	@FindBy(xpath = "//p-dropdown")
	private List<WebElement> DropDown;

	@FindBy(xpath = "//form//div[@class='p-radiobutton-box'] ")
	private List<WebElement> RadioButton;

	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[2]/div")
	private WebElement Error_Message;

	public POM_UserAssignStudent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickUserButton() {
		userButton.click();
	}

	public String getUrl() throws InterruptedException {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String getManageuser() {
		String manageUser = manageuser.getText().toString();
		return manageUser;
	}

	public void clickAssignStudent() {
		ElementsUtil.waitForElementVisibility(driver, assignStudent, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		assignStudent.click();
	}

	public WebElement PopUpAssignStudent() {
		return PopUpAssignStudent;
	}

	public boolean verifyCloseButton() {
		ElementsUtil.waitForElementVisibility(driver, assignStudent, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return CloseButton.isDisplayed();
	}

	public boolean verifySaveButton() {
		ElementsUtil.waitForElementVisibility(driver, assignStudent, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return SaveButton.isDisplayed();
	}

	public boolean verifyCancelButton() {
		ElementsUtil.waitForElementVisibility(driver, assignStudent, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return CancelButton.isDisplayed();
	}

	// ***Scenario 2***
	public void validating_assignstudent_Form() {

		ElementsUtil.waitForElementVisibility(driver, UserRole, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		UserRole.isDisplayed();
		ElementsUtil.waitForElementsVisibility(driver, allfields_Assignstudent, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		allfields_Assignstudent.size();
		for (WebElement fields : allfields_Assignstudent) {
			fields.isDisplayed();
		}
	}

	// **** Scenario 3****

	public void validatingDropDown() {
		ElementsUtil.waitForElementsVisibility(driver, DropDown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement fields : DropDown) {
			Assert.assertEquals(fields.getSize(),1);
			//fields.isDisplayed();
		}
	}

	// **** Scenario 4****

	public void validating_RadioButtons() {
		ElementsUtil.waitForElementsVisibility(driver, RadioButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement Radio : RadioButton) {
			Radio.isDisplayed();
		}
	}

	// **** Scenario 5****

	public void CLick_SaveButton() {

		ElementsUtil.waitForElementVisibility(driver, SaveButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, SaveButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public WebElement errorMessage_displayed() {
		ElementsUtil.waitForElementVisibility(driver, Error_Message, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return Error_Message;

	}

	// **** Scenario 10****

	public void validate_close_AssignStudent() {
		ElementsUtil.waitForElementVisibility(driver, CloseButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, CloseButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	// **** Scenario 12****
	public void validate_Cancel_AssignStudent() {
		ElementsUtil.waitForElementVisibility(driver, CancelButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, CancelButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

}
