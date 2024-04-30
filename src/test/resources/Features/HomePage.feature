@Home
Feature: Home Page Verification

 Background: Admin landed at home page
 Given Admin launch the browser
 When Admin gives the correct LMS portal URL
 
@validUrl
Scenario: Verify admin is able to land on home page
Then Admin should land on the home page

@invalidUrl
Scenario: Verify admin is able to land on home page with invalid URL
When Admin gives the invalid LMS portal URL
Then Admin should recieve 404 page not found error 

@brokenLink
Scenario: Verify for broken link
Then HTTP response >= 400. Then the link is broken in dashboard page

@textSpelling
Scenario: Verify the text spelling in the page 
Then Admin should see correct spellings in all fields 
|User|
|Password|
|Login|

@verifyLogo
Scenario: Verify the company logo
Then Admin should see logo on the left side

@verifyAppName
Scenario: Verify application name
Then Admin should see LMS - Learning Management System

@verifyCompanyName
Scenario: Verify company name
Then Admin should see company name below the app name

@verifyContent
Scenario: Validate sign in content
Then Admin should see "Please login to LMS application"

@verifyField
Scenario: Verify text field is present
Then Admin should see two text field

@verifyTextOnUserField
Scenario: Verify text on the first text field
Then Admin should see "User" in the first text field

@VerifyAsterikNextToUser
Scenario: Verify asterik next to user text
Then Admin should see * symbol next to user text

@verifyTextOnPasswordField
Scenario: Verify text on the second text field
Then Admin should see "Password" in the second text field

@VerifyAsterikNextToPassword
Scenario: Verify asterik next to password text
Then Admin should see * symbol next to password text

@VerifyInputFieldAlignment
Scenario: Verify the alignment input field for the login
Then Admin should see input field on the centre of the page

@verifyLoginButton
Scenario: verify Login is present
Then Admin should see login button 

@verifyLoginAlignment
Scenario: Verify the alignment of the login button
Then Admin should see login button on the centre of the page

@verifyUserTextInGrayColour
Scenario: Verify input descriptive test in user field
Then Admin should see user in gray color

@verifyPasswordTextInGrayColour
Scenario: Verify input descriptive test in password field
Then Admin should see password in gray color