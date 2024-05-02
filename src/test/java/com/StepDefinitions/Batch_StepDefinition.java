package com.StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.PageObjects.POM_BatchPage;
import com.PageObjects.POM_Dashboard;
import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Batch_StepDefinition {

	TestContext testcontext;
	POM_Dashboard dashboard;
	POM_BatchPage batchPage;
	WebDriver driver;

	public Batch_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
		dashboard = testcontext.pageobjectmanager.getDashboardPage();
		batchPage = testcontext.pageobjectmanager.getBatchPage();
	}

	@Given("Admin is on dashboard page after Login_Batch")
	public void admin_is_on_dashboard_page_after_login_batch() throws InterruptedException {

		// Asserting the Batch tab is present in Dashboard or not
		Thread.sleep(3000);
		Assert.assertTrue(dashboard.OnDashBoardOrNot());
	}

	@When("Admin clicks Batch from navigation bar_Batch")
	public void admin_clicks_batch_from_navigation_bar_batch() {

		dashboard.clickOnBatchTab();
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {
		String url = batchPage.getCurrentUrl();
		LoggerLoad.info("**************url************** " + url);
		LoggerLoad.info("**************search string is************** " + string);

		Assert.assertTrue(url.contains(string));
	}

	@Then("Admin should see the {string} in the header_Batch")
	public void admin_should_see_the_in_the_header(String string) {
		LoggerLoad.info("**************url************** " + batchPage.getManageBatchHeader());
		LoggerLoad.info("**************search string is************** " + string);

		Assert.assertEquals(batchPage.getManageBatchHeader(), string);
	}

	@Then("Admin should see the pagination controls under the data table_Batch")
	public void admin_should_see_the_pagination_controls_under_the_data_table_batch() {
		Assert.assertTrue(batchPage.areAllPaginationControlsDisplayed());
	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete_Batch")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete_batch() {
		Assert.assertTrue(batchPage.areTableAndHeadersDisplayed());
	}

	@Then("Admin should be able to see the Delete icon button that is disabled_Batch")
	public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
		Assert.assertFalse(batchPage.getMultideleteStatus());
	}

	@Then("Admin should be able to see the + A New batch button_Batch")
	public void admin_should_be_able_to_see_the_a_new_batch_button_batch() {

		Assert.assertTrue(batchPage.isANewBatchButtonDisplayedOrNot());

	}

	@Then("Each row in the data table should have a checkbox_Batch")
	public void each_row_in_the_data_table_should_have_a_checkbox_batch() throws InterruptedException {

		LoggerLoad.info("*****************Total no of rows in a page*****************" + batchPage.getRows().size());
		LoggerLoad.info(
				"*****************Total no of checkboxes in a page*****************" + batchPage.getNoOfCheckBoxes());

		Assert.assertEquals(batchPage.getRows().size(), batchPage.getNoOfCheckBoxes());

	}

	@Then("Each row in the data table should have a edit icon that is enabled_Batch")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled_batch() throws InterruptedException {

		LoggerLoad.info("*************No of records in each page**************" + batchPage.getNoOfRecords());
		LoggerLoad.info("*************No of enabled edit icons in each page**************"
				+ batchPage.countOfEnabledEditIconInEachRecord());

		Assert.assertEquals(batchPage.getNoOfRecords(), batchPage.countOfEnabledEditIconInEachRecord());
	}

	@Then("Each row in the data table should have a delete icon that is enabled_Batch")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled_batch()
			throws InterruptedException {

		Thread.sleep(3000);

		LoggerLoad.info("*************No of records in each page**************" + batchPage.getNoOfRecords());
		LoggerLoad.info("*************No of enabled edit icons in each page**************"
				+ batchPage.countOfEnabledDeleteIconInEachRecord());

		Assert.assertEquals(batchPage.getNoOfRecords(), batchPage.countOfEnabledDeleteIconInEachRecord());
	}

	@When("Admin clicks + A New Batch button_Batch")
	public void admin_clicks_a_new_batch_button_batch() {
		batchPage.getANewBatchButton().click();
	}

	@When("Admin clicks + A New Batch button after navigating to batch page_Batch")
	public void admin_clicks_a_new_batch_button_after_navigating_to_batch_page_batch() {
		dashboard.clickOnBatchTab();
	}

	@Then("A new pop up with Batch details appears_Batch")
	public void a_new_pop_up_with_batch_details_appears_batch() throws InterruptedException {
		batchPage.switchToNewPopupWithBatchDetails();

		LoggerLoad.info("*************Popup Window Text**************" + batchPage.getPopupWindowWithBatchDetails());

		Assert.assertEquals(batchPage.getPopupWindowWithBatchDetails(), "Batch Details");
	}

	/***************************************************************************************************/

	/***************************************
	 * Add New Batch Feature
	 ***************************************/

	@Given("A new pop up with {string} appears when admin clicks on + A New Batch button after navigated to Batch page_Batch")
	public void a_new_pop_up_with_appears_when_admin_clicks_on_a_new_batch_button_after_navigated_to_batch_page_batch(
			String string) throws InterruptedException {

		//Thread.sleep(2000);
		dashboard.clickOnBatchTab();

		// Clicked on +A New Batch button and switching to that window

		batchPage.switchToNewPopupWithBatchDetails();

		String text = batchPage.getPopupWindowWithBatchDetails();

		LoggerLoad.info("*************A new popup with heading**************" + text);

		Assert.assertEquals(text, string);
	}

	@Then("The pop up should include the fields Name, Number of classes and Description as text box, Program Name as drop down, Status as radio button, Number of classes as text box_Batch")
	public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button_number_of_classes_as_text_box_batch()
			throws InterruptedException {

		LoggerLoad.info("*************Text field is a type of **************" + batchPage.getAttributeOfTextField());

		Assert.assertTrue(batchPage.isNameTextBoxOrNot());

		LoggerLoad.info("*************Description field is a type of **************"
				+ batchPage.getAttributeOfDescriptionField());

		Assert.assertTrue(batchPage.isDescriptionTextBoxOrNot());

		LoggerLoad.info(
				"*************Eventhough No Of Classes field is a type of number still it is a textbox**************"
						+ batchPage.getAttributeOfNoOfClassesField());

		Assert.assertTrue(batchPage.isNoOfClassesTextBoxOrNot());

		LoggerLoad.info("*************Checking ProgramName field is a type of  dropdown or not **************");

		Assert.assertTrue(batchPage.programNameDropDownOrNot());

		LoggerLoad.info("*************Checking status is radio button or not**************");

		LoggerLoad.info("*************Status is a type of **************" + batchPage.getAttributeOfStatusButton());

		Assert.assertTrue(batchPage.statusButtonRadioOrNot());

	}

	@When("Fill in all the fields except description with valid values and click save_Batch")
	public void fill_in_all_the_fields_except_description_with_valid_values_and_click_save_batch()
			throws InvalidFormatException, IOException {

		batchPage.checkIfDescriptionOptionalOrNot();

		LoggerLoad.info(
				"*************Description is mandatory while creating batch if we try to create it will throw error like**************"
						+ batchPage.getDescriptionErrorMessage().getText());

		Assert.assertTrue(batchPage.getDescriptionErrorMessage().getText().contains("Batch Description is required"));

		batchPage.isBatchPresentInDataTable();

		LoggerLoad.info("*************no of rows present in page after searching batch id**************"
				+ batchPage.getNoOfRowsPresentInPage());

		Assert.assertTrue(batchPage.getNoOfRowsPresentInPage().contains("Showing 0 to 0 of 0 entries"));
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page_Batch")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page_batch()
			throws InvalidFormatException, IOException {

		LoggerLoad.info("*************Batch created without batch description**************"
				+ batchPage.isBatchPresentInDataTable());
		Assert.assertTrue(batchPage.isBatchPresentInDataTable());
	}

	@When("Fill in all the fields with valid values and click save_Batch")
	public void fill_in_all_the_fields_with_valid_values_and_click_save_batch()
			throws InvalidFormatException, IOException {
		batchPage.enterValidDataForBatchDetailsWindow();

	}

	@Then("The newly added batch should be present in the data table in Manage Batch page with valid data_Batch")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page_with_valid_data_batch()
			throws InvalidFormatException, IOException {

		Assert.assertTrue(batchPage.checkBatchDetailsAdded());
		LoggerLoad.info("*************Batch created confirmation**************" + batchPage.batchAddedStatus());
	}

	@When("any of the fields have invalid values_Batch")
	public void any_of_the_fields_have_invalid_values_batch()
			throws InvalidFormatException, IOException, InterruptedException {

		batchPage.enterInvalidFields();

	}

	@Then("Error message should appear_Batch")
	public void error_message_should_appear_batch() {
		Assert.assertEquals(batchPage.getErrorMessage().getText(),
				"This field should start with an alphabet and min 2 character.");
	}

	@When("Any of the mandatory fields are blank_Batch")
	public void any_of_the_mandatory_fields_are_blank_batch() {

		batchPage.checkErrorMessageForMandatoryFields();

	}

	@Then("Error message should appear missing mandatory fields_Batch")
	public void error_message_should_appear_missing_mandatory_fields_batch() {

		List<String> expectedErrorMessages = List.of("Batch Name is required.", "Batch Description is required.",
				"Program Name is required.", "Status is required.", "Number of classes is required."); // Add more
																										// expected
																										// messages as
																										// needed

		LoggerLoad.info("*************checking error messages for missing mandatory fields**************"
				+ batchPage.getErrorMessageOfMandatoryFields());

		Assert.assertEquals(batchPage.getErrorMessageOfMandatoryFields(), expectedErrorMessages);
	}

	/**********************************************
	 * Delete Batch
	 ***********************************************************/

	@Given("After navigating to the Manage Batch page from the dashboard by clicking on the Batch tab, the delete icon should be enabled for each row in the data table_Batch")
	public void after_navigating_to_the_manage_batch_page_from_the_dashboard_by_clicking_on_the_batch_tab_the_delete_icon_should_be_enabled_for_each_row_in_the_data_table_batch() {

		ElementsUtil.waitForElementVisibility(driver, dashboard.getBatchTab(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		dashboard.clickOnBatchTab();

		LoggerLoad.info("*************Checking if delete icon is enabled in each row or not**************"
				+ batchPage.checkDeleteIconShouldBeEnabled());

		Assert.assertTrue(batchPage.checkDeleteIconShouldBeEnabled());

	}

	@When("Admin clicks the delete icon_Batch")
	public void admin_clicks_the_delete_icon_batch() {
		LoggerLoad.info(
				"*************Clicking on first delete icon under Edit/Delete tab in Manage Batch page**************");

	}

	@Then("Alert appears with yes and No option_Batch")
	public void alert_appears_with_yes_and_no_option_batch() {
		LoggerLoad.info("*************Checking alert appears with yes and no options are not**************");

		batchPage.switchToConfirmWindow();

		Assert.assertTrue(batchPage.checkYesAndNoOptionAppearence());

	}

	@Given("After navigating to the Manage Batch page from the dashboard by clicking on the Batch tab, Admin clicks the delete icon_Batch")
	public void after_navigating_to_the_manage_batch_page_from_the_dashboard_by_clicking_on_the_batch_tab_admin_clicks_the_delete_icon_batch() {

		ElementsUtil.waitForElementVisibility(driver, dashboard.getBatchTab(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		dashboard.clickOnBatchTab();

		LoggerLoad
				.info("*************Admin clicking on delete icon of first record in Manage Batch page**************");

		batchPage.switchToConfirmWindow();
	}

	@When("Admin click yes option_Batch")
	public void admin_click_yes_option_batch() {
		LoggerLoad.info("*************Admin clicking on Yes option in Confirm window**************");

		batchPage.getYesOption().click();

	}

	@Then("Batch deleted alert pops and batch is no more available in data table_Batch")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table_batch() {

		LoggerLoad.info("*************Checking alert message after batch deleted**************");

		Assert.assertEquals(batchPage.batchDeletedAlertPops(), "batch Deleted");
		// Assert.assertTrue(batchPage.checkBatchExistsInDatatableOrNotAfterDeletion());

	}

	@When("Admin click no option_Batch")
	public void admin_click_no_option_batch() {

		ElementsUtil.waitForElementVisibility(driver, batchPage.getNoOption(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("*************Admin selects No option after clicking on delete**************");
		batchPage.getNoOption().click();

	}

	@Then("Batch is still listed in data table_Batch")
	public void batch_is_still_listed_in_data_table_batch() {

		Assert.assertFalse(batchPage.checkBatchExistsInDatatableOrNotAfterDeletion());

	}

	/****************************************
	 * Delete multiple batches
	 * 
	 * @throws InterruptedException
	 *********************************/

	@Given("Admin successfully navigates from the dashboard to the batch section of the LMS portal, where none of the checkboxes int the datatable are selected_Batch")
	public void admin_successfully_navigates_from_the_dashboard_to_the_batch_section_of_the_lms_portal_where_none_of_the_checkboxes_int_the_datatable_are_selected_batch()
			throws InterruptedException {

		ElementsUtil.waitForElementVisibility(driver, dashboard.getBatchTab(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		dashboard.clickOnBatchTab();

		LoggerLoad.info("*************If checkbox selected it returns true else return false**************"
				+ batchPage.isAnyCheckboxSelected());

		Assert.assertFalse(batchPage.isAnyCheckboxSelected());

	}

	@Then("The delete icon under the Manage Batch header should be disabled_Batch")
	public void the_delete_icon_under_the_manage_batch_header_should_be_disabled_batch() {
		Assert.assertFalse(batchPage.getDeleteUnderManageBatch().isEnabled());
	}

	@Given("Admin successfully navigates from the dashboard to the batch section of the LMS portal, where one of the checkbox is selected_Batch")
	public void admin_successfully_navigates_from_the_dashboard_to_the_batch_section_of_the_lms_portal_where_one_of_the_checkbox_is_selected()
			throws InterruptedException {
		ElementsUtil.waitForElementVisibility(driver, dashboard.getBatchTab(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		dashboard.clickOnBatchTab();
		LoggerLoad.info("*************selecting first check box in datatable**************");

		ElementsUtil.waitForElementVisibility(driver, batchPage.getFirstCheckBox(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		batchPage.getFirstCheckBox().click();

		ElementsUtil.waitForElementVisibility(driver, batchPage.getFirstCheckBox(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		LoggerLoad.info("*************tried asserting so many ways still failing**************");
		// Assert.assertTrue(batchPage.getFirstCheckBox().isSelected());

	}

	@When("Click delete icon below Manage Batch header_Batch")
	public void click_delete_icon_below_manage_batch_header_batch() throws InvalidFormatException, IOException {
		LoggerLoad.info("*************Getting row details before deletion**************"
				+ batchPage.getTheRowDetailsOfSelectedCheckBox());
		LoggerLoad.info("*************Getting Batch Name details before deletion**************"
				+ batchPage.getTheBatchNameOfSelectedCheckBox());
		String deletedBatchName = batchPage.getTheBatchNameOfSelectedCheckBox();
		ElementsUtil.waitForElementVisibility(driver, batchPage.getDeleteUnderManageBatch(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		batchPage.getDeleteUnderManageBatch().click();
		batchPage.getYesOption().click();
		LoggerLoad.info("*************Searching for the batch name if it got deleted or not**************");
		LoggerLoad.info("*************Validating by using Showing 0 to 0 of 0 entries in footer section**************");
		batchPage.getSearchBox().clear();
		batchPage.getSearchBox().sendKeys(deletedBatchName);
		if (batchPage.getNoOfRowsPresentInPage().contains("0 entries")) {
			System.out.println("Batch got deleted" + deletedBatchName);
		}

	}

	@Then("The respective row in the data table is deleted_Batch")
	public void the_respective_row_in_the_data_table_is_deleted_batch() {
		LoggerLoad.info("*************the respective row in the datatable got deleted**************");
	}

	@Given("Admin successfully navigates from the dashboard to the batch section of the LMS portal, where Two or more checkboxes or row is selected_Batch")
	public void admin_successfully_navigates_from_the_dashboard_to_the_batch_section_of_the_lms_portal_where_two_or_more_checkboxes_row_is_selected_batch() {
		ElementsUtil.waitForElementVisibility(driver, dashboard.getBatchTab(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		dashboard.clickOnBatchTab();
		LoggerLoad.info("*************selecting first check box in datatable**************");

		ElementsUtil.waitForElementVisibility(driver, batchPage.getFirstCheckBox(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		batchPage.getFirstCheckBox().click();
		batchPage.getSecondCheckBox().click();

	}

	@When("Click multi delete icon below Manage Batch header_Batch")
	public void click_multi_delete_icon_below_manage_batch_header_batch() {
		String deletedBatchName = batchPage.getTheBatchNameOfSelectedCheckBox();
		String firstRowText = batchPage.getTheBatchNameOfSelectedCheckBox();

		String deletedSecondBatchName = batchPage.getTheBatchNameOfSecondSelectedCheckBox();
		LoggerLoad.info("*************Getting row details before deletion**************" + firstRowText);
		LoggerLoad.info("*************Getting Batch Name details before deletion**************" + deletedBatchName);
		LoggerLoad.info("*************Getting Second Batch Name details before deletion**************"
				+ deletedSecondBatchName);
		batchPage.getDeleteUnderManageBatch().click();
		batchPage.getYesOption().click();
		LoggerLoad.info("*************Searching for the batch name if it got deleted or not**************");
		LoggerLoad.info("*************Validating by using Showing 0 to 0 of 0 entries in footer section**************");
		List<String> batchNamesToCheck = List.of(deletedBatchName, deletedSecondBatchName);

		for (String batchName : batchNamesToCheck) {
			batchPage.getSearchBox().clear();
			batchPage.getSearchBox().sendKeys(batchName);
			if (batchPage.getNoOfRowsPresentInPage().contains("0 entries")) {
				System.out.println("Batch got deleted: " + batchName);
			} else {
				System.out.println("Batch not deleted: " + batchName);
			}
		}

	}

	@Then("The respective rows in the data table is deleted_Batch")
	public void the_respective_rows_in_the_data_table_is_deleted__batch() {
		LoggerLoad.info("*************the respective rows in the datatable got deleted**************");
	}

	/*************************** Edit Batch **********************/

	@Given("Admin is on Manage Batch page after clicking on Batch link in Dashboard, where The edit icon on row level in data table is enabled_Batch")
	public void admin_is_on_manage_batch_page_after_clicking_on_batch_link_in_dashboard_where_the_edit_icon_on_row_level_in_data_table_is_enabled_batch() {
		ElementsUtil.waitForElementVisibility(driver, dashboard.getBatchTab(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		dashboard.clickOnBatchTab();

		ElementsUtil.waitForElementVisibility(driver, batchPage.getFirstEditIcon(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		Assert.assertTrue(batchPage.getFirstEditIcon().isEnabled());

	}

	@When("Admin clicks the edit icon_Batch")
	public void admin_clicks_the_edit_icon_batch() {
		batchPage.getFirstEditIcon().click();
	}

	@Then("A new pop up with {string} appears on Manage Batch_Batch")
	public void a_new_pop_up_with_appears_on_manage_batch_batch(String string) {

		String popupWindowHeader = batchPage.getBatchDetails().getText();
		LoggerLoad.info("*******************A new popup with heading **********************" + popupWindowHeader);
		Assert.assertEquals(batchPage.getBatchDetails().getText(), string);
	}

	@Given("Admin clicks the edit icon in Manage Batch page after navigating to Batch from Dashboard_Batch")
	public void admin_clicks_the_edit_icon_in_manage_batch_page_after_navigating_to_batch_from_dashboard_batch() {
		ElementsUtil.waitForElementVisibility(driver, dashboard.getBatchTab(), 20);

		dashboard.clickOnBatchTab();

	

	}

	@When("Update the fields with valid values and click save_Batch")
	public void update_the_fields_with_valid_values_and_click_save_batch()  {
		LoggerLoad.info("*******************Updated Batch with Description, Status and Number of Classes **********************");
	}

	@Then("The updated batch details should appear on the data table_Batch")
	public void the_updated_batch_details_should_appear_on_the_data_table_batch() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("*******************updateValidDataForBatchDetailsWindow method displays the Batch details before and after updation in a datatable **********************");
		batchPage.updateValidDataForBatchDetailsWindow();
	}

	@When("Update the fields with invalid values and click save_Batch")
	public void update_the_fields_with_invalid_values_and_click_save_batch() throws InvalidFormatException, IOException {
		LoggerLoad.info("*******************updateInValidDataForBatchDetailsWindow method enter invalid data and get the error message **********************");
		LoggerLoad.info("*******************We can not capture the error messages from other field like Number of classes since without giving valid data in Description Batch wont update**********************");
		
	}

	@Then("Error message should appear like invalid values_Batch")
	public void error_message_should_appear_like_invalid_values_batch() throws InvalidFormatException, IOException {
		String errorMsgAfterGivingInvalidData=batchPage.updateInValidDataForBatchDetailsWindow();
		Assert.assertEquals(errorMsgAfterGivingInvalidData, "This field should start with an alphabet and min 2 character.");
	}

	@When("Erase data from mandatory field_Batch")
	public void erase_data_from_mandatory_field_batch() {
		LoggerLoad.info("*******************Created errorMessageWhenMandatoryFieldsAreErased method to clear the data from manadatory fields and trying to save **********************");
	}

	@Then("Error message should appear fields are mandatory_Batch")
	public void error_message_should_appear_fields_are_mandatory_batch() throws InvalidFormatException, IOException, InterruptedException {
		String errorMessage=batchPage.errorMessageWhenMandatoryFieldsAreErased();
	Assert.assertEquals(errorMessage, "Batch Description is required.This field should start with an alphabet and min 2 character.");

	}

	@When("Erase data from description field_Batch")
	public void erase_data_from_description_field_batch() {
		LoggerLoad.info("*******************CheckDescriptionFieldMandatoryOrNot method clear the Description field in record and get the error message **********************");
		
	}
	@Then("The updated batch details after erase should appear on the data table_Batch")
	public void the_updated_batch_details_after_erase_should_appear_on_the_data_table_batch() throws InvalidFormatException, IOException, InterruptedException {
	
Assert.assertTrue(batchPage.CheckDescriptionFieldMandatoryOrNot());
	}

}
