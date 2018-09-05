Feature: Cart page Add to Supply list functionality.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Empty Cart.
    And Add to cart INDIVIDUAL, VALID product with quantity 1.

#  Scenario: Check that shopper can add a single product(from product row button) from cart to existing Supply list.
#    Given Active Supply list that doesn't contain this products exists.
#    And Open cart page.
#    And Click on add to Supply list button for any selected UOMs on Cart page.
#    And Select Select a Supply list radio button in Add to Supply list pop-up on Cart page.
#    And Select existing Supply list in Add to Supply list pop-up on Cart page.
#    And Click on Add to Supply list in Add to Supply list pop-up on Cart page.
#    And Click on View Supply list in Add to Supply list pop-up on Cart page.
#    Then Check that Supply list details page is opened.
#    Then Check that entered name is the name of Supply list on the Supply list details page.
#    Then Check that selected product(s) is(are) displayed on the Supply list details page.

#  Scenario: Check that shopper can add a single product(from product row button) to new(with action of creating) Supply list.
#    Given Open cart page.
#    And Click on add to Supply list button for any selected UOMs on Cart page.
#    And Select Create a Supply list radio button in Add to Supply list pop-up on Cart page.
#    And Enter alphanumeric text to name field in Add to Supply list pop-up on Cart page.
#    And Click on Add to Supply list in Add to Supply list pop-up on Cart page.
#    And Click on View Supply list in Add to Supply list pop-up on Cart page.
#    Then Check that Supply list details page is opened.
#    Then Check that entered name is the name of Supply list on the Supply list details page.
#    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that shopper can add a single product from cart to existing Supply list.
    Given Active Supply list that doesn't contain this products exists.
    And Open cart page.
    And Click on add to Supply list button on Cart page.
    And Select Select a Supply list radio button in Add to Supply list pop-up on Cart page.
    And Select existing Supply list in Add to Supply list pop-up on Cart page.
    And Click on Add to Supply list in Add to Supply list pop-up on Cart page.
    And Click on View Supply list in Add to Supply list pop-up on Cart page.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that shopper can add a single product to new(with action of creating) Supply list.
    Given Open cart page.
    And Click on add to Supply list button on Cart page.
    And Select Create a Supply list radio button in Add to Supply list pop-up on Cart page.
    And Enter alphanumeric text to name field in Add to Supply list pop-up on Cart page.
    And Click on Add to Supply list in Add to Supply list pop-up on Cart page.
    And Click on View Supply list in Add to Supply list pop-up on Cart page.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Check that shopper can add few product from cart to existing Supply list.
    Given Add to cart INDIVIDUAL, VALID product with quantity 1 that hasn't been added before.
    And Active Supply list that doesn't contain this products exists.
    And Open cart page.
    And Click on add to Supply list button on Cart page.
    And Select Select a Supply list radio button in Add to Supply list pop-up on Cart page.
    And Select existing Supply list in Add to Supply list pop-up on Cart page.
    And Click on Add to Supply list in Add to Supply list pop-up on Cart page.
    And Click on View Supply list in Add to Supply list pop-up on Cart page.
    Then Check that Supply list details page is opened.
    Then Check that entered name is the name of Supply list on the Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.
