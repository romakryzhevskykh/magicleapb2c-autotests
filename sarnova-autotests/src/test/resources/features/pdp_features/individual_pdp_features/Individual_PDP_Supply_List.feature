Feature: Individual PDP Supply list functionality

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.

  Scenario: Check info message for Adding to supply list with empty selection.
    Given PDP for INDIVIDUAL_VALID product.
    When Set QTY values for products to 0.
    And Click on add to Supply list button.
    Then Pop-up with Please set non-zero quantity to products you wish to add message is opened.

  Scenario: Check that shopper can add product to new(with action of creating) Supply list.
    Given PDP for INDIVIDUAL_VALID product.
    When Set QTY 1 to any product(UOM) on the PDP.
    And Click on add to Supply list button.
    And Select Create a Supply list radio button in Add to Supply list pop-up.
    And Enter alphanumeric text to name field in Add to Supply list pop-up.
    And Click on Add to Supply list in Add to Supply list pop-up.
    And Click on View Supply list in Add to Supply list pop-up.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that shopper can add product to existing(already created) Supply list.
    Given PDP for INDIVIDUAL_VALID product.
    When Set QTY 1 to any product(UOM) on the PDP.
    And Supply list that doesn't contain this products exists.
    And Click on add to Supply list button.
    And Select Select a Supply list radio button in Add to Supply list pop-up.
    And Select existing Supply list in Add to Supply list pop-up.
    And Click on Add to Supply list in Add to Supply list pop-up.
    And Click on View Supply list in Add to Supply list pop-up.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.