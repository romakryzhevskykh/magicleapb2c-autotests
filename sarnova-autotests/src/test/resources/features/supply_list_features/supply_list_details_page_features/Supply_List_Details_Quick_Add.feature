Feature: Quick add products to Supply list from SLDP.

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And Active Supply list exists.
    And Opened Supply list details page.

  Scenario: Add product via Quick add from SLDP.
    When Open Quick add block on Supply list details page.
    And Enter not exist VALID, INDIVIDUAL product SKU to any empty row on Supply list details page.
    And Click on Add to this list button on Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

  Scenario: Add product via Quick add from SLDP.
    When Open Quick add block on Supply list details page.
    And Enter not exist VALID, INDIVIDUAL product SKU to any empty row on Supply list details page.
    And Enter not exist VALID, INDIVIDUAL product SKU to any empty row on Supply list details page.
    And Click on Add to this list button on Supply list details page.
    Then Check that selected product(s) is(are) displayed on the Supply list details page.

#  Scenario: Error handling if user tries to add group product to Supply list.
#    When Open Quick add block on Supply list details page.
#    And Enter not exist GROUP product SKU to any empty row on Supply list details page.
#    Then Check that Group product is not allowed here error message is displayed for used row.

#  Scenario: Error handling if user tries to add already exists product to Supply list.
#    When Open Quick add block on Supply list details page.
#    And Enter exist product SKU to any empty row on Supply list details page.
#    Then Check that Sku already exists in the form error message is displayed for used row.

  Scenario: Error handling if user tries to add nonexistent SKU.
    When Open Quick add block on Supply list details page.
    And Enter random text to any empty row on Supply list details page.
    Then Check that Product not found error message is displayed for used row.