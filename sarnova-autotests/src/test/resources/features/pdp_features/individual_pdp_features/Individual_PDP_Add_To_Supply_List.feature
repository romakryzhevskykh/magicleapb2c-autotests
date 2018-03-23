Feature: Individual PDP add to Supply list functionality

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And PDP for INDIVIDUAL, VALID product.

  Scenario: Check info message for Adding to supply list with empty selection.
    When Set QTY values for products to 0 on PDP.
    And Click on add to Supply list button on PDP.
    Then Check that Add to Supply list pop-up displays Please set non-zero quantity to products you wish to add message on PDP.

  Scenario: Check that shopper can add product to new(with action of creating) Supply list.
    When Set QTY 1 to any product(UOM) on the PDP.
    And Click on add to Supply list button on PDP.
    And Select Create a Supply list radio button in Add to Supply list pop-up on PDP.
    And Enter alphanumeric text to name field in Add to Supply list pop-up on PDP.
    And Click on Add to Supply list in Add to Supply list pop-up on PDP.
    And Click on View Supply list in Add to Supply list pop-up on PDP.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that shopper can add product to existing(already created) Supply list.
    When Set QTY 1 to any product(UOM) on the PDP.
    And Supply list that doesn't contain this products exists.
    And Click on add to Supply list button on PDP.
    And Select Select a Supply list radio button in Add to Supply list pop-up on PDP.
    And Select existing Supply list in Add to Supply list pop-up on PDP.
    And Click on Add to Supply list in Add to Supply list pop-up on PDP.
    And Click on View Supply list in Add to Supply list pop-up on PDP.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.