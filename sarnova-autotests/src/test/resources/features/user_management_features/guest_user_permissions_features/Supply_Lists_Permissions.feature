Feature: Check guest user Supply lists restrictions.

  Background:
    Given Switch to Storefront guest.

  Scenario: Check that guest user has access to Add to Supply list button on Quick order page.
    When Quick order page is opened.
    Then Check that Add to Supply list button is visible on Quick order page.

  Scenario: Check that guest user has access to Add to Supply list button on Product details page.
    When PDP for INDIVIDUAL, VALID product.
    Then Check that Add to Supply list button is visible on PDP.

  Scenario: Check that guest user has access to Add to Supply list button on Cart page.
    When Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    Then Check that Add to Supply list button is visible on Cart page.

  Scenario: Check that guest user has access to Supply lists drop-down in header.
    Then Check that Supply lists drop-down is present in Header.

  Scenario: Check that guest user has access to View all supply lists button in Supply lists drop-down in header.
    When Click on Supply lists drop-down in Header.
    Then Check that View all supply lists item is present in Supply lists drop-down in Header.

  Scenario: Check that guest user has no access to Supply lists page.
    When Open Supply lists page.
    Then Check that Supply Lists page is not opened.

