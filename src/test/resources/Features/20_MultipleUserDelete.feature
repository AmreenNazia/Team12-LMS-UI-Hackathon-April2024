Feature: Delete mutiple user
Background: Admin is on dashboard page after Login
and clicks User on the navigation bar

  Given Admin is in login page
  When Admin enter valid credentials  and clicks login button 
  Then Admin should land on dashboard page
	 Then Admin clicks User on the navigation bar
	 
	 
	 Scenario: Validate Common Delete button enabled after clicking on any checkbox
	 Given Admin is on the Manage User Page
	 When Admin clicks any checkbox in the data table
	 Then Admin should see common delete option enabled under header Manage User
	 
	 @multidelete
	 Scenario: Validate multiple user deletion by selecting Single checkbox
	 Given Admin clicks delete button under header after selecting the checkbox in the data table
	 Given Admin is on Confirm Deletion alert
	 When Admin clicks yes option
	 Then Admin should land on Manage User page and can see the selected users are deleted from the data table
	 
	 Scenario: Validate multiple user deletion by selecting Single checkbox 2
	 Given Admin clicks delete button under header after selecting the checkbox in the data table
	 Given Admin is on Confirm Deletion alert
	 When Admin clicks No option
	 Then Admin should land on Manage User page and can see the selected users are not deleted from the data table
	 
	 Scenario: Validate multiple user deletion by selecting multiple check boxes
	 Given Admin clicks delete button under header after selecting multiple checkboxes in the data table
	 Given Admin is on Confirm Deletion alert
	 When Admin clicks yes option
	 Then Admin should land on Manage User page and can see the selected users are deleted from the data table
	 
	 Scenario: Validate multiple user deletion by selecting multiple check boxes 2
	 Given Admin clicks delete button under header after selecting multiple checkboxes in the data table
	 Given Admin is on Confirm Deletion alert
	  When Admin clicks No option
	  Then Admin should land on Manage User page and can see the selected users are not deleted from the data table
 
