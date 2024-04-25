package com.StepDefinitions;

 

import org.testng.Assert;

import com.PageObjects.POM_LoginPage;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.*;

public class Login_StepDefinition {
	
	TestContext testcontext;
	POM_LoginPage loginpage;

	public Login_StepDefinition(TestContext testcontext) {
		
		this.testcontext = testcontext;
		loginpage = testcontext.pageobjectmanager.getPage_01();
	
	}
	 

	@Given("User is already on Login page")
	public void user_is_already_on_login_page() {
	      Assert.assertEquals(loginpage.getLoginPage(), Constant.HOME_PAGE_TITLE);
	}

	@When("User enters valid {string} and valid {string}")
	public void user_enters_valid_and_valid(String user, String password) {
	     loginpage.enterValidCredentials(user, password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	     loginpage.login();
	}

	@Then("User should be redirected to DashBoard Page")
	public void user_should_be_redirected_to_dash_board_page() {
		String pageTitle =	loginpage.getHomePageTitle();
		LoggerLoad.info("Home Page title is :-" + pageTitle);
		Assert.assertEquals(loginpage.getHomePageTitle(),Constant.HOME_PAGE_TITLE );
	}

}
