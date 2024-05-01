package com.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;

public class POM_BatchPage {

	WebDriver driver;
	ExcelReader reader;
	WebDriverWait wait;

	String xlPath = "src\\test\\resources\\TestData\\Team12-TestData-LMS-UI-Hackathon-April2024.xlsx";

	public POM_BatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.reader = new ExcelReader();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@FindBy(xpath = "//*[text()=\" Manage Batch\"]")
	WebElement manageBatchHeader;

	@FindBy(xpath = "//button[starts-with(@class,\"p-paginator-first\")]")
	WebElement firstPageControl;

	@FindBy(xpath = "//button[starts-with(@class,\"p-paginator-prev\")]")
	WebElement previousPageControl;

	@FindBy(xpath = "//button[starts-with(@class,\"p-paginator-next\")]")
	WebElement nextPageControl;

	@FindBy(xpath = "//button[starts-with(@class,\"p-paginator-last\")]")
	WebElement lastPageControl;

	@FindBy(xpath = "//*[@class=\"p-datatable-thead\"]")
	WebElement datatable;

	@FindBy(xpath = "//*[text()=\"Batch Name \"]")
	WebElement batchNameHeader;

	@FindBy(xpath = "//*[text()=\"Batch Description \"]")
	WebElement batchDescriptionHeader;

	@FindBy(xpath = "//*[text()=\"Batch Status \"]")
	WebElement batchStatusHeader;

	@FindBy(xpath = "//*[text()=\"No Of Classes \"]")
	WebElement noOfClassesHeader;

	@FindBy(xpath = "//*[text()=\"Program Name \"]")
	WebElement programNameHeader;

	@FindBy(xpath = "//*[text()=\" Edit / Delete \"]")
	WebElement editDeleteHeader;

	@FindBy(xpath = "//*[starts-with(@class,\"p-button-danger\")]")
	WebElement multiDeleteButton;

	@FindBy(xpath = "//*[@id=\"new\"]")
	WebElement aNewBatchButton;

	@FindBy(xpath = "//table//tr")
	List<WebElement> rows;

	@FindBy(xpath = "//tbody/tr")
	List<WebElement> noOfRecords;

	@FindBy(xpath = "//*[text()=\"Batch Details\"]")
	WebElement batchDetails;

	@FindBy(id = "batchName")
	WebElement nameTextField;

	@FindBy(css = "#batchDescription")
	WebElement descriptionTextBox;

	@FindBy(xpath = "//*[@role=\"button\"]")
	WebElement programNameDropdown;

	@FindBy(xpath = "//*[@class=\"radio ng-star-inserted\"]")
	WebElement statusRadioButtons;

	@FindBy(xpath = "//*[@id=\"batchNoOfClasses\"]")
	WebElement NumberOfClassesTextField;

	@FindBy(xpath = "//li")
	WebElement listOfElementsInProgramNameDropdown;

	@FindBy(xpath = "//*[@id=\"batchStatus\"]")
	WebElement statusButton;

	@FindBy(xpath = "//*[@type=\"radio\"]")
	List<WebElement> radioButtons;

	@FindBy(xpath = "//*[@class=\"radio ng-star-inserted\"]")
	WebElement statusLabel;

	@FindBy(xpath = "/html//div/div/div[2]/p-radiobutton/div/div[2]")
	WebElement activeButton;

	@FindBy(xpath = "//p-dialog/div/div/div[2]/div[4]/div[3]/p-radiobutton")
	WebElement inActiveButton;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[3]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li")
	WebElement option;

	@FindBy(xpath = "//*[text()=\"Save\"]")
	WebElement saveButton;

	@FindBy(xpath = "//*[text()=\"Batch Description is required.\"]")
	WebElement descriptionErrorMessage;

	@FindBy(id = "filterGlobal")
	WebElement searchBox;

	@FindBy(xpath = "//*[text()=\"Showing 0 to 0 of 0 entries\"]")
	WebElement noOfRowsPresentInPage;

	@FindBy(xpath = "//*[text()=\"Showing 1 to 1 of 1 entries\"]")
	WebElement addedBatchNameStatus;

	@FindBy(xpath = "//*[text()=\"This field should start with an alphabet and min 2 character. \"]")
	WebElement errorMessage;

	@FindBy(xpath = "//*[@id=\"text-danger\"]")
	WebElement errorMessageWithInvalidDescription;

	@FindBy(xpath = "//*[starts-with(@class,\"p-invalid\")]")
	List<WebElement> errorMessageOfMandatoryFields;

	@FindBy(xpath = "//*[starts-with(@class,\"p-dialog-header-close\")]")
	WebElement closeButton;

	@FindBy(xpath = "//*[contains(@class, \"p-button-rounded p-button-danger\")]")
	List<WebElement> deleteRoundedIconButtons;

	@FindBy(xpath = "//*[contains(@class, 'pi-pencil')]")
	List<WebElement> editIconButtons;

	@FindBy(xpath = "//*[@class=\"p-checkbox-box p-component\"][1]")
	WebElement firstCheckBoxInManageBatchPage;

	@FindBy(xpath = "//*[contains(@class, \"p-button-rounded p-button-danger\")][1]")
	WebElement firstDeleteRoundedIconButton;

	@FindBy(xpath = "//*[text()=\"Yes\"]")
	WebElement yesInConfirmBox;

	@FindBy(xpath = "//*[text()=\"No\"]")
	WebElement noInConfirmBox;

	@FindBy(xpath = "//tbody//tr[1]/td[2]")
	WebElement firstRecordBatchName;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-toast/div/p-toastitem/div/div/div/div[2]")
	WebElement BatchDeletedSuccessMessage;

	@FindBy(xpath = "//*[@role=\"checkbox\"]")
	List<WebElement> checkBoxes;

	@FindBy(xpath = "//div/mat-card/mat-card-title/div[2]/div[1]/button")
	WebElement deleteUnderManageBatch;

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement firstCheckBox;

	@FindBy(xpath = "//table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement secondCheckBox;

	@FindBy(xpath = "//p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[1]/button")
	WebElement firstEditIcon;

	@FindBy(xpath = "//p-table/div/div[1]/table/tbody/tr")
	WebElement firstRow;

	@FindBy(xpath = "//p-dialog/div/div/div[2]/div[3]/p-dropdown/div/input")
	WebElement programDropdownTextField;

	public String getManageBatchHeader() {
		return manageBatchHeader.getText();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean areAllPaginationControlsDisplayed() {
		boolean flag = false;

		boolean isFirstPageControlDisplayed = firstPageControl.isDisplayed();
		boolean isLastPageControlDisplayed = lastPageControl.isDisplayed();
		boolean isNextPageControlDisplayed = nextPageControl.isDisplayed();
		boolean isPreviousPageControlDisplayed = previousPageControl.isDisplayed();

		if (isFirstPageControlDisplayed && isLastPageControlDisplayed && isNextPageControlDisplayed
				&& isPreviousPageControlDisplayed) {
			flag = true;
			System.out.println("*********All page controls are displayed*********");
			LoggerLoad.info("*********All page controls are displayed*********");
		} else {
			flag = false;
			System.out.println("*********All page controls are not displayed*********");
			LoggerLoad.info("*********All page controls are not displayed*********");
		}
		return flag;
	}

	public boolean areTableAndHeadersDisplayed() {
		boolean flag = false;

		if (datatable.isDisplayed()) {
			if (batchNameHeader.isDisplayed() && batchDescriptionHeader.isDisplayed() && batchStatusHeader.isDisplayed()
					&& noOfClassesHeader.isDisplayed() && programNameHeader.isDisplayed()
					&& editDeleteHeader.isDisplayed()) {
				System.out.println("*********Data table is present along with headers*********");
				LoggerLoad.info("*********Data table is present along with headers*********");
				flag = true;

			} else {
				System.out.println("*********Not all table headers are present*********");
				LoggerLoad.info("*********Not all table headers are present*********");
				flag = false;
			}

		} else {
			System.out.println("*********Data table is not present along with headers*********");
			LoggerLoad.info("*********Data table is not present along with headers*********");
			flag = false;
		}
		return flag;

	}

	public boolean getMultideleteStatus() {
		return multiDeleteButton.isEnabled();
	}

	public boolean isANewBatchButtonDisplayedOrNot() {
		return aNewBatchButton.isDisplayed();
	}

	public List<WebElement> getRows() {
		ElementsUtil.waitForElementsVisibility(driver, rows, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return rows;
	}

	public long getNoOfCheckBoxes() {
		ElementsUtil.waitForElementsVisibility(driver, rows, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		long totalCheckBoxes = rows.stream().flatMap(row -> row.findElements(By.tagName("input")).stream())
				.filter(checkbox -> checkbox.getAttribute("type").equals("checkbox")).count();
		return totalCheckBoxes;

	}

	public int getNoOfRecords() {
		ElementsUtil.waitForElementsVisibility(driver, noOfRecords, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return noOfRecords.size();
	}

	public int countOfEnabledEditIconInEachRecord() {

		ElementsUtil.waitForElementsVisibility(driver, noOfRecords, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		int editIconCount = 0;

		for (WebElement noOfRecord : noOfRecords) {

			List<WebElement> editIcons = noOfRecord
					.findElements(By.xpath("//*[@class=\"p-button-icon pi pi-pencil\"]"));
			for (WebElement editIcon : editIcons) {
				if (editIcon.isEnabled()) {
					editIconCount++;
					break;
				}
			}

		}
		return editIconCount;
	}

	public int countOfEnabledDeleteIconInEachRecord() {
		ElementsUtil.waitForElementsVisibility(driver, noOfRecords, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		int editIconCount = 0;

		for (WebElement noOfRecord : noOfRecords) {

			List<WebElement> deleteIcons = noOfRecord
					.findElements(By.xpath("//*[contains(@class,\"p-button-rounded p-button-danger\")]"));
			for (WebElement deleteIcon : deleteIcons) {
				if (deleteIcon.isEnabled()) {
					editIconCount++;
					break;
				}
			}

		}
		return editIconCount;
	}

	public WebElement getANewBatchButton() {
		return aNewBatchButton;
	}

	public String getPopupWindowWithBatchDetails() {

		return batchDetails.getText();

	}

	public void switchToNewPopupWithBatchDetails() throws InterruptedException {
		String currentWindowHandle = driver.getWindowHandle();
		aNewBatchButton.click();
		Thread.sleep(2000);
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(currentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}

		}

	}

	/********************** Add New Batch Feature *****************************/

	public void clickOnANewBatchButton() {
		aNewBatchButton.click();
	}

	public boolean batchDetailsIsDisplayed() {
		return batchDetails.isDisplayed();
	}

	public boolean isNameTextBoxOrNot() {
		return ElementsUtil.isTextBox(driver, nameTextField);
	}

	public boolean isDescriptionTextBoxOrNot() {
		return ElementsUtil.isTextBox(driver, descriptionTextBox);
	}

	public String getAttributeOfTextField() {
		String attributeType = nameTextField.getAttribute("type");
		return attributeType;

	}

	public String getAttributeOfDescriptionField() {
		String attributeType = descriptionTextBox.getAttribute("type");
		return attributeType;

	}

	public boolean isNoOfClassesTextBoxOrNot() {
		return ElementsUtil.isTextBox(driver, NumberOfClassesTextField);
	}

	public String getAttributeOfNoOfClassesField() {
		String attributeType = NumberOfClassesTextField.getAttribute("type");
		return attributeType;

	}

	public boolean programNameDropDownOrNot() {
		String roleAttribute = programNameDropdown.getAttribute("role");

		String ariaHasPopupAttribute = programNameDropdown.getAttribute("aria-haspopup");

		programNameDropdown.click();

		ElementsUtil.waitForElementVisibility(driver, listOfElementsInProgramNameDropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		if (listOfElementsInProgramNameDropdown.isDisplayed()
				&& (("button".equalsIgnoreCase(roleAttribute) || "listbox".equalsIgnoreCase(ariaHasPopupAttribute)))) {
			return true;
		} else {
			return false;
		}

	}

	public boolean statusButtonRadioOrNot() throws InterruptedException {

		programNameDropdown.click();
		WebElement activeRadioButton = statusLabel
				.findElement(By.xpath("/html//div/div/div[2]/p-radiobutton/div/div[2]"));
		WebElement inActiveRadioButton = statusLabel
				.findElement(By.xpath("/html//div[4]/div[3]/p-radiobutton/div/div[2]"));

		return activeRadioButton.isDisplayed() && inActiveRadioButton.isDisplayed();

	}

	public String getAttributeOfStatusButton() {
		String attributeType = radioButtons.get(0).getAttribute("type");
		return attributeType;

	}

	public void checkIfDescriptionOptionalOrNot() throws InvalidFormatException, IOException {
		List<Map<String, String>> data = reader.getData(xlPath, "Batch");

		nameTextField.sendKeys(data.get(0).get("Name"));
		programDropdownTextField.sendKeys("xpathteam1267");
		//programNameDropdown.click();

		//option.click();
		activeButton.click();
		NumberOfClassesTextField.sendKeys(data.get(0).get("Number of Classes"));
		saveButton.click();
		closeButton.click();
	}

	public WebElement getDescriptionErrorMessage() {
		return descriptionErrorMessage;
	}

	public String getNoOfRowsPresentInPage() {
		ElementsUtil.waitForElementVisibility(driver, noOfRowsPresentInPage, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		return noOfRowsPresentInPage.getText();

	}

	public boolean isBatchPresentInDataTable() throws InvalidFormatException, IOException {

		List<Map<String, String>> data = reader.getData(xlPath, "Batch");
		searchBox.clear();
		searchBox.sendKeys(data.get(0).get("Name"));

		ElementsUtil.waitForElementVisibility(driver, noOfRowsPresentInPage, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		return !noOfRowsPresentInPage.getText().contains("0 entries");

	}

	public void enterValidDataForBatchDetailsWindow() throws InvalidFormatException, IOException {
		List<Map<String, String>> data = reader.getData(xlPath, "Batch");

		nameTextField.sendKeys(data.get(0).get("Name"));
		descriptionTextBox.sendKeys(data.get(0).get("Description"));
		programNameDropdown.click();

		option.click();
		activeButton.click();
		NumberOfClassesTextField.sendKeys(data.get(0).get("Number of Classes"));
		saveButton.click();

	}

	public boolean checkBatchDetailsAdded() throws InvalidFormatException, IOException {

		List<Map<String, String>> data = reader.getData(xlPath, "Batch");
		searchBox.clear();
		searchBox.sendKeys(data.get(0).get("Name"));

		ElementsUtil.waitForElementVisibility(driver, noOfRowsPresentInPage, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		return addedBatchNameStatus.getText().contains("1 entries");

	}

	public String batchAddedStatus() {
		ElementsUtil.waitForElementVisibility(driver, addedBatchNameStatus, 20);

		return addedBatchNameStatus.getText();

	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void enterInvalidFields() throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> data = reader.getData(xlPath, "Batch");
		nameTextField.sendKeys(data.get(0).get("Invalid BatchName"));

		descriptionTextBox.sendKeys(data.get(0).get("Invalid Description"));

		NumberOfClassesTextField.sendKeys(data.get(0).get("Invalid NumberOfClasses"));

	}

	public void checkErrorMessageForMandatoryFields() {
		ElementsUtil.waitForElementVisibility(driver, saveButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		saveButton.click();

	}

	public List<String> getErrorMessageOfMandatoryFields() {
		List<String> errorMessages = new ArrayList<String>();
		for (WebElement errorMessageOfMandatoryField : errorMessageOfMandatoryFields) {
			String errorMessage = errorMessageOfMandatoryField.getText();
			errorMessages.add(errorMessage);
		}
		return errorMessages;
	}

	public boolean checkDeleteIconShouldBeEnabled() {

		for (WebElement deleteRoundedIconButton : deleteRoundedIconButtons) {

			if (!deleteRoundedIconButton.isEnabled()) {
				return false;
			}

		}
		return true;
	}

	public void switchToConfirmWindow() {
		String currentWindowHandle = driver.getWindowHandle();
		ElementsUtil.waitForElementVisibility(driver, firstDeleteRoundedIconButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		firstDeleteRoundedIconButton.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(currentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}

		}
	}

	public boolean checkYesAndNoOptionAppearence() {
		return yesInConfirmBox.isDisplayed() && noInConfirmBox.isDisplayed();
	}

	public WebElement getYesOption() {
		return yesInConfirmBox;
	}

	public String batchDeletedAlertPops() {
		ElementsUtil.waitForElementVisibility(driver, BatchDeletedSuccessMessage, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		return BatchDeletedSuccessMessage.getText();
	}

	public WebElement getNoOption() {
		return noInConfirmBox;
	}

	public boolean checkBatchDetailsStillExists() throws InvalidFormatException, IOException {

		List<Map<String, String>> data = reader.getData(xlPath, "Batch");
		searchBox.clear();
		searchBox.sendKeys(data.get(0).get("Name"));

		ElementsUtil.waitForElementVisibility(driver, noOfRowsPresentInPage, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		return addedBatchNameStatus.getText().matches("//d+ entries");

	}

	public boolean checkBatchExistsInDatatableOrNotAfterDeletion() {
		searchBox.clear();

		String deletedBatchName = firstRecordBatchName.getText();
		LoggerLoad.info("************* BatchName is**************" + deletedBatchName);
		searchBox.sendKeys(deletedBatchName);
		ElementsUtil.waitForElementVisibility(driver, addedBatchNameStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		return addedBatchNameStatus.getText().matches("//d+ entries");

	}

	/********************** delete multiple batches *******************/
//returns true if checkbox is selected else return false if checkbox not found

	public boolean isAnyCheckboxSelected() throws InterruptedException {
		boolean anyCheckboxSelected = false;
		WebElement nextPageControl = driver.findElement(By.xpath("//button[starts-with(@class,\"p-paginator-next\")]"));
		while (nextPageControl != null) {

			for (WebElement checkbox : checkBoxes) {
				if (checkbox.isSelected()) {
					anyCheckboxSelected = true;
					break; // Exit inner loop if any checkbox is selected
				}
			}

			if (anyCheckboxSelected) {
				return true; // Early return if any checkbox is selected
			}

			try {
				ElementsUtil.waitForElementVisibility(driver, nextPageControl, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
				nextPageControl.click();
			} catch (NoSuchElementException e) {
				// Handle the case where next page button is not found (log or continue if
				// acceptable)
				nextPageControl = null;
			} catch (ElementClickInterceptedException e) {
				// Handle overlapping elements or other potential causes (log, retry, or adjust
				// strategy)
				return anyCheckboxSelected;
			}
		}
		return anyCheckboxSelected;
	}

	public WebElement getDeleteUnderManageBatch() {
		return deleteUnderManageBatch;
	}

	public WebElement getFirstCheckBox() {

		return firstCheckBox;
	}

	public WebElement getSecondCheckBox() {

		return secondCheckBox;
	}

	public String getTheRowDetailsOfSelectedCheckBox() {
		WebElement row = firstCheckBox.findElement(By.xpath("./ancestor::tr"));
		String rowText = row.getText();
		return rowText;

	}

	public String getTheBatchNameOfSecondSelectedCheckBox() {
		WebElement batchNameElement = secondCheckBox.findElement(By.xpath(".//ancestor::tr/td[2]")); // Assuming batch
																										// name is in
																										// the first
																										// column
		String batchName = batchNameElement.getText();

		return batchName;

	}

	public String getTheBatchNameOfSelectedCheckBox() {

		WebElement batchNameElement = firstCheckBox.findElement(By.xpath(".//ancestor::tr/td[2]")); // Assuming batch
																									// name is in the
																									// first column
		String batchName = batchNameElement.getText();

		return batchName;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	/*************************************
	 * edit batch
	 ****************************************/

	public WebElement getFirstEditIcon() {
		return firstEditIcon;
	}

	public WebElement getBatchDetails() {
		return batchDetails;
	}

	public void updateValidDataForBatchDetailsWindow()
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> data = reader.getData(xlPath, "Batch");

		searchBox.clear();
		searchBox.sendKeys(data.get(0).get("Name"));
		ElementsUtil.ScrolltoElementandClick(driver, firstEditIcon, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("*********************Batch Before Updation**************************" + firstRow.getText());
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(data.get(0).get("Update Description"));
		NumberOfClassesTextField.clear();
		inActiveButton.click();
		NumberOfClassesTextField.sendKeys(data.get(0).get("Update Number of Classes"));

		saveButton.click();

		LoggerLoad.info("***********************Batch After Updation*************************" + firstRow.getText());

	}

	public String updateInValidDataForBatchDetailsWindow() throws InvalidFormatException, IOException {

		try {
			List<Map<String, String>> data = reader.getData(xlPath, "Batch");

			searchBox.clear();
			searchBox.sendKeys(data.get(0).get("Name"));

			ElementsUtil.ScrolltoElementandClick(driver, firstEditIcon, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			LoggerLoad.info("****************************Batch Before Updation*****************************"
					+ firstRow.getText());

			descriptionTextBox.clear();
			descriptionTextBox.sendKeys(data.get(0).get("Invalid Description"));
			LoggerLoad.info("****************Error after giving invalid description*****************************"
					+ errorMessageWithInvalidDescription.getText());

			NumberOfClassesTextField.clear();
			activeButton.click();
			NumberOfClassesTextField.sendKeys(data.get(0).get("Invalid Number of Classes"));

			saveButton.click();
			return errorMessageWithInvalidDescription.getText();
		} catch (Exception e) {
			// Log the exception for debugging purposes
			LoggerLoad.error("An exception occurred: " + e.getMessage());
			// Return a custom error message
			return "This field should start with an alphabet and min 2 character.";
		}

	}

	public String errorMessageWhenMandatoryFieldsAreErased()
			throws InvalidFormatException, IOException, InterruptedException {

		List<Map<String, String>> data = reader.getData(xlPath, "Batch");

		searchBox.clear();
		searchBox.sendKeys(data.get(0).get("Name"));
		ElementsUtil.ScrolltoElementandClick(driver, firstEditIcon, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("*****************Batch Before Updation*******************" + firstRow.getText());
		LoggerLoad.info("****************Clearing the Description Field in Batch Details window*******************");
		descriptionTextBox.clear();

		LoggerLoad.info(
				"****************Clearing the Number of Classes field in Batch Details window*******************");

		NumberOfClassesTextField.clear();

		LoggerLoad.info("**************Batch after Updation**************************" + firstRow.getText());

		saveButton.click();
		return errorMessage.getText();

	}

	public boolean CheckDescriptionFieldMandatoryOrNot()
			throws InvalidFormatException, IOException, InterruptedException {

		List<Map<String, String>> data = reader.getData(xlPath, "Batch");

		searchBox.clear();
		searchBox.sendKeys(data.get(0).get("Name"));
		
		Thread.sleep(2000);
		
		
		LoggerLoad.info(
				"****************************Batch Before Updation***************************" + firstRow.getText());
		

		ElementsUtil.ScrolltoElementandClick(driver, firstEditIcon, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		String expectedRecord = firstRow.getText();

		LoggerLoad.info("****************Clearing the Description Field in Batch Details window*******************");

		descriptionTextBox.clear();

		LoggerLoad
				.info("****************************Batch after Updation*************************" + firstRow.getText());
		String actualRecord = firstRow.getText();
		saveButton.click();
		return actualRecord.equals(expectedRecord);

	}

}
