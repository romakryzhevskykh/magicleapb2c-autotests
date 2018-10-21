Feature: Test scenarios for all possible P&A validation error messages.

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario Outline: Check that Is replaced by error message is displayed for appropriate product.
    And Account management page is opened.
    When Choose <region> region.
    And Select account <account>.
    And Click on account with <salesDivision> sales division.
    Then Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    Given Select test product for chosen region by catalogNo <newProduct>.
    When User add list of <oldProduct> products to the Copy&Paste block.
    And Click on P&A button.
    Then Price&Availability page is opened.
    Then <oldProduct> is replaced by <newProduct> message is displayed under catalogNo.

    Examples:
      | region        | account | salesDivision | oldProduct | newProduct |
      | North_America | 1318501 | USS1_10_10    | AB55       | AB55K      |

  Scenario Outline: Check that Unable to price error message is displayed for appropriate product.
    And Account management page is opened.
    When Choose <region> region.
    And Select account <account>.
    And Click on account with <salesDivision> sales division.
    Then Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    Given Select test product for chosen region by catalogNo <product>.
    When User set chosen catalogueNo to the Product Number field.
    And Click on P&A button.
    Then Price&Availability page is opened.
    Then Unable to Price, please contact Customer Service message is displayed under catalogNo.
    Then Check that list price, final net price are equal to data from PDP.

    Examples:
      | region        | account | salesDivision | product    |
      | North_America | 1318501 | USS1_10_10    | AC3P3C4EBB |

  Scenario Outline: Check that Catalog No. not found message is displayed for incorrect product.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    When User add list of <incorrectProduct> products to the Copy&Paste block.
    And Click on P&A button.
    Then Price&Availability page is opened.
    Then No data available in table title is displayed in products table.
    Then Error message Catalog No. not found: <incorrectProduct> is displayed in the left top.
    Then Red exclamation mark icon is displayed near the error message.

    Examples:
      | incorrectProduct |
      | THQL11530        |

  Scenario Outline: Check that Pricing agreement is invalid error message is displayed for appropriate product and SPA number.
    And Account management page is opened.
    When Choose <region> region.
    And Select account <account>.
    And Click on account with <salesDivision> sales division.
    Then Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    Given Select test product for chosen region by catalogNo <product>.
    When User set chosen catalogueNo to the Product Number field.
    And Click on P&A button.
    Then Price&Availability page is opened.
    When User select <agreementNo> Agreement No for all the product.
    Then Error message <pricingError> is displayed below Agreement No field.
    When Click on <product> link on P&A page.
    When Click on Product Details tab in Full Product Details pop-up.
    Then Is <pricingError> pricing error below Pricing Details title displayed in Full Product Details pop-up.
    When Close Full Product Details pop-up.

    Examples:
      | region        | account | salesDivision | product | agreementNo | pricingError                                               |
      | North_America | 1318501 | USS1_10_10    | TH2221J | 45001743    | Pricing agreement is invalid. Standard price is displayed. |