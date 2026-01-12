@login @regression

Feature: Login Page

  Background:
    Given user accesses the webdriver university login page

  @smoke
  Scenario: Validate Successful Login
    When user enters a username webdriver
    And user enters a password webdriver123
    And user clicks on the login button
    Then user should be presented with a successful login message "validation succeeded"

  Scenario: Validate Unsuccessful Login - Incorrect password
    When user enters a username webdriver
    And user enters a password password
    And user clicks on the login button
    Then user should be presented with a unsuccessful login message "validation failed"

  @smoke
  Scenario Outline:
    When user enters a username <username>
    And user enters a password <password>
    And user clicks on the login button
    Then user should be presented with a unsuccessful login message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | password     | validation failed      |
      | joe_blogs | webdriver1   | validation failed      |