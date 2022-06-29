@smoke
Feature: F06_slider | user could click on sliders
  Scenario: user could click on first slider Nokia Lumia 1020
    Given user is navigated to home page
    When user click on Nokia slider
    Then Confirm Nokia false reaction

  Scenario: user could click on second slider iPhone
    Given user is navigated to home page
    When user click on iPhone slider
    Then Confirm iPhone false reaction