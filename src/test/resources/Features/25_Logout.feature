@verifyLogout
Feature: Logout Verification

 Background: Admin landed at home page
 Given Admin launch the browser
 When Admin gives the correct LMS portal URL
 
 Scenario: Verify Logout button function
 When Admin click Logout button on navigation bar
 Then Admin should land on login in page