@contact-us @regression

Feature: Contact Us Page

  Background:
    Given user accesses the webdriver university contact us page

  Scenario: Validate Successful Submission - Unique Data
    When user enters a unique first name
    And user enters a unique last name
    And user enters a unique email address
    And user enters a unique comment
    And user clicks on the submit button
    Then user should be presented with a successful contact us submission message "Thank You for your Message!"

  Scenario: Validate Successful Submission - Specific Data
    When user enters a specific first name Joe
    And user enters a specific last name Blogs
    And user enters a specific email address joeblogs@gmail.com
    And user enters a specific comment "Hello World"
    And user clicks on the submit button
    Then user should be presented with a successful contact us submission message "Thank You for your Message!"