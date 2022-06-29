@smoke
Feature: F08_Wishlist | user could use Wishlist
  Scenario: user could use Wishlist and select HTC One M8 Android L 5.0 Lollipop
    Given user would be navigated to home page
    When user add product to Wishlist
    Then Wishlist notification success is visible

  Scenario: user could opens Wishlist after selecting HTC One M8 Android L 5.0 Lollipop
    Given user would be navigated to home page
    When user add product to Wishlist
    Then user click on Wishlist tab on top of the page