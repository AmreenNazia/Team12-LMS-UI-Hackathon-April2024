Feature: Add New User

  Background: Admin gives correct lms portal url
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page

  Scenario: Validate User Details Popup window
    Given Admin is on Manage User Page
    When Admin clicks "Add New User" button
    Then Admin should see pop up open for user details

  Scenario: Validate input fields and text boxes in user details form
    Given Admin is on Manage User Page
    When Admin clicks "Add New User" button
    Then Admin should see  text boxes for the fields

  Scenario: Validate drop downs in new user form
    Given Admin is on Manage User Page
    When Admin clicks "Add New User" button
    Then Admin should see drop downs for the fields

  Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin enters mandatory fields in the form using sheetname "<SheetName>" and RowNumber <Rownumber> and Submits the form
    Then Admin gets message User added Successfully

    Examples: 
      | SheetName | Rownumber |
      | User      |         0 |

  Scenario Outline: Check if user is created when only optional fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin skips to add value in mandatory field using sheetname "<SheetName>" and RowNumber <Rownumber> and Submits the form
    Then Admin should see error message below the test field and the field will be highlighed in red color

    Examples: 
      | SheetName | Rownumber |
      | User      |         1 |

  Scenario Outline: check if user is created when invalid data is entered in all of the fields
    Given Admin is on  User details pop up
    When Admin enters invalid data in all of the  fields using sheetname "<SheetName>" and RowNumber <Rownumber> and Submits the form
    Then Admin gets error message and user is not created

    Examples: 
      | SheetName | Rownumber |
      | User      |         2 |

  Scenario Outline: Empty form submission
    Given Admin is on User details pop up
    When Admin clicks on submit button without entering data
    Then user wont be created and Admin gets error message

  Scenario Outline: Validate Cancel or Close icon on User Details form
    Given Admin is on User details pop up
    When Admin clicks Cancel or Close Icon on User Details form
    Then User Details popup window should be closed without saving

  Scenario: Validate Cancel button on User Details form
    Given Admin is on User details pop up
    When Admin clicks Cancel button
    Then Admin can see the User details popup disappears without adding any user

  Scenario Outline: Check if the user details are added in data table
    Given Admin is on User details pop up
    When Admin enters all the fields in the form using sheetname "<SheetName>" and RowNumber <Rownumber> and Submits the form
    Then The newly added user should be present in the data table in Manage User page

    Examples: 
      | SheetName | Rownumber |
      | User      |         0 |
