package com.StepDefinitions;

import com.PageObjects.POM_ProgramPage;
import com.Utilities.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramSorting_StepDefinition {
	
	TestContext testcontext;
	POM_ProgramPage programpage;

	public ProgramSorting_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
		programpage = testcontext.pageobjectmanager.getProgramPage();
	}

	@Then("Admin should land on dashboard page and clicks program on the navigation bar")
	public void admin_should_land_on_dashboard_page_and_clicks_program_on_the_navigation_bar() throws InterruptedException {
	    
	}

	@When("Admin clicks the sort icon of program name column")
	public void admin_clicks_the_sort_icon_of_program_name_column() throws InterruptedException {
		programpage.click_sortProgramName();
	}

	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
	    programpage.SortAscendingOrder(programpage.getSortingProgramName());
	}

	@Then("The data get sorted on the table based on the program name column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() throws InterruptedException {
		programpage.click_sortProgramName();
	    programpage.sortDescendingOrder(programpage.getSortingProgramName());
	}

	@When("Admin clicks the sort icon of program description column")
	public void admin_clicks_the_sort_icon_of_program_description_column() throws InterruptedException {
	    programpage.click_sortProgramDescription();
	}

	@Then("The data get sorted on the table based on the program description column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
	    programpage.SortAscendingOrder(programpage.getSortingProgramDescription());
	}

	@Then("The data get sorted on the table based on the program description column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() throws InterruptedException {
	  programpage.click_sortProgramDescription();
	  programpage.sortDescendingOrder(programpage.getSortingProgramDescription());
	}

	@When("Admin clicks the sort icon of program status column")
	public void admin_clicks_the_sort_icon_of_program_status_column() throws InterruptedException {
	    programpage.click_sortProgramStatus();
	}

	@Then("The data get sorted on the table based on the program status column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
	   programpage.SortAscendingOrder(programpage.getSortingProgramStatus());
	}

	@Then("The data get sorted on the table based on the program status column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() throws InterruptedException {
		   programpage.click_sortProgramStatus();
		   programpage.sortDescendingOrder(programpage.getSortingProgramStatus());
	}
}
