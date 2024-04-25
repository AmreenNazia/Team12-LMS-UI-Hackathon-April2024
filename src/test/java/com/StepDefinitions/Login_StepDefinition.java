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
}
 
