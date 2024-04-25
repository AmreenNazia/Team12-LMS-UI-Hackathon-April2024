package com.StepDefinitions;

import java.util.ResourceBundle;

import org.testng.Assert;

import com.PageObjects.POM_LoginPage;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinition {
	
	TestContext testcontext;
	POM_LoginPage loginpage;
	
	public Login_StepDefinition(TestContext testcontext) {
		
		this.testcontext = testcontext;
		loginpage = testcontext.pageobjectmanager.getPage_01();
	}
	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		Assert.assertEquals(loginpage.getLoginPage(), "LMS");
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		ResourceBundle rb = ResourceBundle.getBundle("Config/config");
		String validUserName = rb.getString("user");
		String validPassword = rb.getString("password");
		loginpage.entervalidCredentials(validUserName, validPassword);

	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		Assert.assertEquals(loginpage.getDashBoardTitle(), "LMS");
	}

	 
}
