package com.ApplicationHooks;

import java.io.ByteArrayInputStream;

import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.DriverFactory.BaseTest;
 
import com.Utilities.Constant;
import com.Utilities.LoggerLoad;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
 


public class AppHooks {

	private WebDriver driver;
	private BaseTest basefactory;
	private Properties prop;
	private static final String FILENAME = "Config/config";

	@Before
	public void setUp() {
		//Get Browser type from config file
		ResourceBundle rb = ResourceBundle.getBundle(FILENAME);
		String browseName =  rb.getString("browser");
		System.out.println(browseName);
		//Initialize driver from driver factory class
		basefactory = new BaseTest();
		driver = basefactory.initializeDriver(browseName);
		LoggerLoad.info("Hook:-Initializing driver for browser :"+browseName);
		driver.get(rb.getString("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.IMPLICIT_PAGE_LOAD));
		LoggerLoad.info("Hook:-home page url opened successfully");
	}

	@After
	public void tearDown(Scenario scenario) {		
		if(driver!=null && scenario.isFailed())
		{			
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenShot));
		}
		LoggerLoad.info("Closing driver from hook's teardown method...");		
		if(driver!=null)
		driver.quit();
	}

}