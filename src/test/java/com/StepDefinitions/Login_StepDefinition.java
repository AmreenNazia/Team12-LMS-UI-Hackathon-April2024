package com.StepDefinitions;



import org.testng.Assert;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.credentialResouceBundle;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinition {

	TestContext testcontext;
	POM_LoginPage loginpage;
	POM_Dashboard dashboard;
	String validUserName=com.PageObjects.credentialResouceBundle.getUsername();
	String validPassword=com.PageObjects.credentialResouceBundle.getPassword();

	public Login_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
 
		loginpage = testcontext.pageobjectmanager.getLoginPage();
		dashboard = testcontext.pageobjectmanager.getDashboardPage();
 
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {

		Assert.assertEquals(loginpage.getLoginPage(), "LMS");
		LoggerLoad.info("**************Admin is in login page**************");
	}

 //validate login with valid credential
	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {

		LoggerLoad.info("*************Admin enters valid credentials and click login button*************");
		loginpage.entervalidCredentials(validUserName, validPassword);
		loginpage.login();

	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {

		LoggerLoad.info("***************Admin lands on Dashboard page************");
		Assert.assertEquals(dashboard.getManageProgram().trim(), Constant.MANAGE_PROGRAMPAGE_HEADER);
	}


	// validate login with invalid credential
	@When("Admin enter invalid credentials and clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button() {

        LoggerLoad.info("***************Admin enters invalid credential and clicks login button***************");
		String invalidUserName = credentialResouceBundle.getInvalidUsername();
		String invalidPassword = credentialResouceBundle.getInvalidPassword();
		loginpage.enterInvalidCredentials(invalidUserName, invalidPassword);
		loginpage.login();
	}

	@Then("Error message please check username\\/password")
	public void error_message_please_check_username_password() {

		Assert.assertEquals(loginpage.getErrorMessage(), Constant.INPUTFIELD_ERRORMESSAGE);
	}

   //validate with only password
	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {

        LoggerLoad.info("**********Admin enters value only in password***********");
		loginpage.enterPassword(validPassword);
		loginpage.login();
	}

	@Then("Error message please enter username should displayed")
	public void error_message_please_enter_username_should_displayed() {

		Assert.assertEquals(loginpage.getuserErrorMessage(), Constant.USER_ERRORMESSAGE);
	}

   //validate with only login
	@When("Admin enter value only in username and clicks login button")
	public void admin_enter_value_only_in_username_and_clicks_login_button() {

        LoggerLoad.info("**************Admin enters value only in username*************");
		loginpage.enterUser(validUserName);
		loginpage.login();
	}

	@Then("Error message please enter password should displayed")
	public void error_message_please_enter_password_should_displayed() {

		Assert.assertEquals(loginpage.getPswdErrorMessage(), Constant.PASSWORD_ERRORMESSAGE);
	}

	// login keyboard click
	@When("Admin enter valid credentials and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {

        LoggerLoad.info("************Admin clicks through keyboard*****************");
		loginpage.entervalidCredentials(validUserName, validPassword);
		loginpage.keyboardAction();
	}

    //login mouse click
	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {

		LoggerLoad.info("************Admin clicks through mouse*****************");
		loginpage.entervalidCredentials(validUserName, validPassword);
		loginpage.mouseAction();
	}


}
