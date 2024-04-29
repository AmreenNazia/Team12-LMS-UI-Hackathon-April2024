 package com.StepDefinitions;

import org.testng.Assert;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserPage;
import com.Utilities.Constant;
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
		loginpage = testcontext.pageobjectmanager.getLoginPage();
		userpage = testcontext.pageobjectmanager.getUserPage();

	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		  Assert.assertEquals(loginpage.getDashBoardTitle(),Constant.HOME_PAGE_TITLE);
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String text) throws InterruptedException {
	    userpage.click_User(text);

	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String text) throws InterruptedException {
		LoggerLoad.info("Validate landing in User page");
		String url = userpage.getUrl();
		Assert.assertTrue(url.contains(text));

	}

	//**Scenario 2**//

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String text) {
		LoggerLoad.info("Validate the heading");
	     String manageUser = userpage.getText();
	     Assert.assertEquals(manageUser, text);
	}

	//**Scenario 3 **//
	@Then("Admin should see the text as {string} along with Pagination icon below the table")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String pagination) {
		LoggerLoad.info("Validate the text and pagination icon below the data table");
	     userpage.getpagination(pagination);
	}

	//**Scenario 4 **//
	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() {
		LoggerLoad.info("Validate data table headers in the User Page");
		String data = "ID Name Location Phone Number Edit / Delete";
		String header = userpage.getcolumnHeaders();
		Assert.assertEquals(header, data);
	}

	//**Scenario 5 **//
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		LoggerLoad.info("Validating the default state of Delete button");
		Assert.assertTrue(userpage.delete.isDisplayed());
		Assert.assertFalse(userpage.delete.isEnabled());
	}
	//**Scenario 6 **//
	@Then("Admin should be able to see the {string} button above the data table")
	public void admin_should_be_able_to_see_the_button_above_the_data_table(String user) {
		LoggerLoad.info("Validate Add New user button in User Page");
	     String text = userpage.getaNewUser();
	     Assert.assertEquals(text, user);
	}
	//**Scenario 7**//
	@Then("Admin should be able to see the {string} button above  data table")
	public void admin_should_be_able_to_see_the_button_above_data_table(String assignstaff) {
		LoggerLoad.info("Validate Add New user button in User Page");
	    String staff = userpage.getAssignStaff();
	    Assert.assertEquals(staff, assignstaff);
	}
	//**Scenario 8**//
	@Then("Admin should be able to see {string} button above the data table")
	public void admin_should_be_able_to_see_button_above_the_data_table(String assignStudent) {
	    LoggerLoad.info("Validate Assign Student  button in User page");
	    String student = userpage.getAssignStudent();
	    Assert.assertEquals(student, assignStudent);
	}
	//**Scenario 9**//
	@Then("Admin should be able to see the search text box above the data table")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
	     LoggerLoad.info("Validate search box in User page");
	     Assert.assertTrue(userpage.search.isDisplayed());
	 }
	//**Scenario 10**//
	@Then("Admin should see five records displayed on the data table")
	public void admin_should_see_two_records_displayed_on_the_data_table() throws InterruptedException {
	     LoggerLoad.info("Validate number of data rows in the data ");
	     int rows = userpage.getRows();
	     Assert.assertTrue(rows >= 2);
	}




}
