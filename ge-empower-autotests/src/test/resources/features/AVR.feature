Feature: Verification of main AVR elements on the Dashboard and on the Volume Rebate page.

  Background:
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose EMEA region.
    And Select account 9004834.

  Scenario: Check that AVR widget is displayed on the Dashboard with all necessary elements.
    And Dashboard page is opened.
    Then AVR widget is displayed on the Dashboard page.
    Then Volume Rebate (AVR) title is displayed for AVR widget.
    Then Currency has correct value Values in EUR label.
    And Count of AVRs is stored to the threadVarsHashmap.
    Then Current Payout current payout is displayed on the AVR widget.
    Then Current Volume current volume is displayed on the AVR widget.
    Then YTD Payout ytd payout is displayed on the AVR widget.