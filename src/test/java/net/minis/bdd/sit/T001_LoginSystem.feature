Feature: Login System.

Scenario: Login System
	Given Login > "http://localhost/login", username: "", password: ""
	When Change to LogIn Page
	And Enters Username and Password
	Then  Logout > "http://localhost/logout"

