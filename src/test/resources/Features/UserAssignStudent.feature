@AssignStudent
Feature: Validating Assign Student Functionality

  Background: Admin gives correct lms portal url
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page

  @AssignStudent_Validate_Landing_ManageUSer
  Scenario: Validate landing in User page
    Given Admin is on dashboard page after login
    When Admin clicks User from navigation bar
    Then Admin should see the "Manage User" in the URL

  @AssignStudent_PopUp_Window_PageValidation
  Scenario: Validate Assign Student Popup window
    Given Admin is in manage user page
    When Admin clicks Assign Student button
    Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

  @AssignStudent_Validate_InputFields_TextBoxes
  Scenario: Validate input fields and their text boxes in Assign Student form
    Given Admin is in manage user page
    When Admin clicks Assign Student button
    Then Admin should see User Role as R03 and other fields Student Email id, Program Name, Batch Name and Status with respective input boxes

  @AssignStudent_Validate_DropDown_Boxes_For_StudentEmailId_ProgramName_BatchName
  Scenario: Validate Dropdown in Assign Student Form
    Given Admin is in manage user page
    When Admin clicks Assign Student button
    Then Admin should see drop down boxes with valid data for Student Email id,Program Name and Batch Name

  @AssignStudent_Validate_Radio_Button
  Scenario: Validate radio button in Assign Student Form
    Given Admin is in manage user page
    When Admin clicks Assign Student button
    Then Admin should see two radio button for Status

  @AssignStudent_Validate_Empty_Form_Submission
  Scenario: Empty Form Submission
    Given Admin is in Assign Student details pop up page
    When Admin clicks Save button with entering any data
    Then Admin gets a Error message alert

  @AssignStudent_Validate_Cancel/Close_Icon
  Scenario: Validate Cancel or Close icon on Assign Student form
    Given Admin is in Assign Student details pop up page
    When Admin clicks Cancel or Close Icon on Assign Student form
    Then Assign Student popup window should be closed without saving

  @AssignStudent_Validate_Cancel_Button
  Scenario: Validate Cancel button on Assign Student form
    Given Admin is in Assign Student details pop up page
    When Admin clicks Cancel button
    Then Admin can see the Assign Student popup disappears without assigning
