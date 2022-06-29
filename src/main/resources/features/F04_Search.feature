@smoke
Feature: F04_search | user could search for products
  Scenario Outline: user can search for products
    Given user goes to home page
    When user enters product name "<productName>" in search field

    Examples:
      | productName |
      | book |
      | laptop |
      | nike |

  Scenario Outline: user can search for products by sku
    Given user goes to home page
    When user enters product sku "<productSKU>" in search field

    Examples:
      | productSKU |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
