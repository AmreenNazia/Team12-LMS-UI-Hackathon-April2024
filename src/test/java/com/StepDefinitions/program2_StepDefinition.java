package com.StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_ProgramPage;
import com.Utilities.ExcelReader;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class program2_StepDefinition {

	TestContext testcontext;
	POM_ProgramPage programpage;
	POM_LoginPage loginpage;
	POM_Dashboard dashboardpage;

	public program2_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
		loginpage = testcontext.pageobjectmanager.getLoginPage();
		programpage = testcontext.pageobjectmanager.getProgramPage();

		dashboardpage = testcontext.pageobjectmanager.getDashboardPage();

	}

	@Given("Admin is on Manage Program Page for program")
	public void admin_is_on_manage_program_page_for_program() {

		dashboardpage.clickOnProgramTab();
	}

	@When("Admin clicks A New Program button for program")
	public void admin_clicks_a_new_program_button_for_program() {

		programpage.clickonNewProgram();
	}

	@Then("Admin should see a popup open for Program details with empty form along with SAVE and CANCEL button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window()
			throws InterruptedException {
		Assert.assertTrue(programpage.displayonpopUpHader());
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window for program")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window_for_program() {
		programpage.getoninputTextFields();

	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		Assert.assertTrue(programpage.isstatusVisible());
	}

	@Given("Admin is on Program Details Popup window for program")
	public void admin_is_on_program_details_popup_window_for_program() {

		programpage.clickonNewProgram();
	}

	@When("Admin clicks Save button without entering any data for program")
	public void admin_clicks_save_button_without_entering_any_data_for_program() {
		programpage.clickonsave();
	}

	@Then("Admin gets a Error message alert for program")
	public void admin_gets_a_error_message_alert_for_program() {
		Assert.assertTrue(programpage.isErrorMessageDisplayed());

	}

	@When("Admin enters only Program Name  in text box  using sheetname {string} and RowNumber {int} and clicks Save button for program")
	public void admin_enters_only_program_name_in_text_box_using_sheetname_and_row_number_and_clicks_save_button_for_program(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		WebDriverWait wait;
		List<Map<String, String>> testdata = reader.getData(System.getProperty("user.dir")+
				"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",SheetName
				);

		String programName = testdata.get(RowNumber).get("programName");


		programpage.fillprogramname(programName);
    
		       
	}

	@Then("Admin gets a message alert {string} for program")
	public void admin_gets_a_message_alert_for_program(String string) {
		Assert.assertTrue(programpage.isErrorMessageDisplayed());

	}

	@When("Admin enters only Program description in text box using sheetname {string} and RowNumber {int} and clicks Save button for program")
	public void admin_enters_only_program_description_in_text_box_using_sheetname_and_row_number_and_clicks_save_button_for_program(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		WebDriverWait wait;
		List<Map<String, String>> testdata = reader.getData(
				System.getProperty("user.dir")+
				"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",SheetName);

		// String programName = testdata.get(RowNumber).get("invalidprogramName");
		String programDescription = testdata.get(RowNumber).get("programDescription");

		programpage.fillprogramdescription(programDescription);


	}

	@When("Admin selects only Status and clicks Save button for program")
	public void admin_selects_only_status_and_clicks_save_button_for_program() {
		programpage.clickonActiveStatus();
		programpage.clickonsave();
	}

	@When("Admin enters only numbers or special char in name and desc column using sheetname {string} and RowNumber {int}  for program")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_using_sheetname_and_row_number_for_program(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {

		ExcelReader reader = new ExcelReader();
		WebDriverWait wait;

		List<Map<String, String>> testdata = reader.getData(
				System.getProperty("user.dir")+
					"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",SheetName);

		String programName = testdata.get(RowNumber).get("invalidprogramName");
		String programDescription = testdata.get(RowNumber).get("invalidprogramDescription");

		programpage.fillprogramForm(programName, programDescription);

	}

	@When("Admin clicks adddetails using sheetname {string} and RowNumber {int} Cancel\\/Close\\(X) Icon on Program Details form for program")
	public void admin_clicks_adddetails_using_sheetname_and_row_number_cancel_close_x_icon_on_program_details_form_for_program(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				System.getProperty("user.dir")+	"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",SheetName);


		String programName = testdata.get(RowNumber).get("EditprogramName");
		String programDescription = testdata.get(RowNumber).get("EditprogramDescription");

		programpage.fillprogramforcancel(programName, programDescription);
	}

	@Then("Program Details popup window should be closed without saving for program")
	public void program_details_popup_window_should_be_closed_without_saving_for_program() {

	}

	@When("Enter all the required fields with valid values  using sheetname {string} and RowNumber {int} and click Save button for program")
	public void enter_all_the_required_fields_with_valid_values_using_sheetname_and_row_number_and_click_save_button_for_program(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {

		ExcelReader reader = new ExcelReader();
		WebDriverWait wait;
		List<Map<String, String>> testdata = reader.getData(
				System.getProperty("user.dir")+	"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",SheetName);

		String programName = testdata.get(RowNumber).get("programName");
		String programDescription = testdata.get(RowNumber).get("programDescription");

		programpage.fillprogramForm(programName, programDescription);

	}


	@Then("Admin gets a message {string} alert and able to see the new program added in the data table for program")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table_for_program(
			String string) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(dashboardpage.isSuccessMessageDisplayed(), string);
		
	}

	@When("Admin add programdetails using sheetname {string} and RowNumber {int} and clicks <Cancel>button  for program")
	public void admin_add_programdetails_using_sheetname_and_row_number_and_clicks_cancel_button_for_program(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		WebDriverWait wait;
		List<Map<String, String>> testdata = reader.getData(
				System.getProperty("user.dir")+	"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",SheetName);

		String programName = testdata.get(RowNumber).get("EditprogramName");
		String programDescription = testdata.get(RowNumber).get("EditprogramDescription");

		programpage.fillprogramforcancel(programName, programDescription);
	}

	@Then("Admin can see the Program details popup disappears without creating any program for program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program_for_program() {

	}

}
