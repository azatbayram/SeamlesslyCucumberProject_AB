@SEAMLES-377
Feature: 

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to log out.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#*1-User can log out and ends up in login page*
	#2-User can not go to home page again by clicking step back button after successfully loged out.
	@SEAMLES-374
	Scenario: User can log out and ends up in login page
		    Given the user is on the login page
		    And the user enters the below login information
		    | username | Employee81 |
		    | password | Employee123 |
		    When the user click on logout
		    Then the user should endup on the login page
		    |loginPageURL | https://qa.seamlessly.net/index.php/login?clear=1 |	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to log out.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can log out and ends up in login page
	#*2-User can not go to home page again by clicking step back button after successfully loged out.*
	@SEAMLES-375
	Scenario: User can not go to home page again by clicking step back button after successfully loged out
		    Given the user is on the login page
		    And the user enters the below login information
		      | username | Employee81 |
		      | password | Employee123 |
		    When the user click on logout
		    Then the user should not go to home page by clicking step back button