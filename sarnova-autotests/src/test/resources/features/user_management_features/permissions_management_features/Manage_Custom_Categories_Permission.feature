Feature: Check user restrictions with MANAGE CUSTOM CATALOG PERMISSION and without it.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Valid test user is present.
    And Test user group is present.
    And Test user group has only MANAGE_CUSTOM_CATALOG permission.
    And Test user has no any roles.
    And Test user has only test user group assigned.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Custom Category item on Account Dashboard page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Open Account Dashboard page.
    Then Check that Custom Category item is visible on Account Dashboard page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Custom Category page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    When Open Custom category page.
    Then Check that Custom Categories page is opened.
    And Check that Categories tree is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Add new Custom Category functionality.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    When Open Custom category page.
    Then Check that new Custom Category name field is visible on Custom categories page.
    And Check that Add new Custom Category button is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to parent Custom Categories.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test parent Custom category is present.
    When Open Custom category page.
    Then Check that parent Custom category is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to child Custom Categories.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test child Custom category is present.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    Then Check that child Custom category is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Remove Custom category.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test parent Custom category is present.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    Then Check that Remove parent Custom category button is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Add Child Custom category.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test parent Custom category is present.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    Then Check that Add child category to parent button is visible on Custom categories page.
    Then Check that Add child category to parent text field is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Remove Child Custom category.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test child Custom category is present.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    Then Check that Remove child Custom category button is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to products in child Custom Categories.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test child Custom category is present.
    And At least 1 product in child Custom category.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    And Open child Custom category on Custom categories page.
    Then Check that products are displayed on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to manage products in child Custom Categories.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test child Custom category is present.
    And At least 1 product in child Custom category.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    And Open child Custom category on Custom categories page.
    Then Check that Quick Add block is visible on Custom categories page.
    And Check that Remove product buttons are visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to add products in child Custom Categories.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test child Custom category is present.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    And Open child Custom category on Custom categories page.
    And Click on Quick Add checkbox on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Manage Existing Products item on Custom Category page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    When Open Custom category page.
    Then Check that Manage Existing Products item is visible on Custom Category page.

  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Manage Existing Products item on Custom Category page.
    Given Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Test child Custom category is present.
    And At least 1 product in child Custom category.
    When Open Custom category page.
    And Click on Manage Existing Products item on Custom Category page.
    Then Check that products are displayed on Custom categories page.