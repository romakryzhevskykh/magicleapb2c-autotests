Feature: Make Supply list favorite or deactivate favourite flag from Supply Lists page.

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

  Scenario: Check that user can mark Supply list as favorite on Supply Lists page.
    Given Active not favorite Supply list exists.
    And Open Supply lists page.
    When Mark Supply list as favourite on Supply lists page.
    And Refresh page.
    Then Click on Supply lists drop-down in Header on Supply list details page.
    And Check that current Supply list is displayed in favorite Supply lists drop-down on Supply list details page.

  Scenario: Check that user can unmark Supply list as favorite on Supply Lists page.
    Given Active favorite Supply list exists.
    And Open Supply lists page.
    When Unmark Supply list as favourite on Supply lists page.
    And Refresh page.
    Then Click on Supply lists drop-down in Header on Supply list details page.
    And Check that current Supply list is not displayed in favorite Supply lists drop-down on Supply list details page.

  Scenario: Check that deactivated favorite Supply list is not displayed in the drop-down of favorites on Supply Lists page.
    Given Active favorite Supply list exists.
    And Open Supply lists page.
    When Click on deactivate button on Supply lists page.
    Then Click on Supply lists drop-down in Header on Supply list details page.
    And Check that current Supply list is not displayed in favorite Supply lists drop-down on Supply list details page.