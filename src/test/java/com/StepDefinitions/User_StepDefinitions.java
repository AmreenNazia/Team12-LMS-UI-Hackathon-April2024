 package com.StepDefinitions;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserPage;
import com.Utilities.Constant;
import com.Utilities.ExcelReader;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User_StepDefinitions {
	TestContext testcontext;
	POM_UserPage userpage;
	POM_LoginPage loginpage;

	public User_StepDefinitions(TestContext testcontext) {

		this.testcontext = testcontext;
		loginpage = testcontext.pageobjectmanager.getlogin();
		userpage = testcontext.pageobjectmanager.getuser();

	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		Assert.assertEquals(loginpage.getDashBoardTitle(), Constant.HOME_PAGE_TITLE);
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String text) {
		if (userpage.getUser().equals(text))
			userpage.click_User();
 
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String text) {
		LoggerLoad.info("Validate landing in User page");
		String url = userpage.getUrl();
		Assert.assertTrue(url.contains(text));

	}

	// **Scenario 2**//

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String text) {
		LoggerLoad.info("Validate the heading");
		String manageUser = userpage.getManageuser();
		Assert.assertEquals(manageUser, text);
	}

	// **Scenario 3 **//
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table() {
		LoggerLoad.info("Validate the text and pagination icon below the data table");
		userpage.getpagination();
	}

	// **Scenario 4 **//
	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() {
		LoggerLoad.info("Validate data table headers in the User Page");
		String data = "ID Name Location Phone Number Edit / Delete";
		String header = userpage.getcolumnHeaders();
		Assert.assertEquals(header, data);
	}

	// **Scenario 5 **//
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		LoggerLoad.info("Validating the default state of Delete button");
		Assert.assertTrue(userpage.getDelete().isDisplayed());
		Assert.assertFalse(userpage.getDelete().isEnabled());
	}

	// **Scenario 6 **//
	@Then("Admin should be able to see the {string} button above the data table")
	public void admin_should_be_able_to_see_the_button_above_the_data_table(String user) {
		LoggerLoad.info("Validate Add New user button in User Page");
		String text = userpage.getaNewUser();
		Assert.assertEquals(text, user);
	}

	// **Scenario 7**//
	@Then("Admin should be able to see the {string} button above  data table")
	public void admin_should_be_able_to_see_the_button_above_data_table(String assignstaff) {
		LoggerLoad.info("Validate Add New user button in User Page");
		String staff = userpage.getAssignStaff();
		Assert.assertEquals(staff, assignstaff);
	}

	// **Scenario 8**//
	@Then("Admin should be able to see {string} button above the data table")
	public void admin_should_be_able_to_see_button_above_the_data_table(String assignStudent) {
		LoggerLoad.info("Validate Assign Student  button in User page");
		String student = userpage.getAssignStudent();
		Assert.assertEquals(student, assignStudent);
	}

	// **Scenario 9**//
	@Then("Admin should be able to see the search text box above the data table")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
		LoggerLoad.info("Validate search box in User page");
		Assert.assertTrue(userpage.getSearch().isDisplayed());
	}

	// **Scenario 10**//
	@Then("Admin should see two records displayed on the data table")
	public void admin_should_see_two_records_displayed_on_the_data_table() {
		LoggerLoad.info("Validate number of data rows in the data ");
		int rows = userpage.sizeofRows();
		Assert.assertTrue(rows >= 2);
	}

	// Scenario 11**//
	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		LoggerLoad.info("Each row in the data table should have a checkbox");
		long count = userpage.getCheckBoxes();
		System.out.println(count);
		Assert.assertEquals(userpage.getCheckBoxes(), userpage.getRows().size());

	}

	// Scenario 12**//
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		LoggerLoad.info("Each row in the data table should have a edit icon that is enabled");
		Assert.assertEquals(userpage.getcount_edit(), userpage.geteditdeleteRows().size());
	}

	// Scenario 13 **//
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		LoggerLoad.info("Each row in the data table should have a delete icon that is enabled");
		Assert.assertEquals(userpage.getCount_Delete(), userpage.geteditdeleteRows().size());

	}

	// Scenario 14**//
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		userpage.click_User();
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}

	@When("Admin enters user name into search box.")
	public void admin_enters_user_name_into_search_box() {
		userpage.EnterUsername();
	}

	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() {
		LoggerLoad.info("search user by name");
		Assert.assertTrue(userpage.searchedRow_count() == 1);

	}

	// **Scenario 15**//
	@When("Admin enters the {string} not present in the data table on the Search box")
	public void admin_enters_the_not_present_in_the_data_table_on_the_search_box(String name)
			throws InterruptedException {
		userpage.SearchwithNoName(name);
	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {
		LoggerLoad.info("Validating the Search with unrelated keyword");
		Assert.assertTrue(userpage.searchedRow_count() == 0);

	}

 
	// --------------------------------Add New User----------------------------------------//


 

	// Scenario 01**//Given - scenario - 14//
	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
		Assert.assertEquals(userpage.clickonAddNewUser(), string);
		userpage.clickonAddNewUser();
	}

	@Then("Admin should see pop up open for user details")
	public void admin_should_see_pop_up_open_for_user_details() {
		LoggerLoad.info("Validate User Details Popup window");
		Assert.assertTrue(userpage.PopupDetailsUser().isDisplayed());
		// userpage.formdetails();
		Assert.assertTrue(userpage.CancelButtonisDisplayed().isDisplayed());
		Assert.assertTrue(userpage.SubmitButtonisDisplayed().isDisplayed());
		Assert.assertTrue(userpage.X_ButtonisDisplayed().isDisplayed());

	}

	// Scenario 02**//
	@Then("Admin should see  text boxes for the fields")
	public void admin_should_see_text_boxes_for_the_fields() {
		LoggerLoad.info("Validate input fields and text boxes in user details form");
		userpage.textBoxesforFields();
	}

	// Scenario 03 **//

	@Then("Admin should see drop downs for the fields")
	public void admin_should_see_drop_downs_for_the_fields() {
		LoggerLoad.info("Validate drop downs in new user form");
		userpage.dropdownFields();

	}

	// Scenario 04**//
	@Given("Admin is on  User details pop up")
	public void admin_is_on_user_details_pop_up() {
		Assert.assertEquals(loginpage.getDashBoardTitle(), Constant.HOME_PAGE_TITLE);
		userpage.click_User();
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
		userpage.clickonAddNewUser();

		// Assert.assertTrue(userpage.PopupDetailsUser().isDisplayed());

	}

	@When("Admin enters mandatory fields in the form using sheetname {string} and RowNumber {int} and Submits the form")
	public void admin_enters_mandatory_fields_in_the_form_using_sheetname_and_row_number_and_submits_the_form(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		System.out.println(SheetName);
		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				SheetName);
		String firstname = testdata.get(RowNumber).get("First Name");
		String lastname = testdata.get(RowNumber).get("Last Name");
		String phoneno = testdata.get(RowNumber).get("Phone no");
		String userrole = testdata.get(RowNumber).get("User Role");
		String rolestatus = testdata.get(RowNumber).get("Role Status");
		String visastatus = testdata.get(RowNumber).get("Visa Status");
		String location = testdata.get(RowNumber).get("Location");

		userpage.fillUserForm(firstname, lastname, phoneno, userrole, visastatus, rolestatus, location);
	}

	@Then("Admin gets message User added Successfully")
	public void admin_gets_message_user_added_successfully() {
		LoggerLoad.info("Check if user is created when only mandatory fields are entered with valid data");
		Assert.assertEquals(userpage.UserCreated(), "Successful");
		// Assert.assertEquals(userpage.getManageuser(),
		// Constant.MANAGE_USERPAGE_HEADER);
	}

	// **Scenario 05 **//
	@When("Admin enters all the fields in the form using sheetname {string} and RowNumber {int} and Submits the form")
	public void admin_enters_all_the_fields_in_the_form_using_sheetname_and_row_number_and_submits_the_form(
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String firstname = testdata.get(RowNumber).get("First Name");
		String lastname = testdata.get(RowNumber).get("Last Name");
		String phoneno = testdata.get(RowNumber).get("Phone no");
		String userrole = testdata.get(RowNumber).get("User Role");
		String rolestatus = testdata.get(RowNumber).get("Role Status");
		String visastatus = testdata.get(RowNumber).get("Visa Status");
		String location = testdata.get(RowNumber).get("Location");
		String middlename = testdata.get(RowNumber).get("Middle Name");
		String linkedIn = testdata.get(RowNumber).get("Linked Url");
		String email = testdata.get(RowNumber).get("Email");
		String ug = testdata.get(RowNumber).get("Under Graduate");
		String pg = testdata.get(RowNumber).get("Post Graduate");
		String timezone = testdata.get(RowNumber).get("Time Zone");
		String usercomments = testdata.get(RowNumber).get("UserComments");
		userpage.fillUSerDetails(firstname, middlename, lastname, location, phoneno, linkedIn, userrole, rolestatus,
				visastatus, email, ug, pg, timezone, usercomments);
	}

	// Scenarios 06 **//
	@When("Admin skips to add value in mandatory field using sheetname {string} and RowNumber {int} and Submits the form")
	public void admin_skips_to_add_value_in_mandatory_field_using_sheetname_and_row_number_and_submits_the_form(
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String middlename = testdata.get(RowNumber).get("Middle Name");
		String linkedIn = testdata.get(RowNumber).get("Linked Url");
		String email = testdata.get(RowNumber).get("Email");
		String ug = testdata.get(RowNumber).get("Under Graduate");
		String pg = testdata.get(RowNumber).get("Post Graduate");
		String timezone = testdata.get(RowNumber).get("Time Zone");
		String usercomments = testdata.get(RowNumber).get("UserComments");
		userpage.nonMandatoryFields(middlename, linkedIn, email, ug, pg, timezone, usercomments);
	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {
		LoggerLoad.info("Check if user is created when only optional fields are entered with valid data");
		userpage.ErrorMessageunderTextboxes();
	}

	// Scenarios 07 **//
	@When("Admin enters invalid data in all of the  fields using sheetname {string} and RowNumber {int} and Submits the form")
	public void a_admin_enters_invalid_data_in_all_of_the_fields_using_sheetname_and_row_number_and_submits_the_form(
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String firstname = testdata.get(RowNumber).get("First Name");
		String lastname = testdata.get(RowNumber).get("Last Name");
		String phoneno = testdata.get(RowNumber).get("Phone no");
		String userrole = testdata.get(RowNumber).get("User Role");
		String rolestatus = testdata.get(RowNumber).get("Role Status");
		String visastatus = testdata.get(RowNumber).get("Visa Status");
		String location = testdata.get(RowNumber).get("Location");
		String middlename = testdata.get(RowNumber).get("Middle Name");
		String linkedIn = testdata.get(RowNumber).get("Linked Url");
		String email = testdata.get(RowNumber).get("Email");
		String ug = testdata.get(RowNumber).get("Under Graduate");
		String pg = testdata.get(RowNumber).get("Post Graduate");
		String timezone = testdata.get(RowNumber).get("Time Zone");
		String usercomments = testdata.get(RowNumber).get("UserComments");
		userpage.fillUSerDetails(firstname, middlename, lastname, location, phoneno, linkedIn, userrole, rolestatus,
				visastatus, email, ug, pg, timezone, usercomments);
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
		LoggerLoad.info("check if user is created when invalid data is entered in all of the fields");
		Assert.assertTrue(userpage.popupmessage().contains("Failed"));

	}

	// Scenario 08**//
	@Given("Admin is on User details pop up")
	public void admin_is_on_User_details_pop_up() {
		Assert.assertEquals(loginpage.getDashBoardTitle(), Constant.HOME_PAGE_TITLE);
		userpage.click_User();
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
		userpage.clickonAddNewUser();
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() {
		userpage.clickonSubmitButtonwithEmptyfields();
	}

	@Then("user wont be created and Admin gets error message")
	public void user_wont_be_created_and_admin_gets_error_message() {
		LoggerLoad.info("Empty form submission");
		userpage.ErrorMessageunderTextboxes();
	}

	// Scenario 09**//
	@When("Admin clicks Cancel or Close Icon on User Details form")
	public void admin_clicks_cancel_close_x_icon_on_user_details_form() {
		userpage.clickonCancel();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
		LoggerLoad.info("Validate Cancel or Close icon on User Details form");
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}

	// Scenario 10**//
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		userpage.validate_Cancel_btn();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
		LoggerLoad.info("Validate Cancel button on User Details form");
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}
	// Scenario 11**//

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_should_be_present_in_the_data_table_in_manage_user_page() throws InterruptedException {
		LoggerLoad.info("Check if the user details are added in data table");
		userpage.searchfortheuser();

	}

	// *****************************Assign Staff Scenario 01*********************//

 
	@Given("Admin is in manage user page")
	public void admin_is_in_manage_user_page() {
		userpage.click_User();
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}

	@When("Admin clicks Assign Staff button")
	public void admin_clicks_assign_staff_button() {
		userpage.click_assignstaff().click();
	}

	@Then("Admin should see a pop up open for assign staff details in the window")
	public void admin_should_see_a_pop_up_open_for_assign_staff_details_in_the_window() {
		LoggerLoad.info("Validate Assign Staff Popup window");
		userpage.assignstaff_form();
	}

	// Scenario 02 **//
	@Then("Admin should see User Role as R02,and other fields")
	public void admin_should_see_user_role_as_r02_and_other_fields() {
		LoggerLoad.info("Validate input fields and their text boxes in Assign Student form");
		userpage.validating_assignstaf_Form();
	}

	// Scenario 03**//
	@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() {
		LoggerLoad.info("Validate Dropdown in Assign Staff Form");
		userpage.validatingDropDown();
	}

	// Scenario 04**//
	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
		LoggerLoad.info("Validate radio button in Assign Staff Form");
		userpage.validating_radioButtons();
	}

	// Scenario 05 **//
	@Given("Admin is in Assign Staff details pop up page")
	public void admin_is_in_assign_staff_details_pop_up_page() {
		userpage.click_User();
		userpage.click_assignstaff().click();
	}

	@When("Admin clicks Save button without entering any data")
	public void admin_clicks_button_with_entering_any_data() {
		userpage.CLick_SaveButton();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		LoggerLoad.info(" Empty Form Submission");
		Assert.assertTrue(userpage.errorMessage_displayed().isDisplayed());
	}

	// Scenario 06**//

	@When("Admin clicks Save button with entering any data using sheetname {string} and rowNumber {int}")
	public void admin_clicks_save_button_with_entering_any_data_using_sheetname_and_row_number(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String skill = testdata.get(rowNumber).get("Skill");
		String programname = testdata.get(rowNumber).get("Program Name");
		String batchname = testdata.get(rowNumber).get("Batch Name");
		userpage.fillAssignStudent(skill, programname, batchname);
	}

	@Then("Admin gets a Error message alert as {string}")
	public void admin_gets_a_error_message_alert_as(String skillRequired) throws InterruptedException {
		LoggerLoad.info("Validate the Assign Staff form page without giving Student Email id");
		userpage.validate_SkillerrorMessage(skillRequired);
	}

	// Scenario 07**//
	@When("Admin clicks Save button without entering Skill data using sheetname {string} and rowNumber {int}")
	public void admin_clicks_save_button_without_entering_skill_data_using_sheetname_and_row_number(String sheetName,
			Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String emailid = testdata.get(RowNumber).get("Staff Email Id");
		String programname = testdata.get(RowNumber).get("Program Name");
		String batchname = testdata.get(RowNumber).get("Batch Name");
		userpage.fillwithoutSkill(emailid, programname, batchname);
	}

	@Then("Admin gets a Error message alert {string}")
	public void admin_gets_a_error_message_alert(String skillisRequired) throws InterruptedException {
		LoggerLoad.info("Validate the Assign Staff form page ");
		userpage.validate_SkillerrorMessage(skillisRequired);
	}

	// Scenario 09**//
	@When("Admin clicks Save button without selecting program using sheetname {string} and rowNumber {int}")
	public void admin_clicks_save_button_without_selecting_program_using_sheetname_and_row_number(String sheetName,
			Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData("/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String emailid = testdata.get(RowNumber).get("Staff Email Id");
		String skill = testdata.get(RowNumber).get("Skill");
		String batchname = testdata.get(RowNumber).get("Batch Name");
		userpage.fillwithoutprogram(emailid, skill, batchname);
	}

	// Scenario 10**//
	@When("Admin clicks Save button without selecting batch using sheetname {string} and rowNumber {int}")
	public void admin_clicks_save_button_without_selecting_batch_using_sheetname_and_row_number(String sheetName,
			Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String emailid = testdata.get(RowNumber).get("Staff Email Id");
		String skill = testdata.get(RowNumber).get("Skill");
		String programname = testdata.get(RowNumber).get("Program Name");
		userpage.fillwithoutbatch(emailid, skill, programname);
	}

	// Scenario 11**//
	@When("Admin clicks Save button without giving status using sheetname {string} and rowNumber {int}")
	public void admin_clicks_save_button_without_giving_status_using_sheetname_and_row_number(String sheetName,
			Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String emailid = testdata.get(RowNumber).get("Staff Email Id");
		String skill = testdata.get(RowNumber).get("Skill");
		String programname = testdata.get(RowNumber).get("Program Name");
		String batchname = testdata.get(RowNumber).get("Batch Name");
		userpage.fillwithoutstatus(emailid, skill, programname, batchname);
	}

	// Scenario 12**//
	@When("Admin clicks Cancel or Close Icon on Assign Staff form")
	public void admin_clicks_cancel_or_close_icon_on_assign_staff_form() {

		userpage.validate_close_AssignStaff();
	}

	@Then("Assign Staff popup window should be closed without saving")
	public void assign_staff_popup_window_should_be_closed_without_saving() {
		LoggerLoad.info("Validate Cancel or Close icon on Assign Staff form");
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}

	// Scenario 13**//
	@When("Enter all the required fields with valid values and click Save button using sheetname {string} and rowNumber {int}")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button_using_sheetname_and_row_number(
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(
				"/Users/amreennaziasyed/eclipse-workspace/DSALGO/Team12_XpathWarriors_LMS_UI_Apr2024/src/test/resources/TestData/Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",
				sheetName);
		String emailid = testdata.get(RowNumber).get("Staff Email Id");
		String skill = testdata.get(RowNumber).get("Skill");
		String programname = testdata.get(RowNumber).get("Program Name");
		String batchname = testdata.get(RowNumber).get("Batch Name");
		userpage.fillwithalldetails(emailid, skill, programname, batchname);
	}

	@Then("Admin gets a message alert as {string}")
	public void admin_gets_a_message_alert_as(String string) {
		LoggerLoad.info("Validate Save button on Assign Staff form");
		Assert.assertTrue(userpage.validate_assignedStaff().contains(string));
	}

	// Scenario 14**//
	@When("Admin clicks on Cancel button")
	public void admin_clicks_on_cancel_button() {
		userpage.validate_Cancel_AssignStaff();
	}

	@Then("Admin can see the Assign Staff popup disappears without assigning")
	public void admin_can_see_the_assign_staff_popup_disappears_without_assigning() {
		LoggerLoad.info("Validate Cancel button on Assign Staff form");
		Assert.assertEquals(userpage.getManageuser(), Constant.MANAGE_USERPAGE_HEADER);
	}
	
	/************************** Sort User
	 * @throws InterruptedException **************************************/
	@When("Admin clicks on ID sort icon")
	public void admin_clicks_on_id_sort_icon() throws InterruptedException {
	    userpage.click_sortId();
	}

	@Then("Admin should see User details are sorted by id")
	public void admin_should_see_user_details_are_sorted_by_id() {
	    userpage.SortAscendingOrder(userpage.getSortingUserId());
	}

	@When("Admin clicks on name sort icon")
	public void admin_clicks_on_name_sort_icon() throws InterruptedException {
	     userpage.click_sortUserName();
	}

	@Then("Admin should see User details are sorted by name")
	public void admin_should_see_user_details_are_sorted_by_name() {
		userpage.SortAscendingOrder(userpage.getSortingUserName());
	}

	@When("Admin clicks on Location sort icon")
	public void admin_clicks_on_location_sort_icon() throws InterruptedException {
	    userpage.click_sortUserLocation();
	}

	@Then("Admin should see User details are sorted by Location")
	public void admin_should_see_user_details_are_sorted_by_location() {
		userpage.SortAscendingOrder(userpage.getSortingUserLocation());
	}

	@When("Admin clicks on Phone number sort icon")
	public void admin_clicks_on_phone_number_sort_icon() throws InterruptedException {
	  userpage.click_sortUserphonenum();
	}

	@Then("Admin should see User details are sorted by Phone number")
	public void admin_should_see_user_details_are_sorted_by_phone_number() {
		userpage.sortAscendingOrderInteger(userpage.getSortingUserPhoneNumber());
	}


}
