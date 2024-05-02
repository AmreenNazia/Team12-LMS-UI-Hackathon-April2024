package com.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import com.PageObjects.POM_Dashboard;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dashboard_StepDefinition {

	TestContext testcontext;
	POM_Dashboard dashboard;
    long endTime;
    long startTime;
    
	public Dashboard_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
		dashboard = testcontext.getpageObjectManager().getDashboardPage();
	}

	// verify header
	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
		String headerText = dashboard.getManageProgram();
		Assert.assertEquals(headerText, Constant.MANAGE_PROGRAMPAGE_HEADER);
		LoggerLoad.info("*************Validate Manage Program header:" + headerText +"***************");
	}

	// verify response time
	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer defaultTime) {
		long responseTime = endTime - startTime;
		LoggerLoad.info("*************Validate ResponseTime: " + responseTime + " milliseconds*************");
		 Assert.assertTrue(responseTime <= defaultTime, "Response time is longer than expected");
	}

	// verify broken link
	@Then("HTTP response >= {int}. Then the link is broken in dashboard page")
	public void http_response_then_the_link_is_broken_in_dashboard_page(Integer int1) throws IOException {
        LoggerLoad.info("*************Verifying broken link in dashboard page*******");
		dashboard.verifyBrokenLinkDash();
	}

	// verify title
	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		LoggerLoad.info("************* verifying LMS-TITLE**********");
		LoggerLoad.info("Title of dashboard page:" + dashboard.getLMSTtitle());
		Assert.assertEquals(dashboard.getLMSTtitle(), Constant.LMS_TITLE);
	}

	// verify LMS title spelling
	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_LMS_title() {
		LoggerLoad.info("*************Verifying spelling of LMS TITLE************");
		Assert.assertEquals(dashboard.getLMSTtitle(), Constant.LMS_TITLE);
		LoggerLoad.info("Actual Lms Title: " + dashboard.getLMSTtitle());
	}

	// verify LMS Title Aligned
	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		LoggerLoad.info("*************Verifying LMS title alignment*********");
		boolean isTitleAligned = dashboard.verifyLMSTitleAligned();
		Assert.assertTrue(isTitleAligned);
	}

	// verify Spelling In navigation bar
	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedNavigationBarText = dataTable.asList(String.class);
		List<String> actualNavigationBarText = dashboard.getNavigationBarText();
		LoggerLoad.info("*************Verifying Navigation bar text spelling*************");
		LoggerLoad.info("Actual navigation bar text spelling:" + actualNavigationBarText);
		Assert.assertEquals(expectedNavigationBarText, actualNavigationBarText);

	}

	//verify navigation bar alignment
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		LoggerLoad.info("*************Verifying navigation bar alignment************");
		Assert.assertTrue(dashboard.VerifyNavigationBarRightAligned());
		
	}

	// verify navigation bar first place
	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {
		Assert.assertEquals(dashboard.getFirstPlaceNavBar(), Constant.PROGRAM_NAVBAR_TEXT);
		LoggerLoad.info("*************Verifying navigation bar first place***********");
		LoggerLoad.info("Navigation Bar text in first place:" + dashboard.getFirstPlaceNavBar());
	}

	// verify navigation bar second place
	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {
		Assert.assertEquals(dashboard.getSecondPlaceNavBar(), Constant.BATCH_NAVBAR_TEXT);
		LoggerLoad.info("*************Verifying navigation bar second place***********");
		LoggerLoad.info("Navigation Bar text in second place:" + dashboard.getSecondPlaceNavBar());
	}

	// verify navigation bar third place
	@Then("Admin should see user in the  3rd place")
	public void admin_should_see_user_in_the_3rd_place() {
		Assert.assertEquals(dashboard.getThirdPlaceNavBar(), Constant.USER_NAVBAR_TEXT);
		LoggerLoad.info("*************Verifying navigation bar third place***********");
		LoggerLoad.info("Navigation Bar text in third place:" + dashboard.getThirdPlaceNavBar());
	}

	// verify navigation bar fourth place
	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {
		Assert.assertEquals(dashboard.getFourthPlaceNavBar(), Constant.LOGOUT_NAVBAR_TEXT);
		LoggerLoad.info("*************Verifying navigation bar fourth place***********");
		LoggerLoad.info("Navigation Bar text in fourth place:" + dashboard.getFourthPlaceNavBar());
	}
	
	//verify logout
	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		LoggerLoad.info("*************clicks logout button***********");
	    dashboard.clickLogout();
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
	    Assert.assertEquals(dashboard.getLoginTitle(), Constant.LOGIN_TITLE);
	}

}
