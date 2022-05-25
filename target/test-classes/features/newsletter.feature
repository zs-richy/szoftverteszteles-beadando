Feature: Testing the newsletter subscription changing

  Background:
    Given the home page is opened
    And the My Account option is clicked
    And the user is logged in

  Scenario Outline:
    Given the Newsletter option is clicked
    And the option '<option>' is selected
    Then the successfully updated message should be shown
    When the Newsletter option is clicked
    Then the previously selected '<option>' should be selected
    Then successfully logged out

    Examples:
    | option |
    | yes    |
    | no     |
