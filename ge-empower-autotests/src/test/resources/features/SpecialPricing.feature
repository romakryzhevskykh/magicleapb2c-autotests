Feature: Some actions on Special Pricing page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Special Pricing page and correct header title is displayed
    And Special Pricing page is opened.
    Then Price Agreements title is displayed on Special Pricing page.

  Scenario Outline: Check that New Local List price TAB is displayed with correct document for each EMEA account
    And Account management page is opened.
    When Choose EMEA region.
    And Select account <emeaAccount>.
    And Click on account with <salesDivision> sales division.
    And Special Pricing page is opened.
    Then Regional List Price tab is displayed.
    When User switch to Regional List Price tab.
    And Opens Select Price Schedule list.
    Then Only one document is displayed with appropriate <salesDistrict> salesDistrict.

    Examples:
      | emeaAccount | salesDistrict            | salesDivision |
      | 9007260     | EEDBLK                   | HUS1_10_10    |
      | 9007334     | EEDHU                    | DES1_20_10    |
      | 9005581     | EEDIL                    | HUS1_10_10    |
      | 9007098     | EEDCIS                   | PLS2_20_10    |
      | 9006576     | EEDFR                    | FRS1_20_10    |
      | 9007416     | EEDCZ                    | HUS1_10_10    |
      | 9006690     | GE_Preisliste            | PLS2_20_10    |
      | 30324       | NL 2018                  | NLS1_30_10    |
      | 9006692     | GE Power Controls cennik | PLS3_10_10    |

  Scenario Outline: Check that New Local List price TAB is NOT displayed in EMEA account which is not from Sales District list
    And Account management page is opened.
    When Choose EMEA region.
    And Select account <emeaAccount>.
    And Click on account with <salesDivision> sales division.
    And Special Pricing page is opened.
    Then Regional List Price tab is not displayed.

    Examples:
      | emeaAccount | salesDivision |
      | 9007384     | BES1_20_10    |