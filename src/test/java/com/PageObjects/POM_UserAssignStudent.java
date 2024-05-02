package com.PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import org.openqa.selenium.interactions.Actions;



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
@FindBy(xpath="//form//input[@id='roleId']")
	private WebElement userRoleId;
	@FindBy(xpath = "//form//label")
	private List<WebElement> allfields_Assignstudent;

	@FindBy(xpath = "//p-dropdown")
	private List<WebElement> DropDown;

	@FindBy(xpath = "//form//div[@class='p-radiobutton-box'] ")
	private List<WebElement> RadioButton;

	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[2]/form/div[2]/div")
	private WebElement Error_Message;
	
	@FindBy(xpath = "//*[@id='userId']/div/span")
	private WebElement StudentEmailId;
	@FindBy(xpath="//*[@id=\"userId\"]/div/div[3]/div[1]/div/input")
	private WebElement inout_studentemailId;
	@FindBy(xpath="//form//div[3]//input[@id='programName']")
	private WebElement S_programName;
	@FindBy(xpath="//form//div[3]//input[@id='batchName']")
	private WebElement S_batchName;
	@FindBy(xpath="//*[@id=\"userStatus\"]/div/div[2]")
	private WebElement S_status;
	@FindBy(xpath="/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[3]/button[2]")
	private WebElement save_student;
	@FindBy(xpath=" //p-dropdown//div")
	private List<WebElement> s_errorMessage;
	@FindBy(xpath="//p-toastitem/div/div/div/div[1]")
	private WebElement success_message;

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

	// ***Scenario 2***//
	public void validating_assignstudent_Form()   {
 
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, userRoleId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		Assert.assertTrue(userRoleId.isDisplayed());
		 
		
		ElementsUtil.waitForElementsVisibility(driver, allfields_Assignstudent, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		System.out.println(allfields_Assignstudent.size());
		for (WebElement fields : allfields_Assignstudent) {
			Assert.assertTrue(fields.isDisplayed());
		}
	}

	// **** Scenario 3****
	
	
	
	public void validatingDropDown() throws InterruptedException {
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, StudentEmailId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, StudentEmailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.ScrolltoElementandClick(driver, inout_studentemailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		action.sendKeys("johnsmith@gmail.com").click().perform();
		 action.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		ElementsUtil.waitForElementsVisibility(driver, DropDown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		
		for (WebElement field : DropDown) {
			  Assert.assertEquals(field.getSize(),3);
			 
		}
	}

	// **** Scenario 4****

	public void validating_RadioButtons() {
		ElementsUtil.waitForElementsVisibility(driver, RadioButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement Radio : RadioButton) {
				if(Radio.isDisplayed())
				{
					System.out.println("************Radio Button is Displayed***********");
				}
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
	
	public void fillformwithoutStudentemail(String program,String batch) {
		ElementsUtil.waitForElementVisibility(driver, S_programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_programName,program, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.waitForElementVisibility(driver, S_batchName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_batchName,batch, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.waitForElementVisibility(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.waitForElementVisibility(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		 
	}
	public void validate_StudentError(String text) throws InterruptedException {
		Thread.sleep(1000);
		ElementsUtil.waitForElementsVisibility(driver, s_errorMessage, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
//		
		for (WebElement e : s_errorMessage)
		{
			 Assert.assertTrue(e.getText().contains(text));
		
	}
	}
	public void fillformwithoutprogramname(String emailid,String batch) {
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, StudentEmailId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, StudentEmailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.ScrolltoElementandClick(driver, inout_studentemailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.typeInputIntoElement(driver, inout_studentemailId,emailid,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		 ElementsUtil.waitForElementVisibility(driver, S_batchName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_batchName,batch, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.waitForElementVisibility(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.waitForElementVisibility(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		 
	}
	public void fillformwithoutbatchname(String emailid,String program) {
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, StudentEmailId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, StudentEmailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.typeInputIntoElement(driver, inout_studentemailId,emailid,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		 
		ElementsUtil.waitForElementVisibility(driver, S_programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_programName,program, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.waitForElementVisibility(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.waitForElementVisibility(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		 
	}
	public void fillformwithoutstatus(String emailid,String program,String batch) {
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, StudentEmailId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, StudentEmailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.ScrolltoElementandClick(driver, inout_studentemailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.typeInputIntoElement(driver, inout_studentemailId,emailid,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.waitForElementVisibility(driver, S_programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_programName,program, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.waitForElementVisibility(driver, S_batchName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_batchName,batch, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		  ElementsUtil.waitForElementVisibility(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		 
	}
	
	public void fillformwithvalidata(String emailid,String program,String batch) {
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, StudentEmailId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, StudentEmailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.ScrolltoElementandClick(driver, inout_studentemailId,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.typeInputIntoElement(driver, inout_studentemailId,emailid,Constant.EXPLICIT_ELEMENT_WAIT_TIME );
		ElementsUtil.waitForElementVisibility(driver, S_programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_programName,program, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.waitForElementVisibility(driver, S_batchName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.typeInputIntoElement(driver, S_batchName,batch, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ElementsUtil.waitForElementVisibility(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, S_status, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		  ElementsUtil.waitForElementVisibility(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, save_student, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		 
	}
	public String Success_alertmessage() {
		String data = success_message.getText();
		return data;
	}

}
