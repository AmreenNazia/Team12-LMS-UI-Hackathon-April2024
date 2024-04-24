package com.StepDefinitions;

import com.PageObjects.POM_LoginPage;
import com.Utilities.TestContext;

public class Login_StepDefinition {
	
	TestContext testcontext;
	POM_LoginPage loginpage;
	
	public Login_StepDefinition(TestContext testcontext) {
		
		this.testcontext = testcontext;
		loginpage = testcontext.getpageObjectManager().getLoginPage();
	}
	 

}
