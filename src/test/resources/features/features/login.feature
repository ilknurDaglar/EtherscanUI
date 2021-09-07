Feature:the user who already has an account can Sign in

  Background:
    Given the user on the Registration Page

  Scenario Outline: the user who already has an account can Sign in

    When the user who already has an account clicks Signin button
    And the Login page should display
    And the user enters "<username>" to username box
    And the user enters "<password>" to password box
    And the user clicks captca
    And the user clicks Login button
    Then Client portal and services page should open

    Examples:
      | username | password |
      | olacak   | 123456   |


  Scenario: 'Click to sign up' link at the bottom of the page should work
    When the user on the login page
    And the users click Sign up link
    Then  the registration page should display


  Scenario:Forgot your password? link
    When the user on the login page
    And the user clicks Forgot your password? link
    Then Etherscan lost password page should open
