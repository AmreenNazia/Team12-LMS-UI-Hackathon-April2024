package com.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;

public class POM_UserPage {
	WebDriver driver;

	public POM_UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='user']")
	WebElement btn_user;
	@FindBy(xpath = "//div[@class='box']/text()")
	WebElement text;
	@FindBy(xpath = "//button[@id='user']/span[1]")
	WebElement user;
	@FindBy(xpath = "//div[@class='signin-content']//mat-card-title/div[1]")
	WebElement manageuser;
	@FindBy(xpath = "//p-paginator//div")
	WebElement paginaton;

	@FindBy(xpath = "//thead")
	WebElement column_headers;
	@FindBy(xpath = "//mat-card-title//div//button[@icon='pi pi-trash']")
	public WebElement delete;

	// @FindBy(xpath ="//button[@id='new']//span[@class ='p-button-icon
	// p-button-icon-left pi pi-plus']")
	// WebElement plusSign;
	@FindBy(xpath = "//button[@id='new']//span[2]")
	WebElement addNewUser;
	@FindBy(xpath = "//button[@label='Assign Staff']//span[2]")
	WebElement assignStaff;
	@FindBy(xpath="//button[@label='Assign Student']//span[2]")
	WebElement assignStudent;
	@FindBy(xpath="//input[@id='filterGlobal']")
	public
	WebElement search;
	
	@FindBy(xpath="//table//tbody[@class='p-datatable-tbody']//tr//td[1]")
	List<WebElement> rows;
	
	public String getPageTtile() {
		return driver.getTitle();
	}

	public void click_User(String User) throws InterruptedException {

		String user = btn_user.getText().toString();
		if (user.equals(User))
			ElementsUtil.ScrolltoElementandClick(driver, btn_user, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	}

	public String getUrl() throws InterruptedException {

		String url = driver.getCurrentUrl();
		return url;

	}

	public String getText() {

		String manageUser = manageuser.getText().toString();
		return manageUser;

	}

	public void getpagination(String text) {
		Assert.assertTrue(paginaton.isDisplayed());
		String data = paginaton.getText().toString();
		System.out.println(data);
	}

	public String getcolumnHeaders() {
		String text = column_headers.getText();
		return text;

	}

	public String getaNewUser() {
		String User = addNewUser.getText();
		return User;
		
	}

	public String getAssignStaff() {
		String Staff = assignStaff.getText();
		return Staff;
	}
	
	public String getAssignStudent() {
		String student = assignStudent.getText();
		return student;
	}
	
	 public int getRows() throws InterruptedException {
		 Thread.sleep(3000);
		 int Rows = rows.size();
		 System.out.println(Rows);
		 return Rows;
	 }

}
