package com.StepDefinitions;

import org.testng.Assert;

import com.PageObjects.POM_LoginPage;
import com.PageObjects.POM_UserPage;
import com.Utilities.Constant;
import com.Utilities.TestContext;

import io.cucumber.java.en.*;

public class User_StepDefinitions {
	TestContext testcontext;
	POM_UserPage userpage;
	POM_LoginPage loginpage;

	public User_StepDefinitions(TestContext testcontext) {
		
		this.testcontext = testcontext;
		loginpage = testcontext.pageobjectmanager.getPage_01();
		userpage = testcontext.pageobjectmanager.getpage_02();
	
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		  Assert.assertEquals(loginpage.getDashBoardTitle(),Constant.HOME_PAGE_TITLE);
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
