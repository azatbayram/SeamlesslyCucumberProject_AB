@SEAMLES-376
Feature: 

	#*{color:#00875A}User Story : {color}*
	#
	#As a user, I should be able to login.
	#
	# 
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#*1-User can login with valid credentials* 
	#2-User can not login with any invalid credentials
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-362
	Scenario Outline: User can login with valid credentials 
		Given the user is on the login page
		When the user enters the valid credential login information
		  | username | <userName> |
		  | password | <password> |
		Then the user should be logged in
		  | url | <URL> |
		And the user should see username under Account icon
		  | username | <userName> |
		
		Examples:
		  | userName   | password         | URL                                                                |
		  | Employee81 | Employee123      | https://qa.seamlessly.net/index.php/apps/files/?dir=/&fileid=33724 |	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can login with valid credentials 
	#*2-User can not login with any invalid credentials*
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-365
	Scenario Outline: User can not login with any invalid credentials
		    Given the user is on the login page
		    When the user enters the invalid credential login information
		    | username | <userName> |
		    | password | <password> |
		    Then the user should see "Wrong username or password." on screen
		
		    Examples:
		    | userName   | password         |
		    | EMPLOYEE81 | EMPLOYEE123      |
		    | Abcd95     | Employee123      |
		    | Employee81 | Azat2548         |	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#*1-User can login with valid credentials *
	#2-User can not login with any invalid credentials
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-366
	Scenario Outline: User can login by pressing ENTER
		Given the user is on the login page
		 When the user enters the valid credential login information and press ENTER
		      | username | <userName> |
		      | password | <password> |
		Then the user should be logged in
		      | url | <URL> |
		And the user should see username under Account icon
		    | username | <userName> |
		
		Examples:
		      | userName   | password         | URL |
		      | Employee81 | Employee123      | https://qa.seamlessly.net/index.php/apps/files/?dir=/&fileid=33724 |	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can login with valid credentials 
	#*2-User can not login with any invalid credentials*
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-367
	Scenario: User can not left user input box as blank
		    Given the user is on the login page
		    When the user entered username as blank
		     | password | Employee123 |
		    Then the user should see "Please fill out this field." on screen for blank username	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can login with valid credentials 
	#*2-User can not login with any invalid credentials*
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-368
	Scenario: User can not left password input box as blank
		    Given the user is on the login page
		    When the user entered password as blank
		      | username | Employee81 |
		    Then the user should see "Please fill out this field." on screen for blank password	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can login with valid credentials 
	#2-User can not login with any invalid credentials
	#*3-User can see the password in a form of dots by default*
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-369
	Scenario: User can see the password in a form of dots by default
		    Given the user is on the login page
		    When the user entered user info
		      | username | Employee81 |
		      |password  |Employee123|
		    Then the user should be see password in form of dots by default
		      |type|password|	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can login with valid credentials 
	#2-User can not login with any invalid credentials
	#3-User can see the password in a form of dots by default
	#*4-User can see the password explicitly if needed*
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-370
	Scenario: User can see the password explicitly if needed
		    Given the user is on the login page
		    And the user entered user info
		      | username | Employee81 |
		      |password  |Employee123|
		    When the user click on eye icon next to password
		    Then the user should see password explicitly
		      |type|text|	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can login with valid credentials 
	#2-User can not login with any invalid credentials
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#*5-User can see an option link like "forgot password" on the login page to be able to reset the password*
	#6-User can see valid placeholders on Username and Password fields
	@SEAMLES-371
	Scenario: User can see an option link like "forgot password" on the login page to be able to reset the password
		Given the user is on the login page
		And the user should able to see Forgot password? link on login page
		When the user click on Forgot password? link
		Then the user should see "Reset password" button on next page	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#{color:#DE350B}_Acceptance Criteria:_{color}
	#1-User can login with valid credentials 
	#2-User can not login with any invalid credentials
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#*6-User can see valid placeholders on Username and Password fields*
	@SEAMLES-372
	Scenario: User can see valid placeholder on Username field
		      Given the user is on the login page
		      Then the user should see "Username or email" placeholder on Username field	

	#*{color:#00875A}User Story : {color}*
	#As a user, I should be able to login.
	#
	#_{color:#DE350B}Acceptance Criteria:{color}_
	#1-User can login with valid credentials 
	#2-User can not login with any invalid credentials
	#3-User can see the password in a form of dots by default
	#4-User can see the password explicitly if needed
	#5-User can see an option link like "forgot password" on the login page to be able to reset the password
	#*6-User can see valid placeholders on Username and Password fields*
	@SEAMLES-373
	Scenario: User can see valid placeholder on Password field
		      Given the user is on the login page
		      Then the user should see "Password" placeholder on Password field