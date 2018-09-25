Feature: Quick order can add and save products in the list.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Quick order list is empty.
    And Open Quick order page.

  Scenario: Check that user can add valid product on Quick order page.
    When Add 1 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    Then Check that only added UOMs displayed on Quick order page.
    And Check that all products have corresponding QTY(zero by default) values on Quick order page.

  Scenario: Check that user can add at least two valid products on Quick order page.
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    Then Check that only added UOMs displayed on Quick order page.
    And Check that all products have corresponding QTY(zero by default) values on Quick order page.

  Scenario: Check that user can not add group products on Quick order page.
    When Add 1 GROUP product to Quick order list on Quick order page.
    Then Check that Entered SKU belongs to group product. Please use SKU of individual product. error message is displayed for used row on Quick order page.

  Scenario: Check that user can not add existed products on Quick order page.
    When Add 1 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Add already existed product to Quick order list on Quick order page.
    Then Check that Sku already exists in the form error message is displayed for used row on Quick order page.

  Scenario: Check that user can not add not existed product id to the list on Quick order page.
    When Enter random text to any empty row on Quick order page.
    Then Check that Product not found error message is displayed for used row on Quick order page.

  Scenario: Check that user can change product QTY on Quick order page.
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 2 to any UOM on Quick order page.
    Then Check that all products have corresponding QTY(zero by default) values on Quick order page.

  Scenario: Check that user can change product QTY and it will be saved after refresh on Quick order page.
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 2 to any UOM on Quick order page.
    And Refresh page.
    Then Check that all products have corresponding QTY(zero by default) values on Quick order page.

  Scenario: Check that user can change product QTY using +/- buttons and it will be saved after refresh on Quick order page.
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 2 to any UOM using plus/minus buttons on Quick order page.
    And Refresh page.
    Then Check that all products have corresponding QTY(zero by default) values on Quick order page.

  Scenario: Check that Reset Form button empties Quick order list
    When Add 3 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 2 to any UOM on Quick order page.
    And Click on Reset form button on Quick order page.
    Then Check that Quick order list is empty on Quick order page.
    When Refresh page.
    Then Check that Quick order list is empty on Quick order page.

#    Scenario: Check that items order is saved after refreshing