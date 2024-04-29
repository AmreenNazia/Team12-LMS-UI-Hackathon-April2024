package com.StepDefinitions;

import com.PageObjects.POM_UserEditPage;
import com.Utilities.InputValueType;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserEdit_StepDefination {
	
	TestContext testcontext;
	POM_UserEditPage userEditPage;
	String testUserName = com.PageObjects.credentialResouceBundle.getTestUserName();

	
	
	public UserEdit_StepDefination(TestContext testcontext) {
		this.testcontext = testcontext;
		userEditPage = testcontext.getPageObjectManager().getUserEditPage();
	}
	
	
	@Then("Admin clicks User on the navigation bar")
	public void admin_clicks_user_on_the_navigation_bar()  {
	   userEditPage.click_User("User");
	}

	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
	   userEditPage.waitForManageUserPage();
		userEditPage.searchInput(testUserName);
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon()  {
	    userEditPage.clickEditButton();
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
	    userEditPage.waitForEditUserPageTitle();
	}

	@Given("Admin is on User details pop up")
	public void admin_is_on_user_details_pop_up() {
		userEditPage.searchInput(testUserName);
	    userEditPage.clickEditButton();
	}

	
	@When("Update the field {string} with valid data and click submit")
	public void update_the_field_with_valid_data_and_click_submit(String fieldName) {
	    userEditPage.modifyUser(fieldName, InputValueType.VALID);
	    userEditPage.clickSubmitOnEditWindow();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String msg) {
	   userEditPage.checkDetailedMsg(msg);
	}
	
	@Then("verify the updated value for field {string} in edit page")
	public void verify_the_updated_value_for_field_in_edit_page(String fieldName) {
		userEditPage.clickEditButton();
		userEditPage.verifyModifiedValue(fieldName, InputValueType.VALID);
		userEditPage.clickCloseButtonOnEditWindow();
	}
	

	@When("Update the field {string} with invalid values and click submit")
	public void update_the_field_with_invalid_values_and_click_submit(String fieldName) {
		userEditPage.modifyUser(fieldName, InputValueType.INVALID);
	    userEditPage.clickSubmitOnEditWindow();
	}

	@Then("Admin should get {string} message")
	public void admin_should_get_message(String msg) {
	    userEditPage.checkHeaderMsg(msg);
	}

	@When("Update the mandatory fields {string} with valid values and click submit")
	public void update_the_mandatory_fields_with_valid_values_and_click_submit(String fieldName) {
		 userEditPage.modifyUser(fieldName, InputValueType.VALID);
		 userEditPage.clickSubmitOnEditWindow();
	}

	@When("Update the optional fields {string} with valid values and click submit")
	public void update_the_optional_fields_with_valid_values_and_click_submit(String fieldName) {
		 userEditPage.modifyUser(fieldName, InputValueType.VALID);
		 userEditPage.clickSubmitOnEditWindow();
	}

	@When("Admin enters only numbers or special char in the text fields {string} and click submit")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields_and_clicks_submit(String fieldName){
		 userEditPage.modifyUser(fieldName, InputValueType.SPECIALCHAR_NUM);
		 userEditPage.clickSubmitOnEditWindow();
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		userEditPage.modifyUser("lastName", InputValueType.CANCNEL_INPUT);
		userEditPage.clickCancelOnEditWindow();
	}

	@Then("Admin can see the User details popup disappears and can see nothing changed for particular User")
	public void admin_can_see_the_user_details_popup_disappears_and_can_see_nothing_changed_for_particular_user() {
		userEditPage.clickEditButton();
		userEditPage.verifyModifiedValue("lastName", InputValueType.CANCNEL_INPUT);
	}


//sort
@When("Admin clicks on ID sort icon")
public void admin_clicks_on_id_sort_icon() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see User details are sorted by id")
public void admin_should_see_user_details_are_sorted_by_id() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks on name sort icon")
public void admin_clicks_on_name_sort_icon() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see User details are sorted by name")
public void admin_should_see_user_details_are_sorted_by_name() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks on Location sort icon")
public void admin_clicks_on_location_sort_icon() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see User details are sorted by Location")
public void admin_should_see_user_details_are_sorted_by_location() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks on Phone number sort icon")
public void admin_clicks_on_phone_number_sort_icon() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see User details are sorted by Phone number")
public void admin_should_see_user_details_are_sorted_by_phone_number() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

}