Feature: User Page Validation

Background: Admin gives correct lms portal url
   Given Admin is in login page
   When Admin enter valid credentials  and clicks login button 
   Then Admin should land on dashboard page
   
Scenario: Validate landing in User page
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see the "Manage User" in the URL

Scenario: Validate landing in User page
Given Admin is on dashboard page after Login
When Admin clicks "User" from navigation bar
