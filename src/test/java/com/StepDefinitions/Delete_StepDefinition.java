package com.StepDefinitions;

import static org.testng.Assert.assertEquals;

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



	public class Delete_StepDefinition {

		TestContext testcontext;
		POM_ProgramPage programpage;
		POM_LoginPage loginpage;
		POM_Dashboard dashboardpage;
		
		  public Delete_StepDefinition(TestContext testcontext) {
				
				this.testcontext = testcontext;
				loginpage = testcontext.pageobjectmanager.getlogin();
				programpage = testcontext.pageobjectmanager.getprogram();
				
				dashboardpage=testcontext.pageobjectmanager.getdashboardPage();

			}	
	
		  @When("Admin clicks Delete button on the data table for any row for program")
		  public void admin_clicks_delete_button_on_the_data_table_for_any_row_for_program() {
		     programpage.clickonDeletebutton();
		  }

		  @Then("Admin should see a alert open with heading Confirm along with  YES and NO button for deletion")
		  public void admin_should_see_a_alert_open_with_heading_confirm_along_with_yes_and_no_button_for_deletion() {
			  programpage.getdeletePopup();
		  }
		 
		 
		  @Then("Admin should see a message {string}")
		  public void admin_should_see_a_message(String string) throws InterruptedException  {
			  Thread.sleep(2000);
			  Assert.assertEquals(programpage.isdelsuccessprogrmDisplayed(),string);
		  }

		  @Given("Admin is on Confirm Deletion alert for program")
		  public void admin_is_on_confirm_deletion_alert_for_program() {
		
		      programpage.clickonDeletebutton();
		  }

		  @When("Admin clicks <YES> button on the alert for program")
		  public void admin_clicks_yes_button_on_the_alert_for_program() {
		      programpage.clickonYesondelpopup();
		  }

		  @Then("Admin gets a message {string} alert and able to see that program deleted in the data table  for program")
		  public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table_for_program(String string) throws InterruptedException {
			  Thread.sleep(2000);
			  Assert.assertEquals(programpage.getdelsuccessprogrmmeg().contains("Program Deleted"),string);
		       
			  //Assert.assertTrue( programpage.isdelsucessmessage());
		  }

		  @When("Admin clicks <NO> button on the alert for program")
		  public void admin_clicks_no_button_on_the_alert_for_program() {
			  programpage.clickonNoondelpopup();
		  }

		  @Then("Admin can see the deletion alert disappears without deleting for program")
		  public void admin_can_see_the_deletion_alert_disappears_without_deleting_for_program() {
				 Assert.assertTrue(programpage.getManageProgramtitle().isDisplayed());
		  }

		  
		  @When("Admin clicks Cancel Icon on Deletion alert for program")
		  public void admin_clicks_cancel_close_x_icon_on_deletion_alert_for_program() {
	
		      programpage.clickoncancel();
		  }

		  @Then("Admin can see the deletion alert disappears without any changes for program")
		  public void admin_can_see_the_deletion_alert_disappears_without_any_changes_for_program() {
				Assert.assertTrue(programpage.getManageProgramtitle().isDisplayed());
		  }
	
	
	
	
	
	
	
}
