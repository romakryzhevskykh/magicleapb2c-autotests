Feature: Check user restrictions with SUPPLY LISTS PERMISSION and without it.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Valid test user is present.
    And Test user group is present.
    And Test user group has only SUPPLY_LISTS permission.
    And Test user has no any roles.
    And Test user has only test user group assigned.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Supply lists drop-down in header.
    When Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Refresh page.
    Then Check that Supply lists drop-down is present in Header.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Supply lists on Account Dashboard page.
    When Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Account Dashboard page is opened.
    Then Check that Supply Lists item is visible on Account Dashboard page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Supply lists page.
    When Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Open Supply lists page.
    Then Check that Supply Lists page is opened.
    And Check that active Supply Lists block is visible on Supply lists page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to favorite checkbox on Supply lists page.
    When Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    Given Active Supply list exists.
    And Open Supply lists page.
    Then Check that Supply list favorite checkbox is visible on Supply lists page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Remove button for his own Supply list on Supply lists page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    And Open Supply lists page.
    Then Check that deactivate Supply list button is visible on Supply lists page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that Supply list details page is opened.
    And Check that Supply list header is visible on Supply list details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to favorite checkbox on Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that Supply list favorite checkbox is visible on Supply list details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Add to cart button and QTY field on Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that Add to cart button is visible on Supply list details page.
    Then Check that product Quantity field is visible on Supply details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Remove button for his own Supply list on Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that Remove button is visible on Supply list details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Quick add functionality for his owm Supply list on Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that Quick add functionality is visible on Supply list details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Edit button for his own Supply list on Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that Edit button is visible on Supply list details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Activate/Inactivate button for his own Supply list on Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that change Supply lit status button is visible on Supply list details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Share functionality on Supply list details page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Active Supply list exists.
    When Opened Supply list details page.
    Then Check that Share Supply list functionality is not visible on Supply list details page.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Add to Supply list button on PDP.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    When PDP for INDIVIDUAL, VALID product.
    Then Check that Add to Supply list button is not visible on PDP.

  Scenario: Check that user with only SUPPLY LISTS PERMISSION has access to Add to Supply list button on Cart page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    When Add to cart INDIVIDUAL, VALID product with quantity 1.
    And Open cart page.
    Then Check that Add to Supply list button is not visible on Cart page.

