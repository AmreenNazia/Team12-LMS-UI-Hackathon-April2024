package com.StepDefinitions;

import org.testng.Assert;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_ProgramPage;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Program_StepDefinition{
	
	TestContext testcontext;
	POM_ProgramPage programpage;
	POM_LoginPage loginpage;
	POM_Dashboard dashboardpage;
	
    public Program_StepDefinition(TestContext testcontext) {
		
		this.testcontext = testcontext;
		loginpage = testcontext.pageobjectmanager.getLoginPage();
		programpage = testcontext.pageobjectmanager.getProgramPage();
		
		dashboardpage=testcontext.pageobjectmanager.getDashboardPage();

	}
   

		

	@Given("Admin is on dashboard page after Login for program")
	public void admin_is_on_dashboard_page_after_login_for_program() throws InterruptedException {
		LoggerLoad.info("Validate landing in Program page");
	    Assert.assertTrue(dashboardpage.OnDashBoardOrNot());
		
	}
	
	
	@When("Admin clicks Program on the navigation bar for program")
	public void admin_clicks_program_on_the_navigation_bar_for_program() throws InterruptedException {
		
		dashboardpage.clickOnProgramTab();
	}


	@Then("Admin should see URL with {string} for program")
	public void admin_should_see_url_with_for_program(String string) {
		
		
		String url=programpage.getCurrentUrl();
		Assert.assertEquals(programpage.getCurrentUrl(), string);
		
		
	}

	@Then("Admin should see a heading with text {string} on the page for program")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) throws InterruptedException {
	
		dashboardpage.getManageUserHeader();
	    
//		String actualText = dashboardpage.getManageUserHeader().getText().trim();
//	        
//	        // Trim the expected text
//	        String trimmedExpectedText = string.trim();
//	        
//	        // Perform the assertion
//	        Assert.assertEquals(actualText, trimmedExpectedText);
	        Assert.assertEquals(dashboardpage.getManageUserHeader().getText().trim(), string.trim());


		
	}

	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table for program")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
		LoggerLoad.info("Validate the text and pagination icon below the data table");
		Assert.assertTrue(programpage.getpagination().isDisplayed());
	}
	
	@Then("Admin should see the footer as In total there are z programs for program")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs() throws InterruptedException {
		LoggerLoad.info("Validate the footer");
		Assert.assertTrue(programpage.getTotalProgramsText().isDisplayed());
	   
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled for program")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
	    programpage.clickonDelete();
	}

	@Then("Admin should see a {string} button on the program page above the data table for program")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
		 programpage.clickonNewProgram();
	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int} for program")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) throws InterruptedException {
		 LoggerLoad.info("Validate number of data rows in the data ");
	     int rows = programpage.getRows();
	     Assert.assertTrue(rows >= 5);
	}

	@Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
		programpage.getDataTableHeaders();
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete for program")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() throws InterruptedException {
	
		programpage.click_sortProgramName();
		
	}

	@Then("Admin should see check box on the left side in all rows of the data table for program")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	   programpage.clickoncheckbox();
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table for program")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		programpage.geteditordeleteText();
	}

	@Then("Admin should see Search bar with text as {string} for program")
	public void admin_should_see_search_bar_with_text_as(String string) {
		programpage.clickonsearch();
	}

}
