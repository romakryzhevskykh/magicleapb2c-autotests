Feature: Purchase request page functionality


  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.


  Scenario: Check default position of Quick Add product block.
    Given Purchase summary page is open.
    Then 'Add quick Order block' starts collapsed.

  Scenario: Check quick add product check-Box.
    When Click on quick add product checkbox.
    Then Check that checkBox is expanded.


