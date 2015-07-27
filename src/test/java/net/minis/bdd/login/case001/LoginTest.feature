Feature: Login System.

Scenario: Login System

Given Login system "http://localhost:8080/login", username: "username", password: "password"

Then  Logout system "http://localhost:8080/logout"
