@programNavigation
Feature: Navigation Validation from Manage Program to other Pages

Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
Given Admin is in login page
When Admin enter valid credentials  and clicks login button
Then Admin should land on dashboard page

@batchLinkNavigation
Scenario: Batch link on navigation bar on Program page
When  Admin clicks on Batch link on Manage Program page
Then  Admin is re-directed to Batch page from Program page

@programLinkNavigation
Scenario:  User link on navigation bar on Program page
When Admin clicks on User link on Manage Program page
Then Admin is re-directed to User page from Program page

@LogoutLinkNavigation
Scenario: Logout link on navigation bar on Program page
When Admin clicks on Logout link on Manage Program page  
Then Admin is re-directed to Login page from Program page