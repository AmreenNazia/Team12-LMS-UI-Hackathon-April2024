@program2
Feature: Add New Program
Background: Admin gives correct lms portal url
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page  

@validatingPopUpWindow
Scenario: Validate Program Details Popup window
Given Admin is on Manage Program Page for program
When Admin clicks A New Program button for program
Then Admin should see a popup open for Program details with empty form along with SAVE and CANCEL button and Close(X) Icon on the top right corner of the window


@validateinputfieldsandtextboxes 
Scenario: Validate input fields and their text boxes in Program details form  
Given Admin is on Manage Program Page for program
When Admin clicks A New Program button for program
Then Admin should see two input fields and their respective text boxes in the program details window for program

@validatingradiobuttonforpsbugneedtocheck
Scenario: Validate radio button for Program Status 
Given Admin is on Manage Program Page for program
When Admin clicks A New Program button for program
Then Admin should see two radio button for Program Status

@validatingEmptyformsubmisionDifferntBackGround
Scenario: Empty form submission
Given Admin is on Program Details Popup window for program
When Admin clicks Save button without entering any data for program
Then Admin gets a Error message alert for program


@addingonlyprogramname
Scenario Outline: Enter only Program Name 
Given Admin is on Program Details Popup window for program
When Admin enters only Program Name  in text box  using sheetname "<SheetName>" and RowNumber <Rownumber> and clicks Save button for program
Then Admin gets a message alert 'Description is required' for program
Examples: 
      | SheetName | Rownumber |
      |program    |         0 |

@addingonlyprogramdescription
Scenario Outline: Enter only Program Description
Given Admin is on Program Details Popup window for program
When Admin enters only Program description in text box using sheetname "<SheetName>" and RowNumber <Rownumber> and clicks Save button for program
Then Admin gets a message alert 'Name is required' for program
Examples: 
      | SheetName | Rownumber |
      |program    |         0 |

@selectingstatusonly
Scenario: Select Status only
Given Admin is on Program Details Popup window for program
When Admin selects only Status and clicks Save button for program
Then Admin gets a message alert 'Name and Description required' for program

@invalidvaluesontextcolumn
Scenario Outline: Validate invalid values on the text column 
Given Admin is on Program Details Popup window for program
When Admin enters only numbers or special char in name and desc column using sheetname "<SheetName>" and RowNumber <Rownumber>  for program
Then Admin gets a Error message alert for program
Examples: 
      | SheetName | Rownumber |
      |program    |         0 |

@validatingcancelicon
Scenario Outline: Validate Cancel/Close(X) icon on Program Details form
Given Admin is on Program Details Popup window for program
When Admin clicks adddetails using sheetname "<SheetName>" and RowNumber <Rownumber> Cancel/Close(X) Icon on Program Details form for program 
Then Program Details popup window should be closed without saving for program
 Examples: 
      | SheetName | Rownumber |
      |program    |         0 |

@validatingsavebutton
Scenario Outline: Validate Save button on Program Details form
Given Admin is on Program Details Popup window for program
When Enter all the required fields with valid values  using sheetname "<SheetName>" and RowNumber <Rownumber> and click Save button for program
Then Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table for program
 Examples: 
      | SheetName | Rownumber |
      |program    |         0 |



@validatingcancel
Scenario Outline: Validate Cancel button on Program Details form
Given Admin is on Program Details Popup window for program
When Admin add programdetails using sheetname "<SheetName>" and RowNumber <Rownumber> and clicks <Cancel>button  for program
Then Admin can see the Program details popup disappears without creating any program for program
Examples: 
      | SheetName | Rownumber |
      |program    |         0 |


