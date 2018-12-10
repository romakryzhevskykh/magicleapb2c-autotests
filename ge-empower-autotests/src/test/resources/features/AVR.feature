Feature: Verification of main AVR elements on the Dashboard and on the Volume Rebate page.

  Background:
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose EMEA region.
    And Select account 9004834.
    And Click on chosen account.

  Scenario: Check that AVR widget is displayed on the Dashboard with all necessary elements.
    And Dashboard page is opened.
    When Click on Skip button.
    And Close cookies pop-up.
    Then VOLUME REBATE AVR section is displayed in the header menu.
    Then AVR widget is displayed on the Dashboard page.
    Then Volume Rebate (AVR) title is displayed for AVR widget.
    Then Currency has correct value Values in EUR label.
    And Minimal count of AVRs is stored to the threadVarsHashmap.
    Then Rebate company name is displayed correctly.
    Then Current Payout: current payout is displayed on the AVR widget.
    Then Current Volume: current volume is displayed on the AVR widget.
    Then YTD Volume ytd volume is displayed on the AVR widget.
    Then YTD Payout value is equal to Current volume.
    Then AVR type description is correct for each avr on the dashboard.
    Then Next target label is correct for each avr on the dashboard.
    When User clicks on active AVR.
    Then Volume rebate page is opened.
    Then Count of AVR is more or equal than count of AVR on the dashboard.

  Scenario: Check all the targets, data difference for AVR widget on the Dashbord.
    And Dashboard page is opened.
    When Click on Skip button.
    And Close cookies pop-up.
    And Minimal count of AVRs is stored to the threadVarsHashmap.
    Then Each available AVR has correct target, data diff and other labels.

  Scenario Outline: Check that user is able to open Volume Rebate page and all necessary elements are displayed on it.
    And Volume rebate page is opened.
    Then Volume Rebate (AVR) title is displayed on the Volume rebate page.
    Then Year switcher is present with current year.
    Then <settlementMessage> and <infoMessage> messages are displayed on the Volume rebate page.

    Examples:
      | infoMessage                                                                                                                                        | settlementMessage                                                                         |
      | Disclaimer: The amount and calculations displayed on this page are for informational purposes only. Actual amounts owed are subject to validation. | Some Volume Rebate details may be not displayed, check settlement partner account instead |