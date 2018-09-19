Feature: Quick order add to Supply list functionality.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Quick order list is empty.
    And Open Quick order page.

  Scenario: Check that Add to Supply list button is unable if Quick order list is empty.
    Then Check that Add to Supply list button is unable on Quick order page.

  Scenario: Check that Add to Supply list button is unable if Quick order list has only products with QTY 0.
    When Add 1 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 0 to all UOM on Quick order page.
    Then Check that Add to Supply list button is unable on Quick order page.

  Scenario: Check that user can add product to new(action of creation) Supply list.
    When Add 1 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 1 to any UOM on Quick order page.
    And Click on Add to Supply list button on Quick order page.
    And Select Create a Supply list radio button in Add to Supply list pop-up on Quick order page.
    And Enter alphanumeric text to name field in Add to Supply list pop-up on Quick order page.
    And Click on Add to Supply list in Add to Supply list pop-up on Quick order page.
    And Click on View Supply list in Add to Supply list pop-up on Quick order page.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that user can add products(>1) to new(action of creation) Supply list.
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 3 to all UOM on Quick order page.
    And Click on Add to Supply list button on Quick order page.
    And Select Create a Supply list radio button in Add to Supply list pop-up on Quick order page.
    And Enter alphanumeric text to name field in Add to Supply list pop-up on Quick order page.
    And Click on Add to Supply list in Add to Supply list pop-up on Quick order page.
    And Click on View Supply list in Add to Supply list pop-up on Quick order page.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that only products with QTYs >0 added to new(action of creation) Supply list.
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 1 to any UOM on Quick order page.
    And Click on Add to Supply list button on Quick order page.
    And Select Create a Supply list radio button in Add to Supply list pop-up on Quick order page.
    And Enter alphanumeric text to name field in Add to Supply list pop-up on Quick order page.
    And Click on Add to Supply list in Add to Supply list pop-up on Quick order page.
    And Click on View Supply list in Add to Supply list pop-up on Quick order page.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that user can add product to existed(action of update) Supply list.
    When Add 1 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 1 to any UOM on Quick order page.
    And Active Supply list that doesn't contain this products exists.
    And Click on Add to Supply list button on Quick order page.
    And Select Select a Supply list radio button in Add to Supply list pop-up on Quick order page.
    And Select existing Supply list in Add to Supply list pop-up on Quick order page.
    And Click on Add to Supply list in Add to Supply list pop-up on Quick order page.
    And Click on View Supply list in Add to Supply list pop-up on Quick order page.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that products are still existed in Quick order list after adding to Supply list
    When Add 2 VALID, INDIVIDUAL product to Quick order list on Quick order page.
    And Set QTY 1 to any UOM on Quick order page.
    And Click on Add to Supply list button on Quick order page.
    And Select Create a Supply list radio button in Add to Supply list pop-up on Quick order page.
    And Enter alphanumeric text to name field in Add to Supply list pop-up on Quick order page.
    And Click on Add to Supply list in Add to Supply list pop-up on Quick order page.
    And Click on Continue button in Add to Supply list pop-up on Quick order page.
    Then Refresh page.
    Then Check that all products have corresponding QTY(zero by default) values on Quick order page.
