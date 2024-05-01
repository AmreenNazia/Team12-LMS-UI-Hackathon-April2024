package com.StepDefinitions;

import java.util.HashMap;
import java.util.Map;

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
	private Map<String, String> scenarioContextMap;

	public UserEdit_StepDefination(TestContext testcontext) {
		this.testcontext = testcontext;
		userEditPage = testcontext.getPageObjectManager().getUserEditPage();
		scenarioContextMap = new HashMap<>();
	}

	@Then("Admin clicks User on the navigation bar")
	public void admin_clicks_user_on_the_navigation_bar() {
		userEditPage.click_User("User");
	}

	@Given("Admin is on the Manage User Page")
	public void admin_is_on_the_manage_user_page() {
		userEditPage.waitForManageUserPage();
		userEditPage.searchInput(testUserName);
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		userEditPage.clickEditButton();
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
		userEditPage.waitForEditUserPageTitle();
	}

	@Given("Admin is on the User details pop up")
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
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields_and_clicks_submit(String fieldName) {
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

//delete

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		userEditPage.searchInput(testUserName);
		userEditPage.clickDeleteButton();
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String alertStr) {
		userEditPage.checkAlertExistence(alertStr);
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		userEditPage.searchInput(testUserName);
		String id = userEditPage.clickDeleteButton();
		scenarioContextMap.put("deleteID", id);
	}

	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {
		userEditPage.clickDialogYesOption();
	}

	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String deletedMsg) {
		userEditPage.checkDetailedMsg(deletedMsg);
		String deletedID = scenarioContextMap.get("deleteID");
		userEditPage.searchInput(testUserName);
		userEditPage.checkIDExistence(deletedID, false);

	}

	@When("Admin clicks No option")
	public void admin_clicks_no_option() {
		userEditPage.clickDialogNoOption();
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		String deletedID = scenarioContextMap.get("deleteID");
		userEditPage.searchInput(testUserName);
		userEditPage.checkIDExistence(deletedID, true);
	}

	@When("Admin will  click the close button")
	public void admin_will_click_the_close_button() {
		userEditPage.clickDialogCloseButton();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		String deletedID = scenarioContextMap.get("deleteID");
		userEditPage.searchInput(testUserName);
		userEditPage.checkIDExistence(deletedID, true);
	}


@When("Admin clicks any checkbox in the data table")
public void admin_clicks_any_checkbox_in_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see common delete option enabled under header Manage User")
public void admin_should_see_common_delete_option_enabled_under_header_manage_user() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("Admin clicks delete button under header after selecting the check box in the data table")
public void admin_clicks_delete_button_under_header_after_selecting_the_check_box_in_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks <YES> button on the alert")
public void admin_clicks_yes_button_on_the_alert() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should land on Manage User page and can see the selected user is deleted from the data table")
public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_deleted_from_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("Admin clicks delete button under header after selecting the checkbox in the data table")
public void admin_clicks_delete_button_under_header_after_selecting_the_checkbox_in_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



@Then("Admin should land on Manage User page and can see the selected user is not deleted from the data table")
public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_not_deleted_from_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("Admin clicks delete button under header after selecting multiple checkboxes in the data table")
public void admin_clicks_delete_button_under_header_after_selecting_multiple_checkboxes_in_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks <NO> button on the alert")
public void admin_clicks_no_button_on_the_alert() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should land on Manage User page and can see the selected users are not deleted from the data table")
public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_not_deleted_from_the_data_table() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}


}




