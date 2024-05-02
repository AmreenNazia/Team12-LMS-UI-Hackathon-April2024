@Delete2
Feature: Multiple Delete Program
Background: Admin gives correct lms portal url
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page 

@validatingcommonDeletebuttonEnabled
Scenario: Validate Common Delete button enabled after clicking on any checkbox
Given Admin is in Manage Program page for programpage
When Admin clicks any checkbox in the data table for programpage
Then Admin should see common delete option enabled under header Manage Program for programpage

@ValidatemultipleprogramdeletionbyselectingSinglecheckbox
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert for programpage
When Admin clicks <YES> button on the alert for programpage
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table for programpage

@ValidatemultipleprogramdeletionbyselectingSinglecheckbox1
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert for programpage
When Admin clicks <NO> button on the alert for programpage
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table for programpage

@Validatemultipleprogramdeletionbyselectingmultiplecheckboxes
Scenario: Validate multiple program deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert for programpg
When Admin clicks <YES> button on the alert for programpg
Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table for programpg

@Validatemultipleprogramdeletionbyselectingmultiplecheckboxes1
Scenario: Validate multiple program deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert for programpg
When Admin clicks <NO> button on the alert for programpg
Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table for programpg

