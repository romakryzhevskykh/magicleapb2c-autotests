Feature: Check user restrictions with MANAGE CUSTOM CATALOG PERMISSION and without it.

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And Valid test user is present CUSTOM_CATEGORY_TEST_USER.
    And Test user group is present.
    And Test user group has only MANAGE_CUSTOM_CATALOG permission.
    And Test user has no any roles CUSTOM_CATEGORY_TEST_USER.
    And Test user has only test user group assigned.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Custom Category item on Account Dashboard page.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Open Account Dashboard page.
    And Expand Administration section on Account Dashboard page.
    Then Check that Custom Category item is visible on Account Dashboard page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Custom Category page.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    When Open Custom category page.
    Then Check that Custom Categories page is opened.
    And Check that Manage Existing Products item is visible on Custom Category page.
    And Check that Categories tree, New Category field and Add button are visible on Custom categories page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to parent Custom Categories.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Customer create parent category via webservice.
    When Open Custom category page.
    Then Check that parent Custom category is visible on Custom categories page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Add Child Custom category.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Customer create parent category via webservice.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    Then Check that New Subcategory field and Add Subcategory button are visible on Custom categories page.
    And Check that Remove parent Custom category button is visible on Custom categories page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to child Custom Categories.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Customer create parent category via webservice.
    And Customer create child category via webservice.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    Then Check that child Custom category is visible on Custom categories page.
    And Check that Remove child Custom category button is visible on Custom categories page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to products in child Custom Categories.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Customer create parent category via webservice.
    And Customer create child category via webservice.
    And Customer add 1 products to child custom category via webservice.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    And Open child Custom category on Custom categories page.
    Then Check that products are displayed on Custom categories page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to manage products in child Custom Categories.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Customer create parent category via webservice.
    And Customer create child category via webservice.
    And Customer add 1 products to child custom category via webservice.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    And Open child Custom category on Custom categories page.
    Then Check that Quick Add block is visible on Custom categories page.
    And Check that Remove product buttons are visible on Custom categories page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to add products in child Custom Categories.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Customer create parent category via webservice.
    And Customer create child category via webservice.
    When Open Custom category page.
    And Expand parent Custom category on Custom categories page.
    And Open child Custom category on Custom categories page.
    And Click on Quick Add checkbox on Custom categories page.

  @deletecustomcategory
  Scenario: Check that user with only MANAGE CUSTOM CATALOG PERMISSION has access to Manage Existing Products item on Custom Category page.
    Given Switch to Storefront cockpit test user CUSTOM_CATEGORY_TEST_USER.
    And User is logged in to Storefront.
    And Customer create parent category via webservice.
    And Customer create child category via webservice.
    And Customer add 1 products to child custom category via webservice.
    When Open Custom category page.
    And Click on Manage Existing Products item on Custom Category page.
    Then Check that products are displayed on Custom categories page.