#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Register an Account
	
	@smoke
	Scenario: Register an Account
	
		Given Open website redirect to register an account
		When User Enter Username
		And User Enter Valid Email
		And User enter valid password
		And User Enter Register Button
		Then User is redirected to Dashboard
		
	@smoke
	Scenario: Login an account
		Given Valid Credentials
		When user enter valid username
		And enter valid password
		And click on login button
		Then user redirected to dashboard


    
  


