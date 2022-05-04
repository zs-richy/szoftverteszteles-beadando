Feature: Testing the login functionality

  Background:
    Given the home page is opened


    Scenario:
      Given the My Account option is clicked
      And the Login option is clicked
      And the field email field is filled with "teszt@elek.com"
      And the field password field is filled with "TesztElek"
      And the Login button is pressed
      Then the My Account page is shown
      Then successfully logged out
