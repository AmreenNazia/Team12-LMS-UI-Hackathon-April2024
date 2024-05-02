package com.PageObjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;

public class POM_Dashboard {
	
	WebDriver driver;

	public POM_Dashboard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()=\" Manage Program\"]")
	private WebElement manageProgramHeader;
	
	@FindBy(xpath="//*[text()=\"Program\"]")
	private WebElement programTab;
	
	@FindBy(xpath="//*[text()=\"Program Created Successfully\"]")
	private WebElement successmessage;
	@FindBy(xpath="//*[text()=\"Program Updated\"]")
	private WebElement successeditmessage;
	
	
	public void clickOnProgramTab()
	{
		ElementsUtil.waitForElementVisibility(driver, programTab, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
	}
	
	public WebElement getManageUserHeader()
	{

    return ElementsUtil.waitForElementVisibility(driver, manageProgramHeader, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public boolean OnDashBoardOrNot()
	{
		return ElementsUtil.waitForElementVisibility(driver, programTab, Constant.EXPLICIT_ELEMENT_WAIT_TIME).isDisplayed();
	}
	public String isSuccessMessageDisplayed() {
        return successmessage.getText();
	}
	public String isSuccessupdateMessageDisplayed() {
        return successeditmessage.getText();
	}
//	public String isdeletesucessmessage() {
//        return deletesucessmessage.getText();
//	}
//	WebElement activeElement = driver.switchTo().activeElement();
//	String messageStr = activeElement.getAttribute("validationMessage");
//	System.out.println("Actual message appeared on screen: " + messageStr);

	public WebElement getDeleteUnderManageProgram() {
		
		return ElementsUtil.waitForElementVisibility(driver, manageProgramHeader, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
}