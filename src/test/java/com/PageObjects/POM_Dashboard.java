package com.PageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import com.Utilities.LoggerLoad;

public class POM_Dashboard {

	WebDriver driver;

	public POM_Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()=\" Manage Program\"]")
	private WebElement manageProgramHeader;

	@FindBy(xpath = "//*[text()=\"Batch\"]")
	private WebElement batchTab;

	@FindBy(xpath = "//body/app-root/app-header/mat-toolbar/span[1]")
	private WebElement LMSNavBar;

	@FindBy(xpath = "//button[@id='program']")
	private WebElement programNavBar;

	@FindBy(xpath = "//button[@id='user']")
	private WebElement userNavbar;

	@FindBy(xpath = "//button[@id='logout']")
	private WebElement logoutNavbar;

	@FindBy(xpath = "//body/app-root/app-header/mat-toolbar/button")
	private List<WebElement> NavigationBar;

	@FindBy(xpath = "//app-program/div/mat-card/mat-card-title/div[1]")
	private WebElement manageProgram;
	
	@FindBy(xpath = "//app-login/div/mat-card/mat-card-content/form/p")
	private WebElement loginTitle;

	public void clickOnBatchTab() {
		batchTab.click();

	}

	public WebElement getManageprogramHeader() {
		return manageProgramHeader;
	}

	public boolean OnDashBoardOrNot() {
		return batchTab.isDisplayed();
	}

	public String getManageProgram() {
		return ElementsUtil.waitForElementVisibility(driver, manageProgram, Constant.EXPLICIT_ELEMENT_WAIT_TIME)
				.getText();

	}

	public long getMaxNavigationTime() {
		return driver.manage().timeouts().getPageLoadTimeout().toMillis();

	}

	public void verifyBrokenLinkDash() {

		String url = driver.getCurrentUrl();
		try {

			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() > 400) {
				LoggerLoad.info(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");

			} else {
				LoggerLoad.info(url + " - " + httpURLConnection.getResponseMessage());

			}
		} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");

		}

	}

	public String getLMSTtitle() {
		String LMSTitle = ElementsUtil.waitForElementVisibility(driver, LMSNavBar, Constant.EXPLICIT_ELEMENT_WAIT_TIME)
				.getText();
		return LMSTitle;
	}

	public boolean verifyLMSTitleAligned() {
		ElementsUtil.waitForElementVisibility(driver, LMSNavBar, Constant.EXPLICIT_ELEMENT_WAIT_TIME)
				.getCssValue("text-align").equals("left");

		return true;
	}

	public boolean VerifyNavigationBarRightAligned() {

		for (WebElement navBarElement : ElementsUtil.waitForElementsVisibility(driver, NavigationBar,
				Constant.EXPLICIT_ELEMENT_WAIT_TIME)) {

			String textAlign = navBarElement.getCssValue("text-align");
			LoggerLoad.info("Navigation Bar alignment: " + textAlign);
			if (!navBarElement.getCssValue("text-align").equals("right")) {
				LoggerLoad.info("NAV BAR ALIGNMENT ERROR: Element not right-aligned - " + navBarElement.getText());
				return false; // Return false if any element is not right-aligned
			}
		}
		LoggerLoad.info("NAV BAR ALIGNMENT: All elements are right-aligned.");
		return true; // Return true if all elements are right-aligned
	}

	public List<String> getNavigationBarText() {

		List<String> navigationBarText = new ArrayList<>();
		for (WebElement element : ElementsUtil.waitForElementsVisibility(driver, NavigationBar,
				Constant.EXPLICIT_ELEMENT_WAIT_TIME)) {
			navigationBarText.add(element.getText());
		}
		LoggerLoad.info("navigation Bar text:" + navigationBarText);
		return navigationBarText;
	}

	public String getFirstPlaceNavBar() {
		String FirstText = ElementsUtil
				.waitForElementVisibility(driver, programNavBar, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
		return FirstText;
	}

	public String getSecondPlaceNavBar() {
		String SecondText = ElementsUtil.waitForElementVisibility(driver, batchTab, Constant.EXPLICIT_ELEMENT_WAIT_TIME)
				.getText();
		return SecondText;
	}

	public String getThirdPlaceNavBar() {
		String ThirdText = ElementsUtil
				.waitForElementVisibility(driver, userNavbar, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
		return ThirdText;
	}

	public String getFourthPlaceNavBar() {
		String FourthText = ElementsUtil
				.waitForElementVisibility(driver, logoutNavbar, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
		return FourthText;
	}

	public void clickLogout() {
		ElementsUtil.waitForElementVisibility(driver, logoutNavbar, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();

	}
	
	public String getLoginTitle() {
	    return	ElementsUtil.waitForElementVisibility(driver, loginTitle, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();

	}
	
}
