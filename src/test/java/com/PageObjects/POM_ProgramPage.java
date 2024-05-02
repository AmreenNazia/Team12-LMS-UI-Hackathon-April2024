package com.PageObjects;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.util.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.Constant;
import com.Utilities.ElementsUtil;
import com.Utilities.ExcelReader;

public class POM_ProgramPage {

	WebDriver driver;

	 ExcelReader reader;

	public POM_ProgramPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
		this.reader = new ExcelReader();
	}
	
	

@FindBy(xpath="//*[text()=\"Program\"]")
private WebElement ProgramTab;

@FindBy(xpath = "//div/p-paginator")
WebElement paginaton;

@FindBy(xpath="//div[text()=\" Manage Program\"]")
private WebElement manageUserHeader;

@FindBy( xpath="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
private WebElement totalPrograms;

@FindBy(xpath = "//mat-card-title//div//button[@icon='pi pi-trash']")
private WebElement delete;

@FindBy(xpath=" //thead[@ class='p-datatable-thead']")
private WebElement datatablehaders;
@FindBy(xpath="//*[@id='pr_id_2-label']")
private WebElement   popUpHader;
@FindBy(id="new")
private WebElement   ANewProgram;
@FindBy(xpath="//div[@class='p-checkbox-box']")
private WebElement CheckBox;

@FindBy(xpath="//th[normalize-space()='Edit / Delete']")
private WebElement EditORDelete;
	
@FindBy(xpath="//table//tbody[@class='p-datatable-tbody']//tr//td[1]")
List<WebElement> rows;

@FindBy(xpath="//input[@id= 'filterGlobal']")
private WebElement Searchbar;

//@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-3 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']")
//private WebElement PopUpWindow;

@FindBy(id="programName")
private WebElement programName;

@FindBy(id="programDescription")
private WebElement programDescription;

@FindBy(xpath="//div[@class='radio ng-star-inserted']")
private WebElement Status;

@FindBy(xpath="//div[@class='p-field ng-star-inserted']")
private WebElement programinputTextFields;

@FindBy(xpath="html//div/div/div[2]/p-radiobutton/div/div[2]")
private WebElement StatusActiveButton;

@FindBy(xpath="//div/span[@class='p-radiobutton-icon']")
private WebElement Statusbuttons;

@FindBy(xpath="//button[@id='saveProgram']")
private WebElement Save;

@FindBy(xpath="//div/div/div[1]/div/button")
private WebElement Cancel;

@FindBy(xpath="//small[@class='p-invalid ng-star-inserted']")
private WebElement errormessage;

@FindBy(xpath="//app-program/p-dialog/div/div")
private WebElement editpopUpWindow;

@FindBy(id="editProgram")
private WebElement edit;

@FindBy(xpath="//div[@class='p-toast-message-text ng-tns-c90-5 ng-star-inserted']")
private WebElement successmessage;
@FindBy(xpath="//p-toastitem/div/div/div/div[2]")
private WebElement seaccessmessag;

@FindBy(xpath="//div[@class='p-toast-message-text ng-tns-c90-6 ng-star-inserted']")
private WebElement editsuccessmessage;
@FindBy(xpath =" //button[@id='deleteProgram']")
private WebElement deleteProgram;

@FindBy(xpath =" //app-root/app-program/p-confirmdialog/div/div ")
private WebElement deletepopuppage;

@FindBy(xpath ="/html[1]/body[1]/app-root[1]/app-program[1]/p-confirmdialog[1]/div[1]/div[1]/div[2]/span[1]")
private WebElement messageondeletepopup;

@FindBy(xpath="//div/div/div[3]/button[2]")
private WebElement YesButton;

@FindBy(xpath="//div/div/div[3]/button[1]")
private WebElement NoButton;
 @FindBy(xpath="//div[2]/div[1]/button")
 private WebElement DeleteButton;
@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
private WebElement programfristckeckbox;

@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
private WebElement programfristrecordckeckbox;
@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
private WebElement programsecondrecordckeckbox;
@FindBy(xpath = "//*[text()=\"Showing 1 to 1 of 1 entries\"]")
WebElement addedprogramMessage;
@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")
 private WebElement ManageProgramtitle;
@FindBy(xpath = "//table[@role='grid']/tbody/tr[1]/td")
private List<WebElement> programNameElements;

@FindBy(xpath = "//*[text()=\"Showing 0 to 0 of 0 entries\"]")
WebElement noOfRowsPresentInPage;

@FindBy(xpath = "//*[text()=\"Showing 1 to 1 of 1 entries\"]")
WebElement addedprogramNameStatus;	
@FindBy(xpath=" /html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[2]")
private WebElement deletesucessmessage;
@FindBy(xpath="/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div")
private WebElement delsuccessprogrm;
//pagination
@FindBy(xpath="//p-paginator/div/button[3]")
WebElement nextPageLink;

@FindBy(xpath="//p-paginator/div/button[4]")
WebElement lastPageLink;

@FindBy(xpath="//p-paginator/div/button[2]")
WebElement firstPageLink;

@FindBy(xpath="//p-paginator/div/button[1]")
WebElement previousPageLink;

@FindBy(xpath = "//p-paginator/div/span")
WebElement FooterText;
//navigation
@FindBy(xpath = "//button[@id='user']")
private WebElement user;
@FindBy(xpath = "//button[@id='logout']")
private WebElement logout;

@FindBy(xpath = "//button[@id='batch']")
private WebElement batch;

@FindBy(xpath="//app-batch/div/mat-card/mat-card-title/div[1]")
private WebElement batchHeader;
@FindBy(xpath="//app-user/div/mat-card/mat-card-title/div[1]")
private WebElement userHeader;

//sorting
	@FindBy(xpath="//thead//tr//th[2]")
	private WebElement clicksSortProgramName;
	
	@FindBy(xpath="//thead//tr//th[3]")
	private WebElement clicksSortProgramDescription;
	
	@FindBy(xpath="//thead//tr//th[4]")
	private WebElement clicksSortProgramStatus;
	
	@FindBy(xpath="//tr//td[2]")
	private List<WebElement>  sort_programName;
	
	@FindBy(xpath="//tr//td[3]")
	private List<WebElement>  sort_programDescription;
	
	@FindBy(xpath="//tr//td[4]")
	private List<WebElement>  sort_programStatus;


public String getCurrentUrl()
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	 public WebElement getTotalProgramsText() {
       return totalPrograms;
  }
	public void clickonDelete() {
		delete.click();
	}
	public int getRows() throws InterruptedException {
		 Thread.sleep(3000);
		 int Rows = rows.size();
		 System.out.println(Rows);
		 return Rows;
	 }
	 
	public String isdeletesucessmessage() {
        return deletesucessmessage.getText();
	}
	public String getNoOfRowsPresentInPage() {
		ElementsUtil.waitForElementVisibility(driver, noOfRowsPresentInPage, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		return noOfRowsPresentInPage.getText();

	}

	 public void clickonNewProgram() {
		 ElementsUtil.waitForElementVisibility(driver, ANewProgram, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 ANewProgram.click();
	 }
	 public WebElement getDataTableHeaders() {
	        return datatablehaders;
	    }
	 public WebElement getManageProgramtitle() {
	        return ManageProgramtitle ;
	    }
  
	    

	    
	   


	  
	 public void clickoncheckbox() {
		 CheckBox.click();
	 }
	  
	 public void geteditordeleteText() {
		 EditORDelete.getText();
	 }
	 
	 public void clickonsearch() {
		 Searchbar.click();
	 }
	


	 public boolean displayonpopUpHader()  {
		
		 return  popUpHader.isDisplayed();
	 } 
	 
	 public void clickonprogramname() {
		 ElementsUtil.waitForElementVisibility(driver,programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
	 }
	 public void clickonprogramdescription() {
	 ElementsUtil.waitForElementVisibility(driver,programDescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
	 }
	 public boolean isstatusVisible(){
		 return Status.isDisplayed();
	 }
	 public void getoninputTextFields() {
		 programinputTextFields.isDisplayed();
	 }
	 public void clickonsave() {
		 Save.click(); 
	 
	 }
	 public void clickoncancel() {
		 Cancel.click(); 
	 
	 }
	 public String getsuccessmessage() {
			return successmessage.getText();
			
				}
	 public String geterrormaessagetext() {
		return errormessage.getText();
		
			}

	 public boolean isErrorMessageDisplayed() {
	        return errormessage.isDisplayed();
    }
	 
	 public WebElement getSearchbar() {
			return Searchbar;
		}
	 public boolean isdelsuccessprogrmDisplayed() {
	        return delsuccessprogrm.isDisplayed();
 } 
	 
	 public String getdelsuccessprogrmmeg() {
	        return delsuccessprogrm.getText();
} 

 public void clickonActiveStatus() {
	 StatusActiveButton.click(); 
 }

	 public void clickonedit() {
		 edit.click();   
	        
	 }
	 public String geteditsuccessmessage() {
		return  editsuccessmessage.getText();
		 
	 }
	
	 
	  public void geteditpopupwindow() {
		  editpopUpWindow.getText();
	  }
		
		 public void editprogramstatus() {
		        
		        Statusbuttons.click();
		 } 
		 
        public WebElement getpagination() {
			return paginaton;
		}
         public void clickonDeletebutton() {
	      ElementsUtil.waitForElementVisibility(driver,deleteProgram, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
         }

        public void getdeletePopup() {
	
         deletepopuppage.isDisplayed();
        }

        
        public void clickonYesondelpopup() {
        	YesButton.click();
           }
        
        
       	          
        public void fillprogramForm(String programname, String programdescription) {
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		Actions action = new Actions(driver);
    		ElementsUtil.waitForElementVisibility(driver, programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		
    		ElementsUtil.typeInputIntoElement(driver, programName, programname, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		
    		ElementsUtil.waitForElementVisibility(driver, programDescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.typeInputIntoElement(driver, programDescription, programdescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.ScrolltoElementandClick(driver, StatusActiveButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.ScrolltoElementandClick(driver, Save, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		

		
		 
        public void clickonNoondelpopup() {
        	NoButton.click();
           }
        public void getenbleDeleteButton() {
        	DeleteButton.isEnabled();
        }
        
public String getprogramsecondrecordckeckbox() {
		WebElement programNameElement = programsecondrecordckeckbox.findElement(By.xpath(".//ancestor::tr/td[2]")); // Assuming batch
																										// name is in
																										// the first
																										// column
		String programName = programNameElement.getText();

		return programName;

	}

	public String getprogramfristrecordckeckbox() {

		WebElement programNameElement = programfristrecordckeckbox.findElement(By.xpath(".//ancestor::tr/td[2]")); // Assuming batch
																									// name is in the
																									// first column
		String programName = programNameElement.getText();

		return programName;
	}
        
        
        
        
		public void fillprogramdescription(String programdescription) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
    		Actions action = new Actions(driver);
			ElementsUtil.waitForElementVisibility(driver, programDescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.typeInputIntoElement(driver, programDescription, programdescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.ScrolltoElementandClick(driver, Save, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void fillprogramname(String programname) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
    		Actions action = new Actions(driver);
    		ElementsUtil.waitForElementVisibility(driver, programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.typeInputIntoElement(driver, programName, programname, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.ScrolltoElementandClick(driver, Save, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}	
		
		public void fillprogramforcancel(String programname, String programdescription) {
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		Actions action = new Actions(driver);
    		ElementsUtil.waitForElementVisibility(driver, programName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.typeInputIntoElement(driver, programName, programname, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.waitForElementVisibility(driver, programDescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.typeInputIntoElement(driver, programDescription, programdescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.ScrolltoElementandClick(driver, StatusActiveButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    		ElementsUtil.ScrolltoElementandClick(driver, Cancel, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		public void clickonprogramfristckeckbox() {
			programfristckeckbox.click();
		}
		
        public void clickonprogramfristrecordckeckbox() {
        	programfristrecordckeckbox.click();
        }
        
        public void clickonprogramsecondrecordckeckbox() {
        	programsecondrecordckeckbox.click();
        }

       
        
      //pagination
    	
    	public void clickNextPagelink() {
    		ElementsUtil.waitForElementVisibility(driver, nextPageLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
    	}
    	public String getFooterText() {
    		return ElementsUtil.waitForElementVisibility(driver, FooterText, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
    	}
    	public void clicklastPagelink() {
    		ElementsUtil.waitForElementVisibility(driver, lastPageLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
    	}
    	public boolean NextLinkProgpageEnabled() {
    		if (nextPageLink.isEnabled()) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	public void clickFirstPagelink() {
    		ElementsUtil.waitForElementVisibility(driver, firstPageLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
    	}
    	public boolean previosLinkPageEnabled() {
    		if (previousPageLink.isEnabled()) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    //navigation
    	public void clickPreviousPagelink() {
    		ElementsUtil.waitForElementVisibility(driver, previousPageLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
    	}
    	public void batchClick() {
    		ElementsUtil.waitForElementVisibility(driver, batch, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
    	}
    	public void userClick() {
    		ElementsUtil.waitForElementVisibility(driver, user, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
    	}
    	public void logoutClick() {
    		ElementsUtil.waitForElementVisibility(driver, logout, Constant.EXPLICIT_ELEMENT_WAIT_TIME).click();
    	}
    	public void navigateBack() {
    		driver.navigate().back();
    	}
    	public String getBatchHeaderText() {
    		return ElementsUtil.waitForElementVisibility(driver, batchHeader, Constant.EXPLICIT_ELEMENT_WAIT_TIME)
    				.getText();
    	}
    	public String getUserHeaderText() {
    		return ElementsUtil.waitForElementVisibility(driver, userHeader, Constant.EXPLICIT_ELEMENT_WAIT_TIME).getText();
    	}
    	 //sorting
     	public List<WebElement> getSortingProgramName() {
     		return sort_programName;
     	}
     	
     	public void click_sortProgramName() throws InterruptedException {
     		Thread.sleep(1000);
     		ElementsUtil.ScrolltoElementandClick(driver, clicksSortProgramName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
     	}
     	public List<WebElement> getSortingProgramDescription() {
     		return sort_programDescription;
     	}
     	
     	public void click_sortProgramDescription() throws InterruptedException {
     		Thread.sleep(1000);
     		ElementsUtil.ScrolltoElementandClick(driver, clicksSortProgramDescription, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
     	}
     	public List<WebElement> getSortingProgramStatus() {
     		return sort_programStatus;
     	}
     	
     	public void click_sortProgramStatus() throws InterruptedException {
     		Thread.sleep(1000);
     		ElementsUtil.ScrolltoElementandClick(driver, clicksSortProgramStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
     	}
     	
     	public void SortAscendingOrder(List<WebElement> list) {
     		List<String> appSort = list.stream().map(s->s.getText()).collect(Collectors.toList());
     		System.out.println(appSort);
     		
     		List<String> SortedList= appSort.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
     		System.out.println(SortedList);
     		Assert.assertTrue(appSort.equals(SortedList));
     		
     	}
     	
     	public void sortDescendingOrder(List<WebElement> list) {
     	    List<String> appSort = list.stream()
     	                              .map(s->s.getText())
     	                              .collect(Collectors.toList());
     	    System.out.println(appSort);
     	   
     	    List<String> sortedList = appSort.stream()
     	                                     .sorted(Comparator.reverseOrder())
     	                                     .collect(Collectors.toList());
     	    System.out.println(sortedList);
     	   
     	    Assert.assertTrue(appSort.equals(sortedList));
     	}
     	


} 


    
	


