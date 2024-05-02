Feature: Add new Batch

Background: Logged on the LMS portal
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page

Scenario: Check if the fields exist in popup
Given A new pop up with "Batch Details" appears when admin clicks on + A New Batch button after navigated to Batch page_Batch
Then The pop up should include the fields Name, Number of classes and Description as text box, Program Name as drop down, Status as radio button, Number of classes as text box_Batch

Scenario: Check if description is optional field
Given A new pop up with "Batch Details" appears when admin clicks on + A New Batch button after navigated to Batch page_Batch
When Fill in all the fields except description with valid values and click save_Batch
Then The newly added batch should be present in the data table in Manage Batch page_Batch

Scenario: Check if the batch details are added in data table
Given A new pop up with "Batch Details" appears when admin clicks on + A New Batch button after navigated to Batch page_Batch
When Fill in all the fields with valid values and click save_Batch
Then The newly added batch should be present in the data table in Manage Batch page with valid data_Batch

Scenario: Check for error messages for invalid fields
Given A new pop up with "Batch Details" appears when admin clicks on + A New Batch button after navigated to Batch page_Batch
When any of the fields have invalid values_Batch
Then Error message should appear_Batch

Scenario: Check for error messages for mandatory fields
Given A new pop up with "Batch Details" appears when admin clicks on + A New Batch button after navigated to Batch page_Batch
When Any of the mandatory fields are blank_Batch
Then Error message should appear missing mandatory fields_Batch
#
