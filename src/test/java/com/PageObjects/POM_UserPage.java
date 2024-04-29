package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import com.Utilities.LoggerLoad;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class POM_UserPage {
	WebDriver driver;

	public POM_UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='user']")
	private WebElement btn_user;
	@FindBy(xpath = "//div[@class='box']/text()")
	private WebElement userText;
	@FindBy(xpath = "//button[@id='user']/span[1]")
	private WebElement user;
	@FindBy(xpath = "//div[@class='signin-content']//mat-card-title/div[1]")
	private WebElement manageuser;
	@FindBy(xpath = "//p-paginator//div")
	private WebElement userPaginaton;

	@FindBy(xpath = "//thead")
	private WebElement userColumnheaders;
	@FindBy(xpath = "//mat-card-title//div//button[@icon='pi pi-trash']")
	private WebElement btn_disabledDelete;

	@FindBy(xpath = "//button[@id='new']//span[2]")
	private WebElement btn_addNewUser;
	@FindBy(xpath = "//button[@label='Assign Staff']//span[2]")
	private WebElement btn_assignStaff;
	@FindBy(xpath = "//button[@label='Assign Student']//span[2]")
	private WebElement btn_assignStudent;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement search;

	@FindBy(xpath = "//table//tbody//tr/td[1]")
	private List<WebElement> userCheckbox;

	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> userRows;
	@FindBy(xpath = "//table//tr//td[5]")
	private List<WebElement> userEdit_Delete_Rows;
	@FindBy(xpath = "//tbody//tr//td[6]//button[1]")
	private List<WebElement> btn_useredit;
	@FindBy(xpath = "//tbody//tr//td[6]//button[2]")
	private List<WebElement> btn_userDelete;
	@FindBy(xpath = "//tbody//tr[1]//td[3]")
	private List<WebElement> firstrow_Name;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement Searchbox;
	@FindBy(xpath = "//tbody//tr")
	private List<WebElement> row_search;
	@FindBy(xpath = "//p-dialog//div[1]//span[@id='pr_id_5-label']")
	private WebElement detailsUser;
	@FindBy(xpath = "//form//div//input")
	private List<WebElement> formdetails;
	@FindBy(xpath = "//mat-card-actions//button[1]")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//mat-card-actions//button[2]")
	private WebElement btn_Submit;

	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[1]/div/button")
	private WebElement X_btn;
	@FindBy(xpath = "//form//mat-form-field")
	private List<WebElement> textboxes;
	@FindBy(xpath = "//form//p-dropdown")
	private List<WebElement> dropdowns;

	@FindBy(xpath = "//form//input[@id='mat-input-2']")
	private WebElement txt_firstName;
	@FindBy(xpath = "//form//input[@id='mat-input-4']")
	private WebElement txt_lastName;
	@FindBy(xpath = "//form//input[@id='mat-input-6']")
	private WebElement txt_phoneNo;
	@FindBy(xpath = "//form//p-dropdown[@id='roleId']")
	private WebElement dropdown_userRole;
	@FindBy(xpath = "//form//p-dropdown[@id='userVisaStatus']")
	private WebElement dropdown_visaStatus;
	@FindBy(xpath = "//form//p-dropdown[@id='userRoleStatus']")
	private WebElement dropdown_roleStatus;
	@FindBy(xpath = "//*[@id=\"mat-input-5\"]")
	private WebElement txt_Location;
	@FindBy(xpath = "//*[@id=\"roleId\"]/div/span")
	private WebElement ChooseR01;
	@FindBy(xpath = "//*[@id=\"userRoleStatus\"]/div/span")
	private WebElement chooseActive;

	@FindBy(xpath = "//form//input[@id='mat-input-7']")
	private WebElement txt_linkedin;
	@FindBy(xpath = "//form//input[@id='mat-input-8']")
	private WebElement txt_email;
	@FindBy(xpath = "//form//input[@id='mat-input-9']")
	private WebElement txt_undergrad;
	@FindBy(xpath = "//form//input[@id='mat-input-10']")
	private WebElement txt_postgrad;
	@FindBy(xpath = "//form//input[@id='mat-input-11']")
	private WebElement txt_timezone;
	@FindBy(xpath = "//form//input[@id='mat-input-12']")
	private WebElement txt_comments;

	@FindBy(xpath = "//*[@id=\"mat-input-3\"]")
	private WebElement txt_middlename;
	@FindBy(xpath = "//p-toastitem/div/div/div/div[1]")
	private WebElement alertmessage;
	@FindBy(xpath = "//mat-error")
	private List<WebElement> errorMessage;
	@FindBy(xpath = "strong")
	private WebElement required;
	@FindBy(xpath = "//p-toast//div")
	private WebElement popup_failed;
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[1]/div/button")
	private WebElement btn_cancel;
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]")
	private WebElement nextpage_icon;
	@FindBy(xpath = "//table//tbody//tr//td[3]")
	private List<WebElement> totalRows;

	String first_name;
	String last_name;

	// -------------------AssignStaff----------------//

	@FindBy(xpath = "//button[@label='Assign Staff']")
	private WebElement btnassignStaff;
	@FindBy(xpath = "//div//span[@id='pr_id_6-label']")
	private WebElement assignstaff_form;
	@FindBy(xpath = "//button[@label='Cancel']")
	private WebElement bt_Cancel;
	@FindBy(xpath = "//button[@label='Save']")
	private WebElement save_Btn;
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[2]/div/div/div[1]/div/button']")
	private WebElement cross_mark;
	@FindBy(xpath = "//input[@id='roleId']")
	private WebElement roleId;
	@FindBy(xpath = "//form//label")
	private List<WebElement> allfields_Assifnstaff;

	@FindBy(xpath = "//p-dropdown")
	private List<WebElement> dropDown;
	@FindBy(xpath = "//*[@id=\"batchName\"]/div/div[2]/div")
	private WebElement selectBatch;
	@FindBy(xpath = "//form//div[@class='p-radiobutton-box'] ")
	private List<WebElement> radioButton;
	@FindBy(xpath = "//*[@id=\"skillName\"]")
	private WebElement Skills;
	@FindBy(xpath = "//button[@label='Save']")
	private WebElement Save_Button;
	@FindBy(xpath = "//p-dialog[2]/div/div/div[2]/form/div[2]/div")
	private WebElement Error_Message;
	@FindBy(xpath = "//input[@id='skillName']")
	private WebElement skill;
	@FindBy(xpath = "//*[@id='programName']/div/span")
	private WebElement programName_dropdown;
	@FindBy(xpath = "//*[@id=\"batchName\"]/div/div[2]/div")
	private WebElement batchName_dropdown;
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/input")
	private WebElement search_batchName;
	@FindBy(xpath = "/html/body/div/div[2]/ul/p-multiselectitem[1]")
	private WebElement checkbox_batchName;
	@FindBy(xpath = "//*[@id=\"Active\"]") // p-dropdown//li
	private WebElement radioBtn_active;
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[2]/div/div/div[2]/form/div[2]/div")
	private WebElement error_studentemailid;
	@FindBy(xpath = "//*[@id=\"userId\"]/div/span")
	private WebElement staffemailId;
	@FindBy(xpath = "//p-dropdown//li")
	private List<WebElement> listofEmailid;
	@FindBy(xpath = "//div[@style='color: red;']")
	private List<WebElement> erro_skill;
	@FindBy(xpath = "//p-paginator//div//span[1]")
	private WebElement pagination;

	public String getPageTtile() {
		return driver.getTitle();
	}

	public String getUser() {
		String user = btn_user.getText().toString();
		return user;
	}

	public void click_User() {
		LoggerLoad.info("**Admin clicks on User**");
		ElementsUtil.ScrolltoElementandClick(driver, btn_user, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public String getUrl() {

		String url = driver.getCurrentUrl();
		return url;

	}

	public String getManageuser() {

		String manageUser = manageuser.getText().toString();
		return manageUser;

	}

	public WebElement getDelete() {
		return btn_disabledDelete;
	}

	public WebElement getSearch() {
		return search;
	}

	public void getpagination() {
		Assert.assertTrue(userPaginaton.isDisplayed());

	}

	public String getcolumnHeaders() {
		String text = userColumnheaders.getText();
		return text;

	}

	public String getaNewUser() {
		String User = btn_addNewUser.getText();
		return User;

	}

	public String getAssignStaff() {
		String Staff = btn_assignStaff.getText();
		return Staff;
	}

	public String getAssignStudent() {
		String student = btn_assignStudent.getText();
		return student;
	}

	public List<WebElement> getRows() {
		return userRows;
	}

	public List<WebElement> geteditdeleteRows() {
		return userEdit_Delete_Rows;
	}

	public int sizeofRows() {
		LoggerLoad.info("Size of the Rows");
		ElementsUtil.waitForElementsVisibility(driver, userRows, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		int rows = userRows.size();
		System.out.println(rows);
		return rows;
	}

	public long getCheckBoxes() {
		LoggerLoad.info("Total CheckBoxes");
		ElementsUtil.waitForElementsVisibility(driver, userRows, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		long totalCheckBoxes = userRows.stream().flatMap(row -> row.findElements(By.tagName("input")).stream())
				.filter(checkbox -> checkbox.getAttribute("type").equals("checkbox")).count();

		return totalCheckBoxes;

	}

	public int getcount_edit() {

		ElementsUtil.waitForElementsVisibility(driver, userEdit_Delete_Rows, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		int editIconCount = 0;

		for (WebElement noOfRecord : userEdit_Delete_Rows) {

			List<WebElement> EditIcon = noOfRecord
					.findElements(By.xpath("//button//span[@class='p-button-icon pi pi-pencil']"));

			for (WebElement editIcon : EditIcon) {
				if (editIcon.isEnabled()) {
					editIconCount++;
					System.out.println(editIconCount);
					break;
				}
			}

		}
		return editIconCount;

	}

	public int getCount_Delete() {
		ElementsUtil.waitForElementsVisibility(driver, userEdit_Delete_Rows, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		int deleteIconCount = 0;

		for (WebElement noOfRecord : userEdit_Delete_Rows) {

			List<WebElement> deleteIcons = noOfRecord
					.findElements(By.xpath("//button//span[@class='p-button-icon pi pi-trash']"));

			for (WebElement deleteIcon : deleteIcons) {
				if (deleteIcon.isEnabled()) {
					deleteIconCount++;
					System.out.println(deleteIconCount);
					break;
				}
			}

		}
		return deleteIconCount;
	}

	public void EnterUsername() {
		ElementsUtil.waitForElementsVisibility(driver, firstrow_Name, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		String first_name = null;
		for (WebElement e : firstrow_Name) {
			first_name = e.getText();
			System.out.println(first_name);
		}

		ElementsUtil.typeInputIntoElement(driver, Searchbox, first_name, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, Searchbox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	}

	public int searchedRow_count() {

		ElementsUtil.waitForElementsVisibility(driver, row_search, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		int row_count = row_search.size();
		System.out.println(row_count);
		return row_count;

	}

	public void SearchwithNoName(String name) throws InterruptedException {

		ElementsUtil.typeInputIntoElement(driver, Searchbox, name, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, Searchbox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		Thread.sleep(500);
		String name_01 = pagination.getText();
		System.out.println("*********" + name_01 + "*************");

	}

	// -----------------------------Add New User----------------------------------//
	public String clickonAddNewUser() {
		String newuser = btn_addNewUser.getText();
		ElementsUtil.ScrolltoElementandClick(driver, btn_addNewUser, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		return newuser;

	}

	public WebElement PopupDetailsUser() {

		return detailsUser;

	}

	public void formdetails() {
		ElementsUtil.waitForElementsVisibility(driver, formdetails, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement formdetail : formdetails) {
			if (formdetail.isDisplayed()) {
				System.out.println(formdetail.getText());
			}
		}
	}

	public WebElement CancelButtonisDisplayed() {
		return btn_Cancel;
	}

	public WebElement SubmitButtonisDisplayed() {
		return btn_Submit;
	}

	public WebElement X_ButtonisDisplayed() {
		return X_btn;
	}

	public void textBoxesforFields() {

		ElementsUtil.waitForElementsVisibility(driver, textboxes, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement textbox : textboxes) {
			if (textbox.isDisplayed()) {
				System.out.println(textbox.getText());
			}
		}

	}

	public void dropdownFields() {
		ElementsUtil.waitForElementsVisibility(driver, dropdowns, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement dropdown : dropdowns) {
			if (dropdown.isDisplayed()) {
				System.out.println(dropdown.getText());
			}
		}
	}

	public void fillUserForm(String firstname, String lastname, String phoneno, String userrole, String visastatus,
			String rolestatus, String location) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, txt_firstName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_firstName, firstname, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_lastName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_lastName, lastname, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_phoneNo, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_phoneNo, phoneno, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_Location, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_Location, location, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, dropdown_userRole, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, dropdown_userRole, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		String userRole = ChooseR01.getText();
		if (userRole.contains(userrole)) {
			ElementsUtil.waitForElementVisibility(driver, dropdown_roleStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, dropdown_roleStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			action.sendKeys(Keys.ARROW_DOWN).perform();
		}
		String roleStatus = chooseActive.getText();

		if (roleStatus.contains(rolestatus)) {
			ElementsUtil.waitForElementVisibility(driver, dropdown_visaStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementsUtil.ScrolltoElementandClick(driver, dropdown_visaStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ARROW_DOWN).perform();
		}
		ElementsUtil.waitForElementVisibility(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	}

	public void fillUSerDetails(String firstname, String middlename, String lastname, String location, String phoneno,
			String linkedIn, String userrole, String rolestatus, String visastatus, String email, String ug, String pg,
			String timezone, String userComments) throws InterruptedException {
		first_name = firstname;
		last_name = lastname;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, txt_firstName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_firstName, firstname, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_middlename, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_middlename, middlename, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_lastName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_lastName, lastname, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_phoneNo, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_phoneNo, phoneno, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_Location, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_Location, location, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, dropdown_userRole, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, dropdown_userRole, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		action.sendKeys(userrole).perform();
		ElementsUtil.waitForElementVisibility(driver, dropdown_roleStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, dropdown_roleStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		action.sendKeys(rolestatus).perform();

		ElementsUtil.waitForElementVisibility(driver, dropdown_visaStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, dropdown_visaStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		action.sendKeys(visastatus).perform();
		// action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

		ElementsUtil.waitForElementVisibility(driver, txt_linkedin, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_linkedin, linkedIn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_email, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_email, email, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_undergrad, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_undergrad, ug, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_postgrad, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_postgrad, pg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_timezone, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_timezone, timezone, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_comments, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_comments, userComments, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		Thread.sleep(100);
	}

	public String UserCreated() {
		String data = alertmessage.getText();
		return data;
	}

	public void nonMandatoryFields(String middlename, String linkedIn, String email, String ug, String pg,
			String timezone, String userComments) {
		ElementsUtil.waitForElementVisibility(driver, txt_middlename, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_middlename, middlename, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_linkedin, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_linkedin, linkedIn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_email, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_email, email, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_undergrad, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_undergrad, ug, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_postgrad, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_postgrad, pg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_timezone, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_timezone, timezone, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, txt_comments, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, txt_comments, userComments, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	}

	public void ErrorMessageunderTextboxes() {

		for (WebElement error : errorMessage) {
			error.isDisplayed();
		}

	}

	public String popupmessage() {
		String popUp = popup_failed.getText();
		return popUp;
	}

	public void clickonSubmitButtonwithEmptyfields() {

		ElementsUtil.waitForElementVisibility(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, btn_Submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public void clickonCancel() {
		ElementsUtil.waitForElementVisibility(driver, btn_cancel, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, btn_cancel, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	}

	public void searchfortheuser() throws InterruptedException {
		boolean ispageexists = false;
		boolean isUserexists = false;
		while (!isUserexists) {
			// Print data from current page
			for (WebElement rows : row_search) {
				System.out.println(rows.getText());
				isUserexists = rows.getText().contains(first_name + " " + last_name);
				if (isUserexists) {

					System.out.println("***********The User exists**************");
					break;
				}

			}
			try {
				ispageexists = false;
				ispageexists = nextpage_icon.isEnabled();
			} catch (Exception e) {
			}
			if (ispageexists) {
				nextpage_icon.click();
			} else {

				break;
			}
		}
	}

	// -------------------Assign Staff--------------------//

	public WebElement click_assignstaff() {
		return btnassignStaff;
	}

	public void assignstaff_form() {
		ElementsUtil.waitForElementVisibility(driver, assignstaff_form, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		assignstaff_form.isDisplayed();
		bt_Cancel.isDisplayed();
		save_Btn.isDisplayed();

	}

	public void validating_assignstaf_Form() {

		ElementsUtil.waitForElementVisibility(driver, roleId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		roleId.isDisplayed();
		ElementsUtil.waitForElementsVisibility(driver, allfields_Assifnstaff, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		allfields_Assifnstaff.size();
		for (WebElement fields : allfields_Assifnstaff) {
			fields.isDisplayed();
		}
	}

	public void validatingDropDown() {
		ElementsUtil.waitForElementsVisibility(driver, dropDown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, selectBatch, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		selectBatch.isDisplayed();
		for (WebElement fields : dropDown) {
			fields.isDisplayed();
		}
	}

	public void validating_radioButtons() {
		ElementsUtil.waitForElementsVisibility(driver, radioButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement radio : radioButton) {
			radio.isDisplayed();
		}
	}

	public void CLick_SaveButton() {

		ElementsUtil.waitForElementVisibility(driver, Save_Button, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, Save_Button, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

	public WebElement errorMessage_displayed() {
		ElementsUtil.waitForElementVisibility(driver, Error_Message, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return Error_Message;

	}

	public void fillAssignStudent(String skill, String programname, String batchname) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		ElementsUtil.waitForElementVisibility(driver, Skills, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, Skills, skill, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, programName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, programName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		action.sendKeys(programname).click().perform();
		ElementsUtil.waitForElementVisibility(driver, batchName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, batchName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, search_batchName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		action.sendKeys(batchname).click().perform();

		action.moveToElement(checkbox_batchName).click().perform();
//		ElementsUtil.ScrolltoElementandClick(driver, checkbox_batchName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, radioBtn_active, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, radioBtn_active, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, Save_Button, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, Save_Button, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		Thread.sleep(1000);
	}

	public WebElement Error_Studentemail() {
		ElementsUtil.waitForElementVisibility(driver, error_studentemailid, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return error_studentemailid;
	}

	public void fillwithoutSkill(String emailid, String programName, String batchname) throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(1000);
//		ElementsUtil.waitForElementVisibility(driver, staffemailId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, staffemailId, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.typeInputIntoElement(driver, staffemailId, emailid, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		for (WebElement e : listofEmailid) {
			if (e.getText().contains(emailid))
				e.click();
			System.out.println("---------" + e.getText() + "----------");
			break;
		}

//		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		ElementsUtil.waitForElementVisibility(driver, Skills, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		action.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
				.perform();

		ElementsUtil.waitForElementVisibility(driver, programName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, programName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		action.sendKeys(programName).click().perform();
		ElementsUtil.waitForElementVisibility(driver, batchName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, batchName_dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, search_batchName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		action.sendKeys(batchname).click().perform();

		action.moveToElement(checkbox_batchName).click().perform();

		ElementsUtil.waitForElementVisibility(driver, radioBtn_active, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, radioBtn_active, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.waitForElementVisibility(driver, Save_Button, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, Save_Button, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		Thread.sleep(1000);

	}

	public void validate_SkillerrorMessage(String text) {
		for (WebElement e : erro_skill)

		{
			Assert.assertEquals(e.getText(), text);
		}
	}

	public void validate_Cancel_btn() {
		ElementsUtil.waitForElementVisibility(driver, btn_Cancel, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementsUtil.ScrolltoElementandClick(driver, btn_Cancel, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}

}
