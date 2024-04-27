package com.StepDefinitions;

import org.testng.Assert;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.credentialResouceBundle;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinition {

	TestContext testcontext;
	POM_LoginPage loginpage;
	String validPassword;
	String validUserName;

	public Login_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
		loginpage = testcontext.getpageObjectManager().getLoginPage();
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		Assert.assertEquals(loginpage.getLoginPage(), "LMS");
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {

		validUserName = com.PageObjects.credentialResouceBundle.getUsername();
		validPassword = com.PageObjects.credentialResouceBundle.getPassword();
		loginpage.entervalidCredentials(validUserName, validPassword);
		loginpage.login();

	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {

		Assert.assertEquals(loginpage.getDashBoardTitle(), "LMS");
	}

	// validate login with invalid credential
	@When("Admin enter invalid credentials and clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button() {

		String invalidUserName = credentialResouceBundle.getInvalidUsername();
		String invalidPassword = credentialResouceBundle.getInvalidPassword();
		loginpage.enterInvalidCredentials(invalidUserName, invalidPassword);
		loginpage.login();
	}

	@Then("Error message please check username\\/password")
	public void error_message_please_check_username_password() {

		Assert.assertEquals(loginpage.getErrorMessage(), "Invalid username and password Please try again");
	}

   //validate with only password
	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {

		validPassword = com.PageObjects.credentialResouceBundle.getPassword();
		loginpage.enterPassword(validPassword);
		System.out.println("*****:" + validPassword);
		loginpage.login();
	}

	@Then("Error message please enter username should displayed")
	public void error_message_please_enter_username_should_displayed() {

		Assert.assertEquals(loginpage.getuserErrorMessage(), "Please enter your user name");
	}

   //validate with only login
	@When("Admin enter value only in username and clicks login button")
	public void admin_enter_value_only_in_username_and_clicks_login_button() {

		validUserName = com.PageObjects.credentialResouceBundle.getUsername();
		loginpage.enterUser(validUserName);
		loginpage.login();
	}

	@Then("Error message please enter password should displayed")
	public void error_message_please_enter_password_should_displayed() {

		Assert.assertEquals(loginpage.getPswdErrorMessage(), "Please enter your password");
	}

	// login keyboard click
	@When("Admin enter valid credentials and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {

		loginpage.entervalidCredentials(validUserName, validPassword);
		loginpage.keyboardAction();
	}

    //login mouse click
	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {

		loginpage.entervalidCredentials(validUserName, validPassword);
		loginpage.mouseAction();
	}

}
