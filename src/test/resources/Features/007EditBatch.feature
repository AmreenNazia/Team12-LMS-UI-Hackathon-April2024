Feature: Edit Batch

Background: Logged on the LMS portal
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page

Scenario: Validate row level edit icon
Given Admin is on Manage Batch page after clicking on Batch link in Dashboard, where The edit icon on row level in data table is enabled_Batch
When Admin clicks the edit icon_Batch
Then A new pop up with "Batch Details" appears on Manage Batch_Batch

Scenario: Check if the fields are updated
Given Admin clicks the edit icon in Manage Batch page after navigating to Batch from Dashboard_Batch
When Update the fields with valid values and click save_Batch
Then The updated batch details should appear on the data table_Batch

Scenario: Check if the update throws error with invalid valued
Given Admin clicks the edit icon in Manage Batch page after navigating to Batch from Dashboard_Batch
When Update the fields with invalid values and click save_Batch
Then Error message should appear like invalid values_Batch

Scenario: Check if you get error message when mandatory fields are erased
Given Admin clicks the edit icon in Manage Batch page after navigating to Batch from Dashboard_Batch
When Erase data from mandatory field_Batch
Then Error message should appear fields are mandatory_Batch

Scenario: Check if description field is optional in update
Given Admin clicks the edit icon in Manage Batch page after navigating to Batch from Dashboard_Batch
When Erase data from description field_Batch
Then The updated batch details after erase should appear on the data table_Batch