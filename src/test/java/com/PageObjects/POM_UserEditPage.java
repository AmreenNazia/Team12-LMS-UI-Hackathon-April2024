package com.PageObjects;

import org.apache.commons.math3.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import com.Utilities.InputValueType;
import com.Utilities.LoggerLoad;

public class POM_UserEditPage {
WebDriver driver;
	
	public POM_UserEditPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//button[@id='user']")
	WebElement btn_user;
	
	@FindBy(xpath = "//div[@class='box']/text()")
	WebElement text;
	
	@FindBy(xpath="//button[@id='user']//span")
	WebElement user;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[6]/div/span/button[1]/span[1]")
	WebElement edit_btn;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-title/div[1]")
	WebElement manageUserTitle;
	
	@FindBy(xpath = "//*[contains(@class, 'p-dialog-title ng-tns-c132-6 ng-star-inserted')]")
	WebElement editUserTitle;

	@FindBy(xpath = "//*[@id=\"filterGlobal\"]")
	WebElement searchTextBox;
	
	
	@FindBy(xpath = "//input[@formcontrolname='userFirstName']")
	WebElement firstName;
	@FindBy(xpath = "//input[@formcontrolname='userMiddleName']")
	WebElement middleName;
	@FindBy(xpath = "//input[@formcontrolname='userLastName']")
	WebElement lastName;
	@FindBy(xpath = "//input[@formcontrolname='userPhoneNumber']")
	WebElement phoneNumber;
	@FindBy(xpath = "//input[@formcontrolname='userLocation']")
	WebElement location;
	@FindBy(xpath = "//input[@formcontrolname='userLoginEmail']")
	WebElement email;
	
	@FindBy(xpath = "//input[@formcontrolname='userLinkedinUrl']")
	WebElement linkedInURL;
	@FindBy(xpath = "//*[@id=\"roleId\"]")
	WebElement userRole;
	@FindBy(xpath = "//*[@id=\"userRoleStatus\"]")
	WebElement userRoleStatus;
	@FindBy(xpath = "//*[@id=\"userVisaStatus\"]")
	WebElement userVisaStatus;
	@FindBy(xpath = "//input[@formcontrolname='userEduUg']")
	WebElement underGraduate;
	@FindBy(xpath = "//input[@formcontrolname='userEduPg']")
	WebElement postGraudate;
	@FindBy(xpath = "//input[@formcontrolname='userTimeZone']")
	WebElement timezone;
	@FindBy(xpath = "//input[@formcontrolname='userComments']")
	WebElement userComments;
	
	
	
	//success msg
	@FindBy(xpath = "//p-toastitem/div/div/div/div[2]")
	WebElement detailedMsg;

//error msg
	@FindBy(xpath = "//p-toastitem/div/div/div/div[1]")
	WebElement headerMsg;
	
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[2]/form/mat-card/mat-card-actions/button[2]/span[1]")
	WebElement submit;
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[2]/form/mat-card/mat-card-actions/button[1]")
	WebElement cancel;
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[1]/div/button")
	WebElement closeButton;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr/td[3]")
	WebElement tableFullName;

	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr/td[4]")
	WebElement tableLocation;

	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr/td[5]")
	WebElement tablePhoneNumber;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]")
	WebElement idSort;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]")
	WebElement nameSort;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]")
	WebElement locationSort;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[5]")
	WebElement phoneNumberSort;
	
	
	
	
	public void click_User(String User)  {
		 ElementsUtil.ScrolltoElementandClick(driver, btn_user, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

  
	public void waitForManageUserPage() {
		ElementsUtil.waitForElementVisibility(driver, manageUserTitle, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public void clickEditButton() {
		ElementsUtil.ScrolltoElementandClick(driver, edit_btn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LoggerLoad.info("Opened the Edit window popup...");
	}

	public void waitForEditUserPageTitle() {
		ElementsUtil.waitForElementVisibility(driver, editUserTitle, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		Assert.assertEquals(editUserTitle.getText(), "User Details");
	}
	
	public void searchInput(String text)  {
		ElementsUtil.typeInputIntoElement(driver, searchTextBox, text, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void modifyUser(String fieldName, InputValueType type) {
		Pair<WebElement, String> fieldElmentAndValue;
		try {
			fieldElmentAndValue = getFieldElementAndValueByName(fieldName, type);
			WebElement element = fieldElmentAndValue.getKey();
			String value = fieldElmentAndValue.getValue();
			String tagName = element.getTagName();
			if(tagName.equalsIgnoreCase("input")) {
				ElementsUtil.sendInput(driver, element, value, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			} else if (tagName.equalsIgnoreCase("p-dropdown")) {
				element.click();
				Thread.sleep(1000);
				WebElement option = element.findElement(By.xpath("//li[@aria-label='"+value+"']"));
				option.click();
				
			}
			LoggerLoad.info("Updated field name:  "+ fieldName  +" with value as: "+ value);
			//To handle the email bug.
			if(!fieldName.equals("email")) {
				ElementsUtil.sendInput(driver, email, com.PageObjects.credentialResouceBundle.getEmailByType(InputValueType.VALID), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Pair<WebElement, String> getFieldElementAndValueByName(String fieldName, InputValueType valueType) throws Exception {
		WebElement element = null;
		String value = null;
		switch(fieldName) {
		case "firstName":
			element = firstName;
			value = com.PageObjects.credentialResouceBundle.getFirstNameByType(valueType);
			break;
		case "middleName":
			element = middleName;
			value = com.PageObjects.credentialResouceBundle.getMiddleNameByType(valueType);
			break;
		case "lastName":
			element = lastName;
			value = com.PageObjects.credentialResouceBundle.getLastNameByType(valueType);
			break;
		case "location":
			element = location;
			value = com.PageObjects.credentialResouceBundle.getLocationByType(valueType);
			break;
		case "phoneNumber":
			element = phoneNumber;
			value = com.PageObjects.credentialResouceBundle.getPhoneNumberByType(valueType);
			break;
		case "linkedinURL":
			element = linkedInURL;
			value = com.PageObjects.credentialResouceBundle.getInvalidLinkedInURL(valueType);
			break;
		case "userRole":
			element = userRole;
			value = com.PageObjects.credentialResouceBundle.getUserRoleByType(valueType);
			break;
		case "userRoleStatus":
			element = userRoleStatus;
			value = com.PageObjects.credentialResouceBundle.getUserRoleStatusByType(valueType);
			break;
		case "userVisaStatus":
			element = userVisaStatus;
			value = com.PageObjects.credentialResouceBundle.getVisaStatusByType(valueType);
			break;
		case "email":
			element = email;
			value = com.PageObjects.credentialResouceBundle.getEmailByType(valueType);
			break;
		case "underGraduate":
			element = underGraduate;
			value = com.PageObjects.credentialResouceBundle.getUnderGraduateByType(valueType);
			break;
		case "postGraduate":
			element = postGraudate;
			value = com.PageObjects.credentialResouceBundle.getPostGraduateByType(valueType);
			break;	
		case "timezone":
			element = timezone;
			value = com.PageObjects.credentialResouceBundle.getTimeZoneByType(valueType);
			break;
		case "userComments":
			element = userComments;
			value = com.PageObjects.credentialResouceBundle.getUserCommentsByType(valueType);
			break;
		}
		if(element == null || value == null) {
			throw new Exception("Invalid field name " + fieldName);
		}
		return new Pair<>(element, value);
	}


	public void clickSubmitOnEditWindow() {
		ElementsUtil.ScrolltoElementandClick(driver, submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Clicked submit on the edit window...");
	}
	
	
	public void clickCancelOnEditWindow() {
		ElementsUtil.ScrolltoElementandClick(driver, cancel, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Clicked cancel on the edit window popup...");
	}
	
	public void clickCloseButtonOnEditWindow() {
		ElementsUtil.ScrolltoElementandClick(driver, closeButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("Closed the edit window popup...");
	}

	public void checkDetailedMsg(String msg) {
		ElementsUtil.waitForElementVisibility(driver, detailedMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);	
		Assert.assertEquals(detailedMsg.getText(), msg);
	}
	
	public void checkHeaderMsg(String msg) {
		ElementsUtil.waitForElementVisibility(driver, headerMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);	
		Assert.assertEquals(headerMsg.getText(), msg);
	}
	
	public void verifyModifiedValue(String fieldName, InputValueType type) {
		try {
			Pair<WebElement, String> fieldElementValuePair = getFieldElementAndValueByName(fieldName, type);
			WebElement element = fieldElementValuePair.getKey();
			String value = fieldElementValuePair.getValue();
			String tagName = element.getTagName();
			if(tagName.equalsIgnoreCase("input")) {
				String attr = element.getAttribute("value");
				if(type == InputValueType.VALID) {
					Assert.assertEquals(attr, value);	
				} else if(type == InputValueType.CANCNEL_INPUT) {
					Assert.assertNotEquals(attr, value);
				}
				
			} else if (tagName.equalsIgnoreCase("p-dropdown")) {
				String selectedVal = element.getText();
				Assert.assertEquals(selectedVal, value);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
