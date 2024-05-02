Feature: Sort user

Background: Admin is on dashboard page after Login
 and clicks User on the navigation bar

  Given Admin is in login page
  When Admin enter valid credentials  and clicks login button
  Then Admin should land on dashboard page
	 Then Admin clicks User on the navigation bar


 @sort
   Scenario: sort user by id
	Given Admin is on the Manage User Page
	When Admin clicks on ID sort icon
	Then Admin should see User details are sorted by id

	Scenario: sort user by name
	Given Admin is on the Manage User Page
	When Admin clicks on name sort icon
	Then Admin should see User details are sorted by name

	Scenario: sort user by Location
	Given Admin is on the Manage User Page
	When Admin clicks on Location sort icon
	Then Admin should see User details are sorted by Location

	Scenario: sort user by Phone number
	Given Admin is on the Manage User Page
	When Admin clicks on Phone number sort icon
	Then Admin should see User details are sorted by Phone number

