Feature: Testing the registration page

  Background:
    Given the home page is opened
    And the My Account option is clicked
    And the Register option is clicked
    And the first name is filled with "Keresztnev"
    And the last name is filled with "Vezeteknev"
    And the telephone is filled with "06301234455"

    Scenario Outline:
      Given the email is filled with '<email>'
      And the password is filled with '<password>'
      And the confirm password is filled with '<confirmpassword>'
      And the Agree to Privacy Policy is checked <agreeChecked>
      And the Continue button is clicked
      Then the message <message> is shown
      Examples:
        | email               | password      | confirmpassword    | agreeChecked | message             |
        | teszt1@gmail.com    | pass01        | pass01             | false        | agreeToPrivacy      |
        | teszt1@gmail.com    | pas           | pass01             | true         | passwordLength      |
        | teszt1@gmail.com    | pass01        | pass02             | true         | passwordMatch       |
        | teszt@teszt         | pass01        | pass01             | true         | emailValid          |
