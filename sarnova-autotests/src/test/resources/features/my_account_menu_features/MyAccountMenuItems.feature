Feature: Menu items visibility and ordering.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And My Account menu is opened.

  Scenario: Check that My Account menu has only 8 items.
    Then Check that My Account menu has only 8 items.

  Scenario: Check that Account Dashboard item is present in My Account menu.
    Then Check that Account Dashboard item is present in My Account menu.

  Scenario: Check that Account Dashboard item is on 1 in My Account menu.
    Then Check that Account Dashboard item index item is 1.

  Scenario: Check that Order History item is present in My Account menu.
    Then Check that Order History item is present in My Account menu.

  Scenario: Check that Order History item is 2 in My Account menu.
    Then Check that Order History item index item is 2.

  Scenario: Check that Purchase Requests item is present in My Account menu.
    Then Check that Purchase Requests item is present in My Account menu.

  Scenario: Check that Purchase Requests item is 4 in My Account menu.
    Then Check that Purchase Requests item index item is 3.

  Scenario: Check that Quotes item is present in My Account menu.
    Then Check that Quotes item is present in My Account menu.

  Scenario: Check that Quotes item is 7 in My Account menu.
    Then Check that Quotes item index item is 4.

  Scenario: Check that Reports item is present in My Account menu.
    Then Check that Reports item is present in My Account menu.

  Scenario: Check that Reports item is 8 in My Account menu.
    Then Check that Reports item index item is 5.

  Scenario: Check that Saved Carts item is present in My Account menu.
    Then Check that Saved Carts item is present in My Account menu.

  Scenario: Check that Saved Carts item is 5 in My Account menu.
    Then Check that Saved Carts item index item is 6.

  Scenario: Check that Help/New to Boundtree? item is present in My Account menu.
    Then Check that Help/New To Boundtree? item is present in My Account menu.

  Scenario: Check that Help/New to Boundtree? item is 13 in My Account menu.
    Then Check that Help/New To Boundtree? item index item is 7.

  Scenario: Check that Sign Out item is present in My Account menu.
    Then Check that Sign Out item is present in My Account menu.

  Scenario: Check that Sign Out item is 16 in My Account menu.
    Then Check that Sign Out item index item is 8.