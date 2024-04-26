package com.ApplicationHooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.DriverFactory.BaseTest;
 
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;
import com.Utilities.TestContext;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
 


public class AppHooks {

	private WebDriver driver;
	private BaseTest basefactory;
	private Properties prop;
 
    
	@Before
	public void setUp() {
	  String browseName =  com.PageObjects.credentialResouceBundle.getBrowser();
 		System.out.println(browseName);
		//Initialize driver from driver factory class
		basefactory = new BaseTest();
		driver = basefactory.initializeDriver(browseName);
		LoggerLoad.info("Hook:-Initializing driver for browser :"+browseName);
		driver.get(com.PageObjects.credentialResouceBundle.getURL());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.IMPLICIT_PAGE_LOAD));
		LoggerLoad.info("Hook:-home page url opened successfully");
	}

	@After
	public void tearDown(Scenario scenario) {		
		if(driver!=null && scenario.isFailed())
		{			
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenShot));
			scenario.attach(screenShot, "image/png", "image");//This will attach screenshot to html report
		}
		LoggerLoad.info("Closing driver from hook's teardown method...");		
		if(driver!=null)
		driver.quit();
	}
	

	 

}