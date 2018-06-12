Feature: Make Supply list favorite or deactivate favourite flag from SLDP.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.

  Scenario: Check that user can mark Supply list as favorite on SLDP.
    Given Active not favorite Supply list exists.
    And Opened Supply list details page.
    When Mark Supply list as favourite on Supply list details page.
    And Refresh page.
    Then Click on Supply lists drop-down in Header.
    And Check that current Supply list is displayed in favorite Supply lists drop-down in page header.

  Scenario: Check that user can unmark Supply list as favorite on SLDP.
    Given Active favorite Supply list exists.
    And Opened Supply list details page.
    When Unmark Supply list as favourite on Supply list details page.
    And Refresh page.
    Then Click on Supply lists drop-down in Header.
    And Check that current Supply list is not displayed in favorite Supply lists drop-down in page header.

  Scenario: Check that deactivated favorite Supply list is not displayed in the drop-down of favorites on SLDP.
    Given Active favorite Supply list exists.
    And Opened Supply list details page.
    When Click on deactivate button on Supply list details page.
    Then Click on Supply lists drop-down in Header.
    And Check that current Supply list is not displayed in favorite Supply lists drop-down in page header.