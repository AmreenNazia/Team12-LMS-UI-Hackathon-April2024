package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;

public class POM_UserPage {
WebDriver driver;
	
	public POM_UserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//button[@id='user']")
	WebElement btn_user;
	@FindBy(xpath = "//div[@class='box']/text()")
	WebElement text;
	@FindBy(xpath="//*[@id=\"user\"]/span[1]n")
	WebElement user;
	
	
	
	
	public String getPageTtile() {
		return driver.getTitle();
	}
	
	public void click_User(String User) throws InterruptedException {
//		 String text = user.getText();
//		 if(text == User)
		 ElementsUtil.ScrolltoElementandClick(driver, btn_user, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 Thread.sleep(2000);

	}
	
	public void getText() {
//		String Text =  text.getText();
//		return Text;
		 
		
		
	}

	
}
