Feature: Testing the cart functionality

  Background:
    Given the home page is opened
    And the My Account option is clicked
    And the user is logged in
    And the cart is empty

  Scenario:
    Given the magnifying glass is pressed
    And the Keyword is filled with "MacBook Air"
    And the Search button is pressed
    And the "MacBook Air" is added to cart
    When the cart is opened
    Then the cart contains 1 "MacBook Air"
    Then the cart is empty
    Then successfully logged out

