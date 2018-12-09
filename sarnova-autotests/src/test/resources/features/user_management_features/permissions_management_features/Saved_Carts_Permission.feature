Feature: Check user restrictions with SAVED CARTS and without it.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Valid test user is present ORGANIZATION_TEST_USER.
    And Test user group is present.
    And Test user group has only SAVED_CARTS permission.
    And Test user has no any roles ORGANIZATION_TEST_USER.
    And Test user has only test user group assigned.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Saved Carts item in My account menu.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Open Home page.
    When My Account menu is opened.
    Then Check that Saved Carts item is present in My Account menu.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Saved Carts item on Account Dashboard page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    When Account Dashboard page is opened.
    And Expand Account Dashboard section on Account Dashboard page.
    Then Check that Saved Carts item is visible on Account Dashboard page.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Saved Carts page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    When Open Saved Carts page.
    Then Check that Saved Carts page is opened.
    And Check that Saved Carts header title is present on Saved Carts page.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Save Cart button on Cart page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Add to cart VALID product with quantity 1.
    When Open cart page.
    Then Check that Save Cart button is visible on Cart page.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Save Cart button on Cart page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Add to cart VALID product with quantity 1.
    When Open cart page.
    And Click on Save Cart button on Cart page.
    Then Check that Save Cart pop-up is visible on Cart page.
    And Check that Save Cart name field is visible in Save Cart pop-up on Cart page.
    And Check that Save Cart description field is visible in Save Cart pop-up on Cart page.
    And Check that Save Cart button is visible in Save Cart pop-up on Cart page.
    And Check that Cancel Save Cart button is visible in Save Cart pop-up on Cart page.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Saved Carts button on Cart page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Saved Cart with at least 1 products has been created.
    When Open cart page.
    Then Check that Saved Carts button is visible on Cart page.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Saved Cart details page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Saved Cart with at least 1 products has been created.
    When Open Saved Cart details page.
    Then Check that Saved cart details page is opened.
    Then Check that Label is visible on Saved Cart Details page.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to Saved Cart on Saved carts page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Saved Cart with at least 1 products has been created.
    When Open Saved Carts page.
    Then Check that Saved cart is visible on Saved Carts page.
    And Check that Saved cart Restore button is visible on Saved Carts page.
    And Check that Saved cart Remove button is visible on Saved Carts page.

  Scenario: Check that user with only SAVED CARTS PERMISSION has access to all functions on Saved cart details page.
    Given Switch to Storefront cockpit test user ORGANIZATION_TEST_USER.
    And User is logged in to Storefront.
    And Saved Cart with at least 1 products has been created.
    When Open Saved Cart details page.
    Then Check that Restore button is visible on Saved Cart details page.
    And Check that Edit button is visible on Saved Cart details page.
    And Check that Delete cart button is visible on Saved Cart details page.
    And Check that Products are visible on Saved Cart details page.