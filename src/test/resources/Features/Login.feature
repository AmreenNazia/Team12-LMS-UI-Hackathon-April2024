Feature: Login Page Validation

  Background: Admin gives correct lms portal url
   Given Admin is in login page
   
   
   Scenario: Validate login with valid credentials
   When Admin enter valid credentials  and clicks login button 
   Then Admin should land on dashboard page