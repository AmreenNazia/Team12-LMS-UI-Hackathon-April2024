Feature: Delete user
Background: Admin is on dashboard page after Login
 and clicks User on the navigation bar
  
  Given Admin is in login page
  When Admin enter valid credentials  and clicks login button 
  Then Admin should land on dashboard page
	 Then Admin clicks User on the navigation bar
	
	
	Scenario: Validate row level delete icon
	Given Admin is on the Manage User Page
	When Admin clicks the delete icon
	Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
	
	@delete
	Scenario: Click Yes on the deletion window
	Given Admin is on Confirm Deletion alert
	When Admin clicks yes option
	Then Admin gets a message "User Deleted" alert and do not see that user in the data table
	
	
	Scenario: Click No on the deletion window
	Given Admin is on Confirm Deletion alert
	When Admin clicks No option
	Then Admin can see the deletion alert disappears without deleting
	
	
	Scenario: Validate Close(X) icon on the Confirm Deletion alert
	Given Admin is on Confirm Deletion alert
	When Admin will  click the close button
	Then Admin can see the deletion alert disappears without any changes
	
	