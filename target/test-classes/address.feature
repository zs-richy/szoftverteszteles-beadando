Feature: Testing the address functionality

  Background:
    Given the home page is opened
    And the My Account option is clicked
    And the user is logged in
    And the Address Book is clicked

  Scenario:
    Given the New Address button is pressed
    And the address inputs are filled
    And the continue is clicked
    Then the new address should be at the bottom of the table
    And the New Address button is pressed
    And the address inputs are filled
    And the continue is clicked
    And the Delete (address) button is pressed
    Then the address should be deleted
    Then successfully logged out

