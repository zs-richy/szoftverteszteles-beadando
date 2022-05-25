Feature: Testing the registration functionality

  Background:
    Given the home page is opened

    Scenario:
      Given the My Account option is clicked
      And the Register option is clicked
      And the registration field firstname is filled with "Firstname"
      And the registration field lastname is filled with "Lastname"
      And the registration field email is filled with random email address
      And the registration field telephone is filled with "061234455"
      And the registration field password is filled with "FirstLast"
      And the registration field confirm_password is filled with "FirstLast"
      And the Agree to Privacy Policy is checked true
      When the Continue button is clicked
      Then the success message is shown
      Then successfully logged out
