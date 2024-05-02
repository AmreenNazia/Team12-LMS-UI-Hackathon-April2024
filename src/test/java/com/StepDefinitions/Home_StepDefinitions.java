package com.StepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import com.PageObjects.POM_HomePageNew;
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;

public class Home_StepDefinitions {

	TestContext testcontext;
	POM_HomePageNew homepage;

	public Home_StepDefinitions(TestContext testcontext) {

		this.testcontext = testcontext;
		homepage = testcontext.pageobjectmanager.getHomePage();
	}

	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		LoggerLoad.info("*******************Admin launch the browser*****************");

	}

//verify with valid url
	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		LoggerLoad.info("****************Admin gives valid lms portal url************");

	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
		String title = homepage.homePageValidation();
		Assert.assertEquals("LMS", title);
		LoggerLoad.info("****************Admin is on " + title + " page***********");
	}

//verify with invalid url
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		homepage.getInvalidUrl();
		LoggerLoad.info("****************Admin gives invalid lms portal url*************");
	}

//verify http response
	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) throws MalformedURLException, IOException {
		LoggerLoad.info("*************verifying http response code************");
		homepage.httpResponseCode();

	}

//verify broken link
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws IOException {
		LoggerLoad.info("***************verifying broken link***************");
		homepage.verifyBrokenLink();
	}

//verify spelling in input fields
	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedInputFields = dataTable.asList(String.class);
		List<String> actualInputField = homepage.spellCheck();
		LoggerLoad.info("**************Admin should see correct spellings in all field***********");
		LoggerLoad.info("Actual input field text:" + actualInputField);
		Assert.assertEquals(expectedInputFields, actualInputField);
	}

//verify logo
	@Then("Admin should see logo on the left side")
	public void admin_should_see_logo_on_the_left_side() throws IOException {
		homepage.VerifyLogoImage();

	}

//verify application name	
	@Then("Admin should see LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() throws IOException, TesseractException {
		LoggerLoad.info("***********verifying application title************");
		homepage.ExtractContentFromImage();
		Assert.assertEquals(homepage.VerifyApplicationName(), Constant.LMS_TITLE);

	}

//verify company name	
	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() throws IOException, TesseractException {
		LoggerLoad.info("***********verifying company title*************");
		homepage.ExtractContentFromImage();
		Assert.assertEquals(homepage.verifyCompanyName(), Constant.COMPANY_TITLE);

	}

//verify login title
	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		LoggerLoad.info("***********Verifying Login Title*************");
		Assert.assertEquals(homepage.loginTitleValidation(), string);
	}

//verify input field is present
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		LoggerLoad.info("*********Verifying text field is presence or not*************");
		Assert.assertTrue(homepage.inputFieldDisplayed());
	}

//verify user text	
	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String userText) {
		LoggerLoad.info("*************verifying user field text***********");
		Assert.assertTrue(homepage.getUserText(userText));
	}

//verify asterik near user	
	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
		LoggerLoad.info("*************Verifying asterik symbol near user*************");
		Assert.assertTrue(homepage.verifyAstrickNextToUser());
	}

//verify password text	
	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String passwordText) {
		LoggerLoad.info("*************verifying password field text*************");
		Assert.assertTrue(homepage.getPasswordText(passwordText));
	}

//verify asterik near password	
	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		LoggerLoad.info("*************verifying asterik symbol near password************");
		Assert.assertTrue(homepage.verifyAstrickNextToPassword());
	}

//verify input field alignment	
	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		LoggerLoad.info("*************verifying input field alignment************");
		Assert.assertTrue(homepage.verifyInputFieldsCenter());
	}

//verify login button alignment	
	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		LoggerLoad.info("*************verifying login button alignment************");
		Assert.assertTrue(homepage.verifyLoginAlignment());
	}

//verify login button is present	
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		LoggerLoad.info("*************verifying login button is present************");
		Assert.assertTrue(homepage.verifyLoginButton());
	}

//verify user text colour 	
	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		LoggerLoad.info("*************verifying user text in gray colour************");
		Assert.assertTrue(homepage.verifyUserColourInGray());
	}

//verify password text colour	
	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		LoggerLoad.info("*************verifying password text in gray colour**************");
		Assert.assertTrue(homepage.verifyPasswordColourInGray());
	}

}
