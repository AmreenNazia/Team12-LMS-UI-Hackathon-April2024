#@Delete1
#Feature: Delete Program
#Background: Admin gives correct lms portal url
#Given Admin is in login page
#When Admin enter valid credentials  and clicks login button 
#Then Admin should land on dashboard page 
#
#
#@validatingDeleteFeature
#Scenario: Delete Feature
#Given  Admin is on Manage Program Page for program
#When Admin clicks Delete button on the data table for any row for program
#Then Admin should see a alert open with heading Confirm along with  YES and NO button for deletion
#
#@validatingdetailsforConfirmDeletionform
#Scenario: Validate details for Confirm Deletion form for program
#Given Admin is on Manage Program Page for program
#When Admin clicks Delete button on the data table for any row for program
#Then Admin should see a message "Are you sure you want to delete <Program name>?"
#
#@ClickYesondeletionwindowdiffenrtbackground
#Scenario: Click Yes on deletion window
#Given Admin is on Confirm Deletion alert for program
#When Admin clicks <YES> button on the alert for program
#Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table  for program
#
#@ClickNoondeletionwindow
#Scenario: Click No on deletion window
#Given Admin is on Confirm Deletion alert for program
#When Admin clicks <NO> button on the alert for program
#Then Admin can see the deletion alert disappears without deleting for program
#
#@ValidatingCancel/Close(X)icononConfirmDeletionalert
#Scenario: Validate CancelClose(X) icon on Confirm Deletion alert 
#Given Admin is on Confirm Deletion alert for program
#When Admin clicks Cancel Icon on Deletion alert for program
#Then Admin can see the deletion alert disappears without any changes for program
