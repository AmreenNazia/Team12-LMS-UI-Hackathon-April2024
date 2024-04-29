package com.ApplicationHooks;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Properties;

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

 
	@Before
	public void setUp() {
		String browseName = com.PageObjects.credentialResouceBundle.getBrowser();
		System.out.println(browseName);
		basefactory = new BaseTest();
		driver = basefactory.initializeDriver(browseName);
		LoggerLoad.info("Hook:-Initializing driver for browser :" + browseName);
		driver.get(com.PageObjects.credentialResouceBundle.getURL());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.IMPLICIT_PAGE_LOAD));
		LoggerLoad.info("Hook:-home page url opened successfully");
	}

	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		if(driver!=null && scenario.isFailed())
		{
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
 			Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenShot));
			scenario.attach(screenShot, "image/png", "image");// This will attach screenshot to html report
		}
		LoggerLoad.info("Closing driver from hook's teardown method...");
 		if(driver!=null)
		driver.quit();
	}

 

	// @AfterStep
	// public void AddScreenshot(Scenario scenario) throws IOException {
  //
	// 	if(scenario.isFailed()){
  //
	// 		File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// 		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
	// 		scenario.attach(fileContent, "image/png", "image");
	// 	}
  //
  //
	// }

}
