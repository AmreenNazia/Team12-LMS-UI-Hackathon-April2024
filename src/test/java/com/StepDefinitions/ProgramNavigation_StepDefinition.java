package com.StepDefinitions;

import org.testng.Assert;

import com.PageObjects.POM_Dashboard;
import com.PageObjects.POM_ProgramPage;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramNavigation_StepDefinition {

	TestContext testcontext;
	POM_ProgramPage programpage;
	POM_Dashboard dashboardpage;

	public ProgramNavigation_StepDefinition(TestContext testcontext) {

		this.testcontext = testcontext;
		programpage = testcontext.pageobjectmanager.getProgramPage();
		dashboardpage = testcontext.pageobjectmanager.getDashboardPage();
	}

	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
		LoggerLoad.info("**********Admin clicks on User link from manage program page********");
		programpage.userClick();

	}

	@Then("Admin is re-directed to User page from Program page")
	public void admin_is_re_directed_to_user_page_from_program_page() {
		Assert.assertEquals(programpage.getUserHeaderText(), Constant.MANAGE_USERPAGE_HEADER);
		LoggerLoad.info("********Admin is in User page***********");
	}

	@When("Admin clicks on Batch link on Manage Program page")
	public void admin_clicks_on_batch_link_on_manage_program_page() {
		LoggerLoad.info("********Admin clicks on Batch link from manage program page*********");
		programpage.batchClick();
	}

	@Then("Admin is re-directed to Batch page from Program page")
	public void admin_is_re_directed_to_batch_page_from_program_page() {
		Assert.assertEquals(programpage.getBatchHeaderText(), Constant.MANAGE_BATCHPAGE_HEADER);
		LoggerLoad.info("*********Admin is in Batch page*******");
	}

	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
		LoggerLoad.info("**********Admin clicks on Logout link from manage program page**********");
		programpage.logoutClick();
	}

	@Then("Admin is re-directed to Login page from Program page")
	public void admin_is_re_directed_to_login_page_from_program_page() {
		Assert.assertEquals(dashboardpage.getLoginTitle(), Constant.LOGIN_TITLE);
		LoggerLoad.info("**********Admin is in Login page*********");
	}

}
