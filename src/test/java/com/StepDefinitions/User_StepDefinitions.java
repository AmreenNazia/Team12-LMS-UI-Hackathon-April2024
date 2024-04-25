package com.StepDefinitions;

import org.testng.Assert;

import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserPage;
import com.Utilities.Constant;
import com.Utilities.TestContext;

import io.cucumber.java.en.*;

public class User_StepDefinitions {
	TestContext testcontext;
	POM_UserPage userpage;
	POM_LoginPage loginpage;
	POM_HomePage homepage;

	public User_StepDefinitions(TestContext testcontext) {
		
		this.testcontext = testcontext;
		loginpage = testcontext.pageobjectmanager.getLoginPage();
		userpage = testcontext.pageobjectmanager.getUserPage();
		homepage = testcontext.pageobjectmanager.getHomePage();
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		  Assert.assertEquals(homepage.getHomePageTitle(),Constant.HOME_PAGE_TITLE);
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String text) throws InterruptedException {
	    userpage.click_User(text);
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String text) {
		userpage.getText(text);
	    
	}

}
