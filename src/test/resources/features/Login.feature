@login

Feature: Login Page

  Scenario: Validate Successful Login
    Given user accesses the webdriver university login page
    When user enters a username "webdriver"
    And user enters a password webdriver123
    And user clicks on the login button
    Then user should be presented with a successful login message "validation succeeded"

  Scenario: Validate Unsuccessful Login - Incorrect password
    Given user accesses the webdriver university login page
    When user enters a username "webdriver"
    And user enters a password password
    And user clicks on the login button
    Then user should be presented with a unsuccessful login message "validation failed"