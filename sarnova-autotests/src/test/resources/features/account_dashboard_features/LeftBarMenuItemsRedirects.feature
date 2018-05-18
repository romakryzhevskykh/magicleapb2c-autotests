Feature: Menu items on click redirects functionality.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And My Account menu is opened.

  Scenario: Check that Account Dashboard My Account menu item redirects to Account Dashboard page.
    When Click on Account Dashboard item in My Account menu.
    Then Check that Account Dashboard page is opened.

  Scenario: Check that Order History My Account menu item redirects to Order History page.
    When Click on Order History item in My Account menu.
    Then Check that Order History page is opened.

  Scenario: Check that Purchase Requests My Account menu item redirects to Purchase Requests page.
    When Click on Purchase Requests item in My Account menu.
    Then Check that Purchase Requests page is opened.

  Scenario: Check that Saved Carts My Account menu item redirects to Saved Carts page.
    When Click on Saved Carts item in My Account menu.
    Then Check that Saved Carts page is opened.

  Scenario: Check that Quotes My Account menu item redirects to Quotes page.
    When Click on Quotes item in My Account menu.
    Then Check that Quotes page is opened.

  Scenario: Check that Reports My Account menu item redirects to Reports page.
    When Click on Reports item in My Account menu.
    Then Check that Reports page is opened.

  Scenario: Check that Help/New To Boundtree? My Account menu item redirects to Help/New To Boundtree? page.
    When Click on Help/New To Boundtree? item in My Account menu.
    Then Check that Help/New To Boundtree? page is opened.

  Scenario: Check that Sign Out My Account menu item redirects to Start page.
    When Click on Sign Out item in My Account menu.
    Then Check that Start page is opened.

#  Scenario: Check that Saved Credit Cards My Account menu item redirects to Saved Credit Cards page.
#    When Click on Saved Credit Cards item in My Account menu.
#    Then Check that Saved Credit Cards page is opened.

#  Scenario: Check that Account Information My Account menu item redirects to Account Information page.
#    When Click on Account Information item in My Account menu.
#    Then Check that Account Information page is opened.

#  Scenario: Check that Custom Category My Account menu item redirects to Custom Category page.
#    When Click on Custom Category item in My Account menu.
#    Then Check that Custom Categories page is opened.
#
#  Scenario: Check that Quotas and Par Levels My Account menu item redirects to Quotas and Par Levels page.
#    When Click on Quotas and Par Levels item in My Account menu.
#    Then Check that Quotas and Par Levels page is opened.
#
#  Scenario: Check that Business Info My Account menu item redirects to Business Info page.
#    When Click on Business Info item in My Account menu.
#    Then Check that Business Info page is opened.

#  Scenario: Check that Supply Lists My Account menu item redirects to Supply Lists page.
#    When Click on Supply Lists item in My Account menu.
#    Then Check that Supply Lists page is opened.

#  Scenario: Check that Users My Account menu item redirects to Users page.
#    When Click on Users item in My Account menu.
#    Then Check that Users page is opened.

#  Scenario: Check that User Groups My Account menu item redirects to User Groups page.
#    When Click on User Groups item in My Account menu.
#    Then Check that User Groups page is opened.