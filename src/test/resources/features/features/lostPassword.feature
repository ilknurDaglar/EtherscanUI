Feature:the user forgets password

  Background:
    Given the user on the Registration Page
  Scenario: he user forgot password and tries to get a new password
    When the user is on the lostpassword page
    And the user enters "son1gayret@gmail.com" to emailbox
    And the user clicks the captcha
    And the user clicks the Reset Password button
    Then You've successfully requested a forgot password. message should display


  Scenario: the user clicks Back to sign in link
    When the user is on the lostpassword page
    And the user clicks Back to sign in link
    Then the user turns back Login page

