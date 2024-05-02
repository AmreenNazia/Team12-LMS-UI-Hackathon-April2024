Feature: Delete multiple batches 

Background: Logged on the LMS portal
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page

Scenario: Delete multiple batches 
Given Admin successfully navigates from the dashboard to the batch section of the LMS portal, where none of the checkboxes int the datatable are selected_Batch 
Then The delete icon under the Manage Batch header should be disabled_Batch

Scenario: Check for single row delete
Given Admin successfully navigates from the dashboard to the batch section of the LMS portal, where one of the checkbox is selected_Batch
When Click delete icon below Manage Batch header_Batch
Then The respective row in the data table is deleted_Batch

Scenario: Check for multi row delete
Given Admin successfully navigates from the dashboard to the batch section of the LMS portal, where Two or more checkboxes or row is selected_Batch
When Click multi delete icon below Manage Batch header_Batch
Then The respective rows in the data table is deleted_Batch
