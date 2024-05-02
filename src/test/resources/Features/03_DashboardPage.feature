@Dashboard
Feature: Dashboard page

Background: Admin gives the correct LMS portal URL
Given Admin is in login page
When Admin enter valid credentials  and clicks login button

@VerifyManageProgramHeader
Scenario: Verify after login  admin lands on manage program as dashboard page
Then Admin should see manage program as header 

@VerifyResponseTime
Scenario: Verify the response time
Then Maximum navigation time in milliseconds, defaults to 30 seconds

@VerifyBrokenLink
Scenario: Verify broken link
Then HTTP response >= 400. Then the link is broken in dashboard page

@VerifyLMSTitle
Scenario: Verify LMS title 
Then Admin should see LMS -Learning management system  as title


@VerifyTitleAlignment
Scenario: Verify LMS Title Alignment
Then LMS title should be on the top left corner of page

@VerifyTitleSpelling
Scenario: Validate LMS title has correct spelling and space
 Then Admin should see correct spelling and space in LMS title
 
 @verifyNavigationBarSpelling
 Scenario: Validate navigation bar text
 Then Admin should see correct spelling in navigation bar text
 |Program|
 |Batch|
 |User|
 |Logout|
 
 
 @verifyNavigationBarAlignment
 Scenario: Validate alignment for navigation bar
 Then Admin should see the navigation bar text on the top right side

 @verifyNavBarprogramOrder
 Scenario: Validate navigation bar order  1st Program
 Then Admin should see program in the 1st place
 
 @verifyNavBarbatchOrder
 Scenario: Validate navigation bar order  2nd Batch
 Then Admin should see batch in the 2nd place
 
 @verifyNavBarUserOrder
 Scenario: Validate navigation bar order 3rd User
 Then Admin should see user in the  3rd place
 
 @verifyNavBarLogout
 Scenario: Validate navigation bar order 4th Logout
 Then Admin should see logout in the 4th place
 
 
 