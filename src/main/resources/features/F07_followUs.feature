@smoke
Feature: F07_FollowUs | user could choose from FollowUs
  Scenario: user could choose facebook follow
    Given user will be navigated to home page
    When user click on facebook
    Then "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user could choose twitter follow
    Given user will be navigated to home page
    When user click on twitter
    Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user could choose rss follow
    Given user will be navigated to home page
    When user click on rss
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: user could choose youTube follow
    Given user will be navigated to home page
    When user click on youTube
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab