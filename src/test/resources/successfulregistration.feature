Feature: Testing the registration functionality

  Background:
    Given the home page is opened

    Scenario:
      Given the My Account option is clicked
      And the Register option is clicked
      And the field "//*[@id=\"input-firstname\"]" is filled with "Firstname"
      And the field "//*[@id=\"input-lastname\"]" is filled with "Lastname"
      And the email is filled with random email address
      And the field "//*[@id=\"input-telephone\"]" is filled with "061234455"
      And the field "//*[@id=\"input-password\"]" is filled with "FirstLast"
      And the field "//*[@id=\"input-confirm\"]" is filled with "FirstLast"
      And the Agree to Privacy Policy is checked true
      And the Continue button is clicked
      Then the success message is shown
      Then successfully logged out
