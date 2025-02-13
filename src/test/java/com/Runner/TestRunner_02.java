package com.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = { "src/test/resources/Features/14_AddNewUser.feature",
		"src/test/resources/Features/15_UserEdit.feature", }, glue = { "com.StepDefinitions",

				"com.ApplicationHooks" }, monochrome = true, dryRun = false, plugin = { "pretty",
						"html:target/HtmlReport/htmlreport_02.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",

						"rerun:target/failed_scenarios.txt" })
public class TestRunner_02 extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
