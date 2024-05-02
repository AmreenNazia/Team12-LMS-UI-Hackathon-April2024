package com.StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_ProgramPage;
import com.Utilities.ElementsUtil;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete1_StepDefinition {

		TestContext testcontext;
		POM_ProgramPage programpage;
		POM_LoginPage loginpage;
		POM_Dashboard dashboardpage;
		
		  public Delete1_StepDefinition(TestContext testcontext) {
				
				this.testcontext = testcontext;
				loginpage = testcontext.pageobjectmanager.getlogin();
				programpage = testcontext.pageobjectmanager.getprogram();
				
				dashboardpage=testcontext.pageobjectmanager.getdashboardPage();

			}	
	
	
	@Given("Admin is in Manage Program page for programpage")
	public void admin_is_in_manage_program_page_for_programpage() throws InterruptedException {
		
		dashboardpage.clickOnProgramTab();
	}

	@When("Admin clicks any checkbox in the data table for programpage")
	public void admin_clicks_any_checkbox_in_the_data_table_for_programpage() {
	   programpage.clickoncheckbox();
	   
	}

	@Then("Admin should see common delete option enabled under header Manage Program for programpage")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program_for_programpage() {
	   programpage.getenbleDeleteButton();
	}

	@Given("Admin is on Confirm Deletion alert for programpage")
	public void admin_is_on_confirm_deletion_alert_for_programpage() throws InterruptedException {
		Thread.sleep(2000);
		programpage.clickonprogramfristckeckbox();
		programpage.clickonDeletebutton();
		Thread.sleep(2000);
		programpage.getdeletePopup();
	}

	@When("Admin clicks <YES> button on the alert for programpage")
	public void admin_clicks_yes_button_on_the_alert_for_programpage() throws InterruptedException {
	Thread.sleep(2000);
		programpage.clickonYesondelpopup();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table for programpage")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table_for_programpage() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(programpage.getManageProgramtitle().isDisplayed());
       
	}

	@When("Admin clicks <NO> button on the alert for programpage")
	public void admin_clicks_no_button_on_the_alert_for_programpage() throws InterruptedException {
		Thread.sleep(2000);
		programpage.clickonNoondelpopup();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table for programpage")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table_for_programpage() {
		Assert.assertTrue(programpage.getManageProgramtitle().isDisplayed());
	}

	@Given("Admin is on Confirm Deletion alert for programpg")
	public void admin_is_on_confirm_deletion_alert_for_programpg() throws InterruptedException {
		Thread.sleep(2000);
		programpage.clickonprogramfristckeckbox();
		programpage.clickonprogramsecondrecordckeckbox();
		programpage.clickonDeletebutton();
	}

	@When("Admin clicks <YES> button on the alert for programpg")
	public void admin_clicks_yes_button_on_the_alert_for_programpg() throws InterruptedException {
		
		programpage.clickonYesondelpopup();
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table for programpg")
     public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table_for_programpg() throws InterruptedException {
Thread.sleep(2000);
		String deletedprogramName = programpage.getprogramfristrecordckeckbox();
		String deletedSecondprogramName = programpage.getprogramsecondrecordckeckbox();
	//	LoggerLoad.info("Getting row details before deletion"+ firstRowText);
	//	LoggerLoad.info("Getting program Name details before deletion" + deletedprogramName);
	//	LoggerLoad.info("Getting Second Batch Name details before deletion"
	//			+ deletedSecondprogramName);
		dashboardpage.getDeleteUnderManageProgram().click();
		Thread.sleep(2000);
		programpage.clickonYesondelpopup();
	//	LoggerLoad.info("****Searching for the batch name if it got deleted or not*****");
	//	LoggerLoad.info("****Validating by using Showing 0 to 0 of 0 entries in footer section*****");
		List<String> programNamesToCheck = List.of(deletedprogramName, deletedSecondprogramName);

		for (String programName : programNamesToCheck) {
			programpage.clickonsearch();
			Thread.sleep(2000);
			programpage.getSearchbar().sendKeys(programName);
			if (programpage.getNoOfRowsPresentInPage().contains("0 entries")) {
				System.out.println("Batch got deleted: " + programName);
			} else {
				System.out.println("Batch not deleted: " + programName);
			}
		}

	}
	

	@When("Admin clicks <NO> button on the alert for programpg")
	public void admin_clicks_no_button_on_the_alert_for_programpg() throws InterruptedException {
		
		Thread.sleep(2000);
		programpage.clickonNoondelpopup();
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table for programpg")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table_for_programpg() {
	    
		Assert.assertTrue(programpage.getManageProgramtitle().isDisplayed());
	}	
	
	
	
	
	
	
	
}
