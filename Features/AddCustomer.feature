Feature: Customer 

	Background:steps common for all scenarios
	Given  User launch Chrome browser 
	When  User opens URL "https://admin-demo.nopcommerce.com/login" 
	And  User enters Email as "admin@yourstore.com" and Password as "admin" 
	And  Click on Login 
	Then  User can view Dashboard 
	
	@regression
	Scenario: Add New Customer 
	When  User click on customers Menu 
	And  click on customers Menu Item 
	And  click on Add new button 
	Then  User can view Add new customer page 
	When  user enter customer info 
	And  click on Save button 
	Then  user can view confirmation message "The new customer has been added successfully." 
	And  close browser 
	
	@regression
	Scenario: Search Customer by Email 
	When  User click on customers Menu 
	And  click on customers Menu Item 
	And  Enter customer Email 
	When  Click on search button 
#	Then  User should found Email in the Search table 
	And  close browser 
	
	@sanity
	Scenario: Search Customer by Name 
	When  User click on customers Menu 
	And  click on customers Menu Item 
	And  Enter customer FirstName
	And  Enter customer LastName
	When  Click on search button 
#	Then  User should found Name in the Search table 
	And  close browser 
	
	
	
