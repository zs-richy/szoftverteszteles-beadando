Feature: Testing the Contact Us page

  Background:
    Given the home page is opened
    And the Contact Us option is clicked

    Scenario Outline:
      Given the name is filled with "Teszt Elek"
      And the contact email is filled with '<email>'
      And the enquiry is filled with '<enquiry>'
      When the Submit button is clicked
      Then the <contactUsMessage> is shown
      Examples:
        | email               | enquiry                   | contactUsMessage   |
        | teszt1@teszt1       | Enquiry test value        | emailNotValid      |
        | teszt1@gmail.com    | pas                       | enquiryLength      |
