Feature: Assign Staff

  Background: Admin gives correct lms portal url
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page

  Scenario: Validate Assign Staff Popup window
  Given Admin is in manage user page
  When Admin clicks Assign Staff button
  Then Admin should see a pop up open for assign staff details in the window
  
  Scenario: Validate input fields and their text boxes in Assign Student form
  Given Admin is in manage user page
  When Admin clicks Assign Staff button
  Then Admin should see User Role as R02,and other fields
  
  Scenario: Validate Dropdown in Assign Staff Form
  Given Admin is in manage user page
  When Admin clicks Assign Staff button
  Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name
  
  Scenario: Validate radio button in Assign Staff Form
  Given Admin is in manage user page
  When Admin clicks Assign Staff button
  Then Admin should see two radio button for Status
  
  Scenario: Empty Form Submission
  Given Admin is in Assign Staff details pop up page
  When Admin clicks Save button without entering any data
  Then Admin gets a Error message alert
  
  Scenario Outline: Validate the Assign Staff form page without giving Student Email id
  Given Admin is in Assign Staff details pop up page
  When Admin clicks Save button with entering any data using sheetname "<Sheetname>" and rowNumber <RowNumber>
  Then Admin gets a Error message alert as "Email Id is required."
  
  Examples:
  | Sheetname | RowNumber |
  | User      |         3 |
  
  Scenario Outline: Validate the Assign Staff form page without giving Skill
  Given Admin is in Assign Staff details pop up page
  When Admin clicks Save button without entering Skill data using sheetname "<Sheetname>" and rowNumber <RowNumber>
  Then Admin gets a Error message alert as "Skill is required"
  
  Examples:
  | Sheetname | RowNumber |
  | User      |         3 |
  
  Scenario Outline: Validate the Assign Staff form page without selecting Program
  Given Admin is in Assign Staff details pop up page
  When Admin clicks Save button without selecting program using sheetname "<Sheetname>" and rowNumber <RowNumber>
  Then Admin gets a Error message alert as "Program is required"
  Examples:
  | Sheetname | RowNumber |
  | User      |         3 |
  
  Scenario Outline: Validate the Assign Staff form page without selecting batch
  Given Admin is in Assign Staff details pop up page
  When Admin clicks Save button without selecting batch using sheetname "<Sheetname>" and rowNumber <RowNumber>
  Then Admin gets a Error message alert as "Batch is required"
  Examples:
  | Sheetname | RowNumber |
  | User      |         3 |
  
  Scenario Outline: Validate the Assign Staff form page without giving Status
  Given Admin is in Assign Staff details pop up page
  When Admin clicks Save button without giving status using sheetname "<Sheetname>" and rowNumber <RowNumber>
  Then Admin gets a Error message alert as "Status is required"
  Examples:
  | Sheetname | RowNumber |
  | User      |         3 |
  
  Scenario: Validate Cancel or Close icon on Assign Staff form
  Given Admin is in Assign Staff details pop up page
  When Admin clicks Cancel or Close Icon on Assign Staff form
  Then Assign Staff popup window should be closed without saving
  
  Scenario Outline: Validate Save button on Assign Staff form
    Given Admin is in Assign Staff details pop up page
    When Enter all the required fields with valid values and click Save button using sheetname "<Sheetname>" and rowNumber <RowNumber>
    Then Admin gets a message alert as "Successfully Staff Assigned" 
    Examples:
    | Sheetname | RowNumber |
    | User      |         3 |
Scenario: Validate Cancel button on Assign Staff form
Given Admin is in Assign Staff details pop up page
When Admin clicks on Cancel button 
Then Admin can see the Assign Staff popup disappears without assigning 
