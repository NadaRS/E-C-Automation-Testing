@smoke
Feature: F01_Register | users could register with new accounts

  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    When user enter first name "automation" and last name "tester"
    When user enter date of birth
    When user enter email "test@example.com" field
    When user fills Password fields "P@ssw0rd" "P@ssw0rd"
    Then user clicks on register button
    And success message is displayed