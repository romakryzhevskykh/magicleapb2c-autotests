Feature: Quick order can add and save products in the list.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Quick order list is empty.
    And Open Quick order page.

  Scenario: Check that user can add valid product on Quick order page.
    When Add VALID, INDIVIDUAL product to Quick order list on Quick order page.
    Then Check that only added UOMs displayed on Quick order page.
    And Check that all products have corresponding QTY(zero by default) values.