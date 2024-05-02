package com.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

 
 
@CucumberOptions(tags = "", features = {"src/test/resources/Features/01_Login.feature",
		"src/test/resources/Features/02_HomePage.feature",
		"src/test/resources/Features/03_DashBoardPage.feature",
		"src/test/resources/Features/04_program.feature",
		"src/test/resources/Features/05_program2.feature",
		"src/test/resources/Features/06_program3.feature",
		"src/test/resources/Features/07_ProgramPagination.feature",
		"src/test/resources/Features/08_ProgramNavigation.feature",
		"src/test/resources/Features/09_ProgramSorting.feature",
		"src/test/resources/Features/10_BatchPageValidation.feature",
		"src/test/resources/Features/11_AddNewBatch.feature",
		"src/test/resources/Features/12_EditBatch.feature",
		"src/test/resources/Features/13_UserPage_Validation.feature",
		"src/test/resources/Features/16_UserAssignStudent.feature",
		"src/test/resources/Features/17_UserAssignStaff.feature",
		"src/test/resources/Features/18_SortUser.feature",
		"src/test/resources/Features/19_UserDelete.feature",
		"src/test/resources/Features/20_MultipleUserDelete.feature",
		"src/test/resources/Features/21_DeleteBatch.feature",
		"src/test/resources/Features/22_DeleteMultipleBatches.feature",
		"src/test/resources/Features/23_ProgramDelete.feature",
		"src/test/resources/Features/24_MultipleProgramDelete.feature",
		"src/test/resources/Features/25_Logout.feature",
		}, glue = { "com.StepDefinitions",
 
"com.ApplicationHooks" }, monochrome = true, dryRun = false, plugin = { "pretty",
		"html:target/HtmlReport/htmlreport.html",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
 
		"rerun:target/failed_scenarios.txt"})

 
public class TestRunner extends AbstractTestNGCucumberTests {
 

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
