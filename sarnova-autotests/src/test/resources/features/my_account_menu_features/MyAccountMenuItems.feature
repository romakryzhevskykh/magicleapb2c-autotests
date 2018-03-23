Feature: Menu items visibility and ordering.

  Background:
    Given Switch to Storefront shopper.
    And User is logged in to Storefront.
    And My Account menu is opened.

  Scenario: Check that My Account menu has only 11 items.
    Then Check that My Account menu has only 11 items.

  Scenario: Check that Account Dashboard item is present in My Account menu.
    Then Check that Account Dashboard item is present in My Account menu.
    And Check that Account Dashboard item index item is 1.

  Scenario: Check that Order History item is present in My Account menu.
    Then Check that Order History item is present in My Account menu.
    And Check that Order History item index item is 2.

  Scenario: Check that Supply Lists item is present in My Account menu.
    Then Check that Supply Lists item is present in My Account menu.
    And Check that Supply Lists item index item is 3.

  Scenario: Check that Saved Carts item is present in My Account menu.
    Then Check that Saved Carts item is present in My Account menu.
    And Check that Saved Carts item index item is 4.

  Scenario: Check that Saved Credit Cards item is present in My Account menu.
    Then Check that Saved Credit Cards item is present in My Account menu.
    And Check that Saved Credit Cards item index item is 5.

  Scenario: Check that Quotes item is present in My Account menu.
    Then Check that Quotes item is present in My Account menu.
    And Check that Quotes item index item is 6.

  Scenario: Check that Reports item is present in My Account menu.
    Then Check that Reports item is present in My Account menu.
    And Check that Reports item index item is 7.

  Scenario: Check that Account Information item is present in My Account menu.
    Then Check that Account Information item is present in My Account menu.
    And Check that Account Information item index item is 8.

  Scenario: Check that Custom Category item is present in My Account menu.
    Then Check that Custom Category item is present in My Account menu.
    And Check that Custom Category item index item is 9.

  Scenario: Check that Help/New to Boundtree? item is present in My Account menu.
    Then Check that Help/New To Boundtree? item is present in My Account menu.
    And Check that Help/New To Boundtree? item index item is 10.

  Scenario: Check that Sign Out item is present in My Account menu.
    Then Check that Sign Out item is present in My Account menu.
    And Check that Sign Out item index item is 11.