Feature: Edit new user

Background: Admin is on dashboard page after Login
 and clicks User on the navigation bar

  Given Admin is in login page
  When Admin enter valid credentials  and clicks login button
  Then Admin should land on dashboard page
	Then Admin clicks User on the navigation bar


	Scenario: Validate row level edit icon
	Given Admin is on the Manage User Page
	When Admin clicks on the edit icon
	Then A new pop up with User details appears


  @edit
	Scenario Outline: Check if the fields are updated with valid data
	Given Admin is on the User details pop up
	When Update the field "<field_name>" with valid data and click submit
	Then Admin gets message "User Updated Successfully"
	Then verify the updated value for field "<field_name>" in edit page

	Examples:
	|field_name|
	|firstName|
	|middleName|
	|lastName|
	|location|
	|phoneNumber|
	|linkedinURL|
	|email|
	|underGraduate|
	|postGraduate|
	|timezone|
	|userRole|
	|userRoleStatus|
	|userVisaStatus|
	|userComments|


	Scenario Outline: Check if the fields are updated with invalid values
	Given Admin is on the User details pop up
 	When Update the field "<field_name>" with invalid values and click submit
	Then Admin should get "Failed" message

	 Examples:
	|field_name|
	|middleName|
	|lastName|
	|location|
	|phoneNumber|
	|linkedinURL|
	|email|
	|underGraduate|
	|postGraduate|
	|timezone|
	|userRole|
	|userRoleStatus|
	|userVisaStatus|
	|userComments|



	Scenario Outline: Check if the mandatory fields are updated with valid data
	Given Admin is on the User details pop up
	When Update the mandatory fields "<field_name>" with valid values and click submit
	Then Admin gets message "User Updated Successfully"
	Then verify the updated value for field "<field_name>" in edit page
	Examples:
	|field_name|
	|firstName|
	|lastName|
	|location|
	|phoneNumber|
	|userRole|
	|userRoleStatus|
	|userVisaStatus|



	Scenario Outline: Check if the optional fields are updated with valid data
	Given Admin is on the User details pop up
	When Update the optional fields "<field_name>" with valid values and click submit
	Then Admin gets message "User Updated Successfully"
	Then verify the updated value for field "<field_name>" in edit page

	Examples:
	|field_name|
	|middleName|
	|linkedinURL|
	|email|
	|underGraduate|
	|postGraduate|
	|timezone|
	|userComments|


	Scenario Outline: Validate invalid values in the text fields
	Given Admin is on the User details pop up
	When Admin enters only numbers or special char in the text fields "<field_name>" and click submit
	Then Admin should get "Failed" message

	  Examples:
	|field_name|
	|middleName|
	|lastName|
	|location|
	|phoneNumber|
	|linkedinURL|
	|email|
	|underGraduate|
	|postGraduate|
	|timezone|
	|userComments|



	Scenario: Validate Cancel button on Edit popup
	Given Admin is on the User details pop up
	When Admin clicks Cancel button on edit popup
	Then Admin can see the User details popup disappears and can see nothing changed for particular User


