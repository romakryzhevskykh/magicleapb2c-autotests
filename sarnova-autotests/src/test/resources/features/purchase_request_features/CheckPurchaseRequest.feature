Feature: Check Purchase request by approver

  Background:
    Given Switch to Storefront approver.
    And User is logged in to Storefront.


  Scenario: Check that created purchase request is present in purchase request list.
    Given Purchase request page page is open.
    And Purchase request order number is present on the purchase request page.




