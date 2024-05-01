package com.PageObjects;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import com.Utilities.LoggerLoad;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class POM_HomePageNew {
	
	WebDriver driver;
	String invalidUrl;
	String path;
    String extractedText;
    
	public POM_HomePageNew(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login")
	WebElement login;
	@FindBy(xpath = "//div[@class='image-container']")
	WebElement logoImage;
	@FindBy(xpath = "//app-login/div/mat-card/mat-card-content/form/p")
	WebElement loginTitle;
	@FindBy(xpath = "//form/mat-form-field/div/div[@class='mat-form-field-flex ng-tns-c78-0']")
	WebElement userText;
	@FindBy(xpath = "//form/mat-form-field[2]/div/div[@class='mat-form-field-flex ng-tns-c78-1']")
	WebElement pswdText;
	@FindBy(xpath="//form[@class='ng-untouched ng-pristine ng-invalid']")
	WebElement inputField;

	public String homePageValidation() {
		String title = driver.getTitle();
		return title;

	}

	public void getInvalidUrl() {

		invalidUrl = com.PageObjects.credentialResouceBundle.getInvalidURL();
		driver.get(invalidUrl);
	}

	public void httpResponseCode() throws MalformedURLException, IOException {
		
		HttpURLConnection conn = (HttpURLConnection) new URL(invalidUrl).openConnection();
		conn.setRequestMethod("HEAD");// set HEADER request
		conn.connect();// connection initiate
		int respCode = conn.getResponseCode();// get response code
		LoggerLoad.info("Http response code: " + respCode);
	}

	public void verifyBrokenLink() throws IOException {
		
		List<WebElement> links = driver.findElements(By.tagName("link"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				LoggerLoad.info(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				LoggerLoad.info(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		}
	}

	public boolean verifyLogoOnLeftSide() {
		
		String logoLocation= logoImage.getCssValue("text-align");
		//String margin = logoImage.getCssValue("margin");
		LoggerLoad.info("logo location:" +logoLocation);
		return logoLocation.equals("left");
		
	}
	
	public String verifyApplicationTitle() {
		
		return driver.getTitle();
	}
	
	public void VerifyLogoImage() {

		Point logoImagePosition = logoImage.getLocation();// Get the position of the logo image
		int logoImageX = logoImagePosition.getX();

		boolean isImageInLeftCorner = logoImageX < 50;// Check if the logo image is in the left corner 

		if (isImageInLeftCorner) {
		LoggerLoad.info("Yes, Logo image is in the left side");
		} else {
		LoggerLoad.info("No, Logo image is not in the left side.");
		}	
	}
	
	public void ExtractContentFromImage() throws IOException, TesseractException {
		
		File screenshot = ElementsUtil.waitForElementVisibility(driver, logoImage, Constant.EXPLICIT_ELEMENT_WAIT_TIME)
				.getScreenshotAs(OutputType.FILE);
		path = System.getProperty("user.dir") + "/screenshots/title.png";
		FileHandler.copy(screenshot, new File(path));
		
		Tesseract tesseract = new Tesseract();// Initialize Tesseract instance
		tesseract.setDatapath("/usr/local/Cellar/tesseract/5.3.4_1/share/tessdata");// Set the tessdata path (where your
																					// language data files are stored)
		extractedText = tesseract.doOCR(new File(path));// Extract text from the image
		LoggerLoad.info("Extracted text: " + extractedText);
		System.out.println("Extracted split text: " + extractedText.split("\\R"));
	}

public String VerifyApplicationName() {
	
		String[] explitText = extractedText.split("\\R");
		String projectName = explitText[0];
		String ApplicationName = projectName.substring(3);
		LoggerLoad.info("Actual Application name:: " + ApplicationName);
		return ApplicationName;
	}
	public String verifyCompanyName() {
		
		String[] explitText = extractedText.split("\\R");
		String companyName = explitText[2];
		LoggerLoad.info("Actual company Name:: " + companyName);
		return companyName;
	}

	public String loginTitleValidation() {
		String loginTitleText = loginTitle.getText();
		return loginTitleText;
	}

	public boolean inputFieldDisplayed() {
		username.isDisplayed();
		password.isDisplayed();
		return true;

	}

	public boolean getUserText(String user) {
		boolean usrText = userText.getText().contains(user);
		return usrText;
	}

	public boolean verifyAstrickNextToUser() {
		String asterik = "*";
		boolean usrAsterikText = userText.getText().contains(asterik);
		return usrAsterikText;
	}

	public boolean getPasswordText(String pswd) {
		boolean usrText = pswdText.getText().contains(pswd);
		return usrText;
	}

	public boolean verifyAstrickNextToPassword() {
		String asterik = "*";
		boolean usrAsterikText = pswdText.getText().contains(asterik);
		return usrAsterikText;
	}

	public boolean verifyLoginAlignment() {
		String loginAlignment = login.getCssValue("text-align");
		String margin = login.getCssValue("margin");
		 LoggerLoad.info("Alignment of login button:"+loginAlignment);
		 return(loginAlignment.equals("center")||margin.equals("auto"));
	}
	
	public boolean verifyInputFieldsCenter() {
			String textAlignment = inputField.getCssValue("text-align");
			String margin = inputField.getCssValue("margin");
    LoggerLoad.info("text alignment of input field:"+textAlignment);
		return (textAlignment.equals("center")|| margin.equals("auto"));
	}


	public boolean verifyLoginButton() {
		return login.isDisplayed();
	}
	
	public boolean verifyUserColourInGray() {
	    String textColor = userText.getCssValue("color");
	    System.out.println("user text :" +userText.getText());
	    String hex = Color.fromString(textColor).asHex();
	    LoggerLoad.info("Hex value of text colour: " + hex);
	    return textColor.equals("#808080");
	   
	}

	public boolean verifyPasswordColourInGray() {
		String pswdtextcolor = pswdText.getCssValue("color");
		 LoggerLoad.info(" text colour: " + pswdtextcolor);
		return pswdtextcolor.equals("#808080");
	}
	
	public List<String> spellCheck() {
		
		List<String>inputFields = new ArrayList<>();
		 String user = userText.getText().replaceAll("\\*", "").trim();
		inputFields.add(user);
		 String pswd = pswdText.getText().replaceAll("\\*", "").trim();
		inputFields.add(pswd);
		inputFields.add(login.getText());
		return inputFields;
		
	}
	}





