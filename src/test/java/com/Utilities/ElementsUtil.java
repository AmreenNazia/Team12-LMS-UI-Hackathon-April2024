package com.Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtil {

	public static WebElement waitForElementVisibility(WebDriver driver, WebElement element, long durationInSeconds) {
		// explicit wait
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementVisibility()::The element " + element.toString()
					+ " may not be visible. Exception is: " + e.getMessage());
		}
		return webElement;
	}
	public static List<WebElement> waitForElementsVisibility(WebDriver driver, List<WebElement> elememt, long durationInSeconds) {
		// explicit wait
		List<WebElement> webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOfAllElements(elememt));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementVisibility()::The element " + elememt.toString()
					+ " may not be visible. Exception is: " + e.getMessage());
		}
		return webElement;
	}

	public static void ScrolltoElementandClick(WebDriver driver, WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			webElement = waitForElementVisibility(driver, element, durationInSeconds);
			Actions action = new Actions(driver);
			action.moveToElement(webElement).click().perform();
		} catch (Exception e) {
			LoggerLoad.error("actionScrolltoElement::The element " + element.toString()
					+ " may not scrolled to element. Exception is: " + e.getMessage());
		}

	}
	 

	public static WebElement waitForElementClickablity(WebDriver driver, WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementClickablity()::The element " + element.toString()
					+ " may not be clickable. Exception is: " + e.getMessage());
		}
		return webElement;
	}

	public static void typeInputIntoElement(WebDriver driver, WebElement element, String textToBeTyped,
			long durationInSeconds) {
		WebElement webElement = null;
		try {
			webElement = waitForElementClickablity(driver, element, durationInSeconds);
			webElement.clear();
			webElement.click();
			webElement.sendKeys(textToBeTyped);
		} catch (Exception e) {
			LoggerLoad.error("typeInputIntoElement()::Not able to send text in " + element.toString()
					+ ". Exception is: " + e.getMessage());
		}
	}
	public static void implicitPageWait(WebDriver driver) {	

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.IMPLICIT_PAGE_LOAD));//10sec

     }
	public static void explicitElementWait(WebDriver driver) {	

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));//10sec

     }
	public static void waitforElementLoad() throws InterruptedException {
		Thread.sleep(1000);
	}
	public static void waitForPageLoad(WebDriver driver) {
		
		String pageLoadStatus =null;
		do {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		pageLoadStatus = (String)js.executeScript("return document.readyState");

	    } while ( !pageLoadStatus.equals("complete") );

	          System.out.println("Page Loaded.");
	}
	
	

	
}
