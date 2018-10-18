Feature: Purchase request page functionality

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.


  Scenario: Check default position of Quick Add product block.
    When Check that Purchase Summary page is opened.
    Then Add quick Order block is collapsed on purchase summary page.

  Scenario: Check quick add product check-Box.
    When Click on quick add product checkbox on purchase summary page.
    Then Check that checkBox is expanded on purchase summary page.