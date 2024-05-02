Feature: Delete Batch

Background: Logged on the LMS portal
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page

Scenario: Validate row level delete icon
Given After navigating to the Manage Batch page from the dashboard by clicking on the Batch tab, the delete icon should be enabled for each row in the data table_Batch
When Admin clicks the delete icon_Batch
Then Alert appears with yes and No option_Batch

Scenario: Validate accept alert
Given After navigating to the Manage Batch page from the dashboard by clicking on the Batch tab, Admin clicks the delete icon_Batch
When Admin click yes option_Batch
Then Batch deleted alert pops and batch is no more available in data table_Batch

Scenario: Validate reject alert
Given After navigating to the Manage Batch page from the dashboard by clicking on the Batch tab, Admin clicks the delete icon_Batch
When Admin click no option_Batch
Then Batch is still listed in data table_Batch