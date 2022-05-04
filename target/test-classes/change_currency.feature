Feature: Testing the currency changing functionality

  Background:
    Given the home page is opened
    And the main searchbar is filled with "mac"
    And the magnifying glass is pressed

  Scenario Outline:
    Given the currency dropdown is clicked
    And the <currency> is selected
    Then the price should be in <currency>
    Examples:
      | currency  |
      | eur       |
      | usd       |
      | gbp       |

