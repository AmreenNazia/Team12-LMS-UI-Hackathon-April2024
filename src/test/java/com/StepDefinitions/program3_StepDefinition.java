package com.StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_ProgramPage;
import com.Utilities.ElementsUtil;
import com.Utilities.ExcelReader;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class program3_StepDefinition {

	TestContext testcontext;
	POM_ProgramPage programpage;
	POM_LoginPage loginpage;
	POM_Dashboard dashboardpage;
	
	  public program3_StepDefinition(TestContext testcontext) {
			
			this.testcontext = testcontext;
			loginpage = testcontext.pageobjectmanager.getlogin();
			programpage = testcontext.pageobjectmanager.getprogram();
			
			dashboardpage=testcontext.pageobjectmanager.getdashboardPage();

		}
	  @When("Admin clicks Edit button on the data table for any row for program")
	  public void admin_clicks_edit_button_on_the_data_table_for_any_row_for_program() {
		  programpage.clickonedit();
		 // programpage.geteditpopupwindow();
	  }

	  @Then("Admin should see a popup open for Program details to edit for program")
	  public void admin_should_see_a_popup_open_for_program_details_to_edit_for_program() {
		  programpage.geteditpopupwindow();
	  }

	  @Given("Admin is on Program Details Popup window to Edit for program")
	  public void admin_is_on_program_details_popup_window_to_edit_for_program() throws InterruptedException {
		  Thread.sleep(2000);
		  programpage.clickonedit();
	  }

	  @When("Admin edits the Name column  using sheetname {string} and RowNumber {int} and clicks save button for program")
	  public void admin_edits_the_name_column_using_sheetname_and_row_number_and_clicks_save_button_for_program(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		  ExcelReader reader = new ExcelReader();
			
			List<Map<String, String>> testdata = reader.getData("C:\\Users\\subhashdevineni\\git\\Team12_XpathWarriors_LMS_UI_April2024\\src\\test\\resources\\TestData\\Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",SheetName);
			
			String programName = testdata.get(RowNumber).get("EditprogramName");
			//String programDescription = testdata.get(RowNumber).get("programDescription");
			
			programpage.fillprogramname( programName);

		  
		  
		  //		  Thread.sleep(2000);
//		  programpage.geteditpopupwindow();
//		  programpage.editvalidProgramName();
//		  programpage.clickonsave();
	  }

	  @Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	  public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
		  Assert.assertTrue(dashboardpage.isSuccessupdateMessageDisplayed().contains(string));
	  }
	  @When("Admin edits the Description column using sheetname {string} and RowNumber {int} and clicks save button for program")
	  public void admin_edits_the_description_column_using_sheetname_and_row_number_and_clicks_save_button_for_program(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		  ExcelReader reader = new ExcelReader();
			
			List<Map<String, String>> testdata = reader.getData("C:\\Users\\subhashdevineni\\git\\Team12_XpathWarriors_LMS_UI_April2024\\src\\test\\resources\\TestData\\Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",SheetName);
			
			//String programName = testdata.get(RowNumber).get("invalidprogramName");
			String programDescription = testdata.get(RowNumber).get("EditprogramDescription");
			
			programpage.fillprogramdescription( programDescription);
	  }
//	  @When("Admin edits the Description column and clicks save button for program")
//	  public void admin_edits_the_description_column_and_clicks_save_button_for_program() throws InterruptedException {
//		  Thread.sleep(2000);
//		  programpage.geteditpopupwindow();
//		  programpage.editvalidProgramDescription();
//		  programpage.clickonsave();
//	  }

	  @Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	  public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
		  Assert.assertEquals(dashboardpage.isSuccessupdateMessageDisplayed(),string);
	  }

	  @When("Admin changes the Status and clicks save button for program")
	  public void admin_changes_the_status_and_clicks_save_button_for_program() throws InterruptedException {
		  Thread.sleep(2000);
		  programpage.geteditpopupwindow();
		  programpage.editprogramstatus();
		  programpage.clickonsave();
	  }

	  @Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	  public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
		  Assert.assertTrue(programpage.getsuccessmessage().contains(string));
	  }
	  @When("Admin enters only numbers or special char in name and desc column using sheetname {string} and RowNumber {int} for program")
	  public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_using_sheetname_and_row_number_for_program(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
		 
		  programpage.geteditpopupwindow();
		  ExcelReader reader = new ExcelReader();
			
			List<Map<String, String>> testdata = reader.getData("C:\\Users\\subhashdevineni\\git\\Team12_XpathWarriors_LMS_UI_April2024\\src\\test\\resources\\TestData\\Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",SheetName);
				
				String programName = testdata.get(RowNumber).get("invalidprogramName");
				String programDescription = testdata.get(RowNumber).get("invalidprogramDescription");
				
				programpage.fillprogramForm(programName, programDescription);
	  }
	  @Then("Admin gets a Error message alert  for program")
	  public void admin_gets_a_error_message_alert_for_program() {
		  Assert.assertTrue(programpage.isErrorMessageDisplayed());
	  }
	  @When("Admin edit using sheetname {string} and RowNumber {int} and clicks Cancel button on edit popup for program")
	  public void admin_edit_using_sheetname_and_row_number_and_clicks_cancel_button_on_edit_popup_for_program(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	      
	  
		  ExcelReader reader = new ExcelReader();
			
			List<Map<String, String>> testdata = reader.getData("C:\\Users\\subhashdevineni\\git\\Team12_XpathWarriors_LMS_UI_April2024\\src\\test\\resources\\TestData\\Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",SheetName);
				
				String programName = testdata.get(RowNumber).get("EditprogramName");
				String programDescription = testdata.get(RowNumber).get("EditprogramDescription");
				
				programpage.fillprogramforcancel(programName, programDescription);
				
	  }
				
//	  @When("Admin edit  using sheetname {string} and RowNumber {int} clicks Cancel button on edit popup for program")
//	  public void admin_clicks_cancel_button_on_edit_popup_for_program() {
////			programpage.clickonprogramname();
////			 programpage.editvalidProgramName();
////			 programpage.clickonprogramdescription();
////			 programpage.editvalidProgramDescription();
////			 programpage.clickonActiveStatus();
//			 programpage.clickoncancel();
//	  }

	  @Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	  public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
	     
	  }
	  @When("Admin Edit details using sheetname {string} and RowNumber {int} and clicks Save button on edit popup for program")
	  public void admin_edit_details_using_sheetname_and_row_number_and_clicks_save_button_on_edit_popup_for_program(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
	     
	  
	
		  ExcelReader reader = new ExcelReader();
			
			List<Map<String, String>> testdata = reader.getData("C:\\Users\\subhashdevineni\\git\\Team12_XpathWarriors_LMS_UI_April2024\\src\\test\\resources\\TestData\\Team12-TestData-LMS-UI-Hackathon-April2024.xlsx",SheetName);
				
				String programName = testdata.get(RowNumber).get("EditprogramName");
				String programDescription = testdata.get(RowNumber).get("EditprogramDescription");
				
				programpage.fillprogramForm(programName, programDescription);
		  }
//	  @When("Admin clicks Save button on edit popup for program")
//	  public void admin_clicks_save_button_on_edit_popup_for_program() {
////		  programpage.clickonprogramname();
////			 programpage.editvalidProgramName();
////			 programpage.clickonprogramdescription();
////			 programpage.editvalidProgramDescription();
////			 programpage.editprogramstatus();
//			 programpage.clickonsave();
		
	//  }

	  @Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	  public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
		 Assert.assertEquals(dashboardpage.isSuccessupdateMessageDisplayed(),string); 
	  }  
	  
	  
	  
	  
	  
	  
	  
}



