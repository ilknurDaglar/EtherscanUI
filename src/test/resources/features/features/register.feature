Feature: the user wants to register a new account

  Background:

    Given the user on the Registration Page

  Scenario: the user registers with valid credentials
    When the user enters valid username
    And the user enters valid email
    And the user enters valid password
    And the user enters same password to Confirm password box
    And the user clicks the Agree to the Terms button
    And the user clicks I"m not a Robot captcha
    And the user the clicks create account box
    Then Successfully registered and pending for email verification page should display


  Scenario Outline: Invalid username should not be accepted
    When the user enters invalid "<username>"
    Then Username is invalid message should display
    Examples:
      | username |
      | abc      |
      | 1234%    |
      | ab cdef  |


   ### BUG 1 ###
  Scenario Outline: Invalid email should not be accepted
    When the user enters invalid email address"<email>"
    Then please enter a valid mail is should display
    Examples:
      | email               |
      | ?_-!#%*$^&+~@da.com |
      | abc{#}def@a.com     |
      | Edwin@0             |


   ### BUG 2 ###
  Scenario Outline: Invalid password should not be accepted
    When the user enters invalid password "<password>"
    Then Please choose a stronger password message should display
    And the user enters different password to confirm password box
    Then Password does not match, please check again message should appear
    Examples:
      | password |
      | @@@@@    |
      |          |
      | .....    |
      | $$$ 5    |


 Scenario: User enters password with different strength

   When the user enters weak password
   Then Strength: Weak! message should display
   And the user enters medium strength password
   Then Strength: Medium! message should display
   And the user enters strong password
   Then Strength: Strong! message should display




@wip
    ### BUG 3 ###
  Scenario:Password length will be at least 5 characters or 6 characters
    When  the user enters two characters in the password box
    Then Your password must be at least five characters long. message should display
    When the user enters valid username
    And the user enters valid email
    And User enters five character password
    And the user enters same five character password to Confirm password box
    And the user clicks the Agree to the Terms button
    And the user clicks I"m not a Robot captcha
    And the user the clicks create account box
    And Password too short. Minimum of six characters required, message should display
    Then two messages should have same number


  Scenario: 'I agree to term' is not clicked
    When the user enters valid username
    And the user enters valid email
    And the user enters valid password
    And the user enters same password to Confirm password box
    And the user clicks I"m not a Robot captcha
    And the user the clicks create account box
    Then Please accept our Terms and Conditions. message should display


  Scenario: 'Click the sign in' link at the bottom of the page should work
    When the users click Sign in link
    Then login page should display


