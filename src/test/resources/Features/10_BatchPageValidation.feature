Feature: Batch Page Validation

Background: Logged on the LMS portal
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page

Scenario: Validate landing in Batch page
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Admin should see the "Manage Batch" in the URL

Scenario: Validate header in the Batch Page
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Admin should see the "Manage Batch" in the header_Batch

Scenario: Validate pagination in the Batch Page
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Admin should see the pagination controls under the data table_Batch

Scenario: Validate data table headers in the Batch Page
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete_Batch

Scenario: Validate Delete button in Batch Page
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Admin should be able to see the Delete icon button that is disabled_Batch

Scenario: Validate "+ A New batch" in Batch Page
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Admin should be able to see the + A New batch button_Batch

Scenario: Validate data rows-1
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Each row in the data table should have a checkbox_Batch

Scenario: Validate data rows-2
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Each row in the data table should have a edit icon that is enabled_Batch

Scenario: Validate data rows-3
Given Admin is on dashboard page after Login_Batch
When Admin clicks Batch from navigation bar_Batch
Then Each row in the data table should have a delete icon that is enabled_Batch

Scenario: Validate pop up for adding batch
Given Admin is on dashboard page after Login_Batch
When Admin clicks + A New Batch button after navigating to batch page_Batch
Then A new pop up with Batch details appears_Batch
