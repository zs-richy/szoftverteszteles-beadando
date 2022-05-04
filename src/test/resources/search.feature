Feature: Testing the search functionality

  Background:
    Given the home page is opened
    And the magnifying glass is pressed
    And the Keyword is filled with mac
    And the category 'Desktops' is selected

    Scenario Outline:
      Given the subcategories checkbox is selected: <isSubcatCbSelected>
      And the search in descriptions checkbox is selected: <isDescriptionCbSelected>
      And the Search button is pressed
      Then the product '<product>' is shown in the results
      Examples:
        | isSubcatCbSelected | isDescriptionCbSelected | product                         |
        | true               | false                   | iMac                            |
        | false              | true                    | iPhone                          |
