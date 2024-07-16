@Hooks
Feature: signin page Test

@f1
Scenario: valid login input
Given open website
When enter valid input
When click on login button
Then login happens 
Then close browser

@f2
Scenario: invalid login input
Given open website
When enter invalid input
When click on login button
Then failed to login
Then close browser

@f3
Scenario: purchasing product
Given open website
When enter valid input
Then click on login button
Then login happens 
When search product
When add to cart and payment
Then close browser
##Then end report

