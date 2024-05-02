package com.StepDefinitions;

import org.testng.Assert;

import com.PageObjects.POM_ProgramPage;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramPagination_StepDefinition {

	TestContext testcontext;
	POM_ProgramPage programpage;

	public ProgramPagination_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
		programpage = testcontext.pageobjectmanager.getProgramPage();
	}

	@Given("Admin is on Manage Program page")
	public void admin_is_on_manage_program_page() {
		LoggerLoad.info("************Admin is in Manage Program page***********");
	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
		programpage.clickNextPagelink();
	}

	@Then("Admin should see the Pagination has Next link")
	public void admin_should_see_the_pagination_has__Next_link() {
		Assert.assertTrue(programpage.NextLinkProgpageEnabled());
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
		programpage.clicklastPagelink();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		Assert.assertFalse(programpage.NextLinkProgpageEnabled());
	}

	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() {
		LoggerLoad.info("***********Admin is in last page of program**********");
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
		admin_clicks_last_page_link();
		programpage.clickFirstPagelink();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		Assert.assertTrue(programpage.previosLinkPageEnabled());
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
		LoggerLoad.info("*************Admin is in previous program page*********");
	}

	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() {
		LoggerLoad.info("*************verifying start page link**********");
		admin_clicks_last_page_link();
		programpage.clickPreviousPagelink();

	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		Assert.assertFalse(programpage.previosLinkPageEnabled());
	}

}
