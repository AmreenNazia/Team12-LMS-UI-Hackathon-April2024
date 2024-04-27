@login 
Feature: Login Page Validation

  Background: Admin gives correct lms portal url
   Given Admin is in login page
   
@validLogin 
   Scenario: Validate login with valid credentials
   When Admin enter valid credentials  and clicks login button 
   Then Admin should land on dashboard page
   
 @invalidLogin  
  Scenario: Validate login with invalid credentials
   When Admin enter invalid credentials and clicks login button
   Then Error message please check username/password
   
   @nullUser
   Scenario: Validate login credentials with null username
   When Admin enter value only in password and clicks login button 
   Then Error message please enter username should displayed
   
   @nullPassword
    Scenario: Validate login credentials with null password
   When Admin enter value only in username and clicks login button 
   Then Error message please enter password should displayed
   
   @keyboardAction
   Scenario: verify login button action through keyboard
   When Admin enter valid credentials and clicks login button through keyboard
   Then Admin should land on dashboard page
   
   @mouseAction
   Scenario: verify login button action through mouse
   When Admin enter valid credentials  and clicks login button through mouse
   Then Admin should land on dashboard page