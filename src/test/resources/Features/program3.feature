#@program3
#Feature: Edit Program Details
#Background: Admin gives correct lms portal url
#Given Admin is in login page
#When Admin enter valid credentials  and clicks login button 
#Then Admin should land on dashboard page 
#
#@validatingeditfeature
#Scenario: Validate Edit Feature
#Given Admin is on Manage Program Page for program
#When Admin clicks Edit button on the data table for any row for program
#Then Admin should see a popup open for Program details to edit for program
#
#@editingprogramnamewithdifferntbackground
#Scenario Outline: Edit Program Name
#Given Admin is on Program Details Popup window to Edit for program
#When Admin edits the Name column  using sheetname "<SheetName>" and RowNumber <Rownumber> and clicks save button for program
#Then Admin gets a message "Program Updated" alert and able to see the updated name in the table for the particular program
#Examples: 
      #| SheetName | Rownumber |
      #|program    |         0 |
#@editprogramdes
#Scenario Outline: Edit Program description
#Given Admin is on Program Details Popup window to Edit for program
#When Admin edits the Description column using sheetname "<SheetName>" and RowNumber <Rownumber> and clicks save button for program
#Then Admin gets a message "Program Updated" alert and able to see the updated description in the table for the particular program
#Examples: 
      #| SheetName | Rownumber |
      #|program    |         0 |
#
#
#
#@changingprogramstatus
#Scenario: Change Program Status
#Given Admin is on Program Details Popup window to Edit for program
#When Admin changes the Status and clicks save button for program
#Then Admin gets a message "Program Updated" alert and able to see the updated status in the table for the particular program
#
#
#@validatinginvalidvaluesontextcolumn
#Scenario Outline: Validate invalid values on the text column
#Given Admin is on Program Details Popup window to Edit for program
#When Admin enters only numbers or special char in name and desc column using sheetname "<SheetName>" and RowNumber <Rownumber> for program
#Then Admin gets a Error message alert  for program
#Examples: 
      #| SheetName | Rownumber |
      #|program    |         0 |
#
#
#@validatingcancelbuttononedtpopup 
#Scenario Outline: Validate Cancel button on Edit popup
#Given Admin is on Program Details Popup window to Edit for program
#When Admin edit using sheetname "<SheetName>" and RowNumber <Rownumber> and clicks Cancel button on edit popup for program
#Then Admin can see the Program details popup disappears and can see nothing changed for particular program  
#Examples: 
      #| SheetName | Rownumber |
      #|program    |         0 |
#
#@validatingsavbuttononeidtpopup
#Scenario Outline: Validate Save button on Edit popup 
#Given Admin is on Program Details Popup window to Edit for program
#When Admin Edit details using sheetname "<SheetName>" and RowNumber <Rownumber> and clicks Save button on edit popup for program
#Then Admin gets a message "Program Updated" alert and able to see the updated details in the table for the particular program 
#Examples: 
      #| SheetName | Rownumber |
      #|program    |         0 |