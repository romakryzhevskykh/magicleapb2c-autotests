Feature: Some actions on Saved Items page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Saved Items page and correct header title is displayed
    And Saved Items page is opened.
    Then Items title is displayed on Saved Items page.
    Then Active Cart title for appropriate section is displayed.
    Then Saved Lists title for appropriate table is displayed.

  Scenario Outline: Check that user is able to add new List.
    And Account management page is opened.
    When Choose North_America region.
    And Select account 1318501.
    And Click on chosen account.
    And Saved Items page is opened.
    When User clicks on the Add New List button on the All Items page.
    And Set new list name in the New List pop-up.
    And Click on Add new list button in the New List pop-up.
    And Table was sorted by Created On value DESC.
    Then List with appropriate name appeared in Saved Lists table.
    Then List data values are correct in Saved Lists table.
    Then No. of items is equal to 0.
    When User opens the saved list.
    And User adds new <productNo> item via New item pop-up.
    Then Chosen product <productNo> is displayed on the saved list page.
    When User select <agreementNo> Agreement No for all the product.
    Then Extnd. Price has been changed.
    When User goes back to the Saved Items page.
    And Table was sorted by Created On value DESC.
    Then No. of items is equal to 1.
    When User deletes the saved list.
    And Refresh page.
    And Table was sorted by Created On value DESC.
    Then List with appropriate name disappeared in Saved Lists table.

    Examples:
      | productNo | agreementNo |
      | thql1120  | 45000220    |

  Scenario: Check that Help button works correctly on the Saved Items page.
    And Saved Items page is opened.
    And Help button is displayed.
    When User clicks on Help button.
    And Click on Sign in with your GE SSO Account button on Lessonly page.
    Then Check that Saved Items page is opened.
    When User clicks on Help button.
    Then Saved Lists & Shopping Carts tip is displayed on Lessonly widget.