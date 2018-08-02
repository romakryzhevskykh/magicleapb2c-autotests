Feature: Account Dashboard menu items on click redirects functionality.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Account Dashboard page is opened.

  Scenario: Check that Order History Account Dashboard item redirects to Order History page.
    When Click on Order History item on Account Dashboard page.
    Then Check that Order History page is opened.

  Scenario: Check that Previously Ordered Items Account Dashboard item redirects to Previously Ordered Items page.
    When Click on Previously Ordered Items item on Account Dashboard page.
    Then Check that Previously Ordered Items page is opened.

  Scenario: Check that Purchase Requests Account Dashboard item redirects to Purchase Requests page.
    When Click on Purchase Requests item on Account Dashboard page.
    Then Check that Purchase Requests page is opened.

  Scenario: Check that Quotes Account Dashboard item redirects to Quotes page.
    When Click on Quotes item on Account Dashboard page.
    Then Check that Quotes page is opened.

  Scenario: Check that Replenishment Orders Account Dashboard item redirects to Quotes page.
    When Click on Replenishment Orders item on Account Dashboard page.
    Then Check that Replenishment Orders page is opened.

  Scenario: Check that Saved Carts Account Dashboard item redirects to Saved Carts page.
    When Click on Saved Carts item on Account Dashboard page.
    Then Check that Saved Carts page is opened.

  Scenario: Check that Supply Lists Account Dashboard item redirects to Supply Lists page.
    When Click on Supply Lists item on Account Dashboard page.
    Then Check that Supply Lists page is opened.

  Scenario: Check that Backordered Items Account Dashboard item redirects to Reports page.
    When Click on Backordered Items item on Account Dashboard page.
    Then Check that Backordered Items page is opened.

  Scenario: Check that Discontinued Products Account Dashboard item redirects to Reports page.
    When Click on Discontinued Products item on Account Dashboard page.
    Then Check that Discontinued Products page is opened.

  Scenario: Check that DSCSA Transactions Account Dashboard item redirects to Reports page.
    When Click on DSCSA Transactions item on Account Dashboard page.
    Then Check that DSCSA Transactions page is opened.

#  Scenario: Check that Pharmaceutical Backorder Report Account Dashboard item redirects to Reports page.
#    When Click on Pharmaceutical Backorder Report item on Account Dashboard page.
#    Then Check that Pharmaceutical Backorder Report page is opened.

  Scenario: Check that Purchases Per Month Account Dashboard item redirects to Business Info page.
    When Click on Purchases Per Month item on Account Dashboard page.
    Then Check that Purchases Per Month page is opened.

  Scenario: Check that Purchase Summary Account Dashboard item redirects to Reports page.
    When Click on Purchase Summary item on Account Dashboard page.
    Then Check that Purchase Summary page is opened.

  Scenario: Check that Custom Category Account Dashboard item redirects to Custom Category page.
    When Click on Custom Category item on Account Dashboard page.
    Then Check that Custom Categories page is opened.

  Scenario: Check that Quotas and Par Levels Account Dashboard item redirects to Quotas and Par Levels page.
    When Click on Quotas And Par Levels item on Account Dashboard page.
    Then Check that Quotas and Par Levels page is opened.

  Scenario: Check that Users Account Dashboard item redirects to Users page.
    When Click on Users item on Account Dashboard page.
    Then Check that Users page is opened.

  Scenario: Check that User Groups Account Dashboard item redirects to User Groups page.
    When Click on User Groups item on Account Dashboard page.
    Then Check that User Groups page is opened.

  Scenario: Check that Account Settings Account Dashboard item redirects to Account Information page.
    When Click on Account Settings item on Account Dashboard page.
    Then Check that Account Settings page is opened.

  Scenario: Check that Help/New To Boundtree? Account Dashboard item redirects to Help/New To Boundtree? page.
    When Click on Help item on Account Dashboard page.
    Then Check that Help page is opened.

#  Scenario: Check that Saved Credit Cards Account Dashboard item redirects to Saved Credit Cards page.
#    When Click on Saved Credit Cards item on Account Dashboard page.
#    Then Check that Saved Credit Cards page is opened.