Feature: Testing the account editing form

  Background:
    Given the home page is opened
    And the My Account option is clicked
    And the user is logged in
    And the Edit Account option is clicked
    And the fields are filled with valid data

  Scenario Outline:
    Given the field <field> is filled with '<field_data>'
    When the Continue (save edit) button is clicked
    Then the message <message> should be shown
    Then successfully logged out
    Examples:
      | field               | field_data                     | message            |
      | firstname           | null                           | namelength         |
      | email               | t@t                            | emailvalid         |
      | telephone           | 00                             | phonelength        |
      | none                | null                           | success            |

