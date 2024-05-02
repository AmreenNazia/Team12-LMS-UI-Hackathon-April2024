package com.StepDefinitions;

import com.PageObjects.POM_UserAssignStudent;
import com.PageObjects.POM_LoginPage;
import com.Utilities.Constant;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import io.cucumber.java.en.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAssignStudent_Steps {

	POM_UserAssignStudent userAssignStudent;
	TestContext testcontext;
	POM_LoginPage loginpage;

	// Validate landing in User Page

	public UserAssignStudent_Steps(TestContext testcontext) {
		this.testcontext = testcontext;
		loginpage = testcontext.getPageObjectManager().getLoginPage();
		userAssignStudent = testcontext.getPageObjectManager().getUserAssignStudentPage();
	}

	@Given("Admin is on dashboard page after login")
	public void admin_is_on_dashboard_page_after_login() {
		Assert.assertEquals(loginpage.getDashBoardTitle(), Constant.HOME_PAGE_TITLE);
	}

	@When("Admin clicks User from navigation bar")
	public void admin_clicks_from_navigation_bar() throws InterruptedException {
		userAssignStudent.clickUserButton();
		Thread.sleep(1000);

	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String text) throws InterruptedException {
		LoggerLoad.info("Validate landing in User page");
		Assert.assertEquals(userAssignStudent.getManageuser(), text);

	}

	// **Scenario 1** Validate Assign Student Popup window

	@Given("Admin is in manage user page")
	public void admin_is_in_manage_user_page() {
		userAssignStudent.clickUserButton();
		Assert.assertEquals(userAssignStudent.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);

	}

	@When("Admin clicks Assign Student button")
	public void admin_clicks_assign_student_button() throws InterruptedException {
		userAssignStudent.clickAssignStudent();
		Thread.sleep(1000);
	}

	@Then("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		Assert.assertTrue(userAssignStudent.PopUpAssignStudent().isDisplayed());
		Assert.assertTrue(userAssignStudent.verifyCloseButton());
		Assert.assertTrue(userAssignStudent.verifySaveButton());
		Assert.assertTrue(userAssignStudent.verifyCancelButton());

	}

	// Scenario 2 - Validate_AssignStudent_InputFields_TextBoxes

	@Then("Admin should see User Role as R03 and other fields Student Email id, Program Name, Batch Name and Status with respective input boxes")
	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() throws InterruptedException {
		LoggerLoad.info("Validate input fields and their text boxes in Assign Student form");
		userAssignStudent.validating_assignstudent_Form();

	}

	// Scenario 3 - Validate Dropdown in Assign Student Form

	@Then("Admin should see drop down boxes with valid data for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_data_for_student_email_id_program_name_and_batch_name() throws InterruptedException {
		LoggerLoad.info("Validate Dropdown in Assign Student Form");
		userAssignStudent.validatingDropDown();

	}

	// Scenario 4 - Validate radio button in Assign Student Form

	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
		LoggerLoad.info("Validate radio button in Assign Student Form");
		userAssignStudent.validating_RadioButtons();
	}

	// Scenario 5 - Empty Form Submission

	@Given("Admin is in Assign Student details pop up page")
	public void admin_is_in_assign_student_details_pop_up_page() {
		userAssignStudent.clickUserButton();
		userAssignStudent.clickAssignStudent();
	}

	@When("Admin clicks Save button with entering any data")
	public void admin_clicks_save_button_with_entering_any_data() {
		userAssignStudent.CLick_SaveButton();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		LoggerLoad.info("******Empty Form Submission******");
		Assert.assertTrue(userAssignStudent.errorMessage_displayed().isDisplayed());
	}

	// Scenario 10 - Validate Cancel or Close icon on Assign Student form

	@When("Admin clicks Cancel or Close Icon on Assign Student form")
	public void admin_clicks_cancel_or_close_icon_on_assign_student_form() {
		LoggerLoad.info("******Close the form******");
		userAssignStudent.validate_close_AssignStudent();
	}

	@Then("Assign Student popup window should be closed without saving")
	public void assign_student_popup_window_should_be_closed_without_saving() {
		LoggerLoad.info("Validate Cancel or Close icon on Assign Student form");
		Assert.assertEquals(userAssignStudent.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}

	// Scenario 12 - Validate Cancel button on Assign Student form
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		LoggerLoad.info("******Cancel the form******");
		userAssignStudent.validate_Cancel_AssignStudent();
	}

	@Then("Admin can see the Assign Student popup disappears without assigning")
	public void admin_can_see_the_assign_student_popup_disappears_without_assigning() {
		LoggerLoad.info("Validate Cancel button on Assign Student form");
		Assert.assertEquals(userAssignStudent.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}
	
	//Scenario - validate without student email id //
	@When("Admin clicks Save button without entering Student Email id using sheetname {string} and rowNumber {int}")
	public void admin_clicks_save_button_without_entering_student_email_id_using_sheetname_and_row_number(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(System.getProperty("user.dir")+
				"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",sheetName);
		String programname = testdata.get(RowNumber).get("Student_ProgramName");
		String batchname = testdata.get(RowNumber).get("Student_BatchName");
		 
		userAssignStudent.fillformwithoutStudentemail(programname, batchname);
	}

	@Then("Admin gets a error message alert as {string}")
	public void admin_gets_a_error_message_alert_as(String string) throws InterruptedException {
		userAssignStudent.validate_StudentError(string);
	}


@When("Admin clicks Save button without program name using sheetname {string} and rowNumber {int}")
public void admin_clicks_save_button_without_program_name_using_sheetname_and_row_number(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> testdata = reader.getData(System.getProperty("user.dir")+
			"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",sheetName);
	String emailid = testdata.get(RowNumber).get("Student_EmaiId");
	String batchname = testdata.get(RowNumber).get("Student_BatchName");
	 
	userAssignStudent.fillformwithoutprogramname(emailid, batchname);
}
@When("Admin clicks Save button without batch name using sheetname {string} and rowNumber {int}")
public void admin_clicks_save_button_without_batch_name_using_sheetname_and_row_number(String sheetName	, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> testdata = reader.getData(System.getProperty("user.dir")+
			"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",sheetName);
	String emailid = testdata.get(RowNumber).get("Student_EmaiId");
	String programname = testdata.get(RowNumber).get("Student_ProgramName");
	 
	userAssignStudent.fillformwithoutbatchname(emailid, programname);
}

@When("Admin clicks Save button without status using sheetname {string} and rowNumber {int}")
public void admin_clicks_save_button_without_status_using_sheetname_and_row_number(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> testdata = reader.getData(System.getProperty("user.dir")+
			"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",sheetName);
	String emailid = testdata.get(RowNumber).get("Student_EmaiId");
	String programname = testdata.get(RowNumber).get("Student_ProgramName");
	String batchname = testdata.get(RowNumber).get("Student_BatchName");
	
	 
	userAssignStudent.fillformwithoutstatus(emailid, programname,batchname);
}
@When("Enter all the required fields with valid values using {string} and rowNumber {int} and click Save")
public void enter_all_the_required_fields_with_valid_values_using_and_row_number_and_click_save(String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();

	List<Map<String, String>> testdata = reader.getData(System.getProperty("user.dir")+
			"/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024-2.xlsx",sheetName);
	String emailid = testdata.get(RowNumber).get("Student_EmaiId");
	String programname = testdata.get(RowNumber).get("Student_ProgramName");
	String batchname = testdata.get(RowNumber).get("Student_BatchName");
	userAssignStudent.fillformwithvalidata(emailid, programname,batchname);
}
@Then("Admin gets a message {string} alert")
public void admin_gets_a_message_alert(String string) {
	LoggerLoad.info("Validate Save button on Assign Staff form");
	Assert.assertTrue(userAssignStudent.Success_alertmessage().contains(string));
}

}
