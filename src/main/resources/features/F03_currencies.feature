@smoke
  Feature: F03_currencies | user could change currencies

    Scenario: user could change currencies
      Given user go to home page
      When user changes currency
      Then check changes