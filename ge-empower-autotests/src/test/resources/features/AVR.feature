Feature: Verification of main AVR elements on the Dashboard and on the Volume Rebate page.

  Background:
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose EMEA region.

  Scenario: Check that AVR widget is displayed on the Dashboard with all necessary elements.
    And Select account 9004834.
    And Click on chosen account.
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

  Scenario: Check all the targets, data difference for AVR widget on the Dashboard.
    And Select account 9004834.
    And Click on chosen account.
    And Dashboard page is opened.
    When Click on Skip button.
    And Close cookies pop-up.
    And Minimal count of AVRs is stored to the threadVarsHashmap.
    Then Each available AVR has correct target, data diff and other labels.

  Scenario Outline: Check that user is able to open Volume Rebate page and all necessary elements are displayed on it.
    And Select account 9003084.
    And Click on chosen account.
    And Volume rebate page is opened.
    Then Volume Rebate (AVR) title is displayed on the Volume rebate page.
    Then Year switcher is present with current year.
    Then <settlementMessage> and <infoMessage> messages are displayed on the Volume rebate page.
    Then Values in EUR currency is displayed on the Volume Rebate page.
    Then Current Payout: and (see details below) titles are displayed on the Volume Rebate page.
    Then Volume rebate ID is displayed for each avr.
    Then AVR type description is correct for each avr.
    When User expands each AVR on the Volume Rebate page.
    Then Current payout sum equals to sum of current payout for each avr except Marketing Budget type.
    Then Graph is displayed for each avr.
    Then Next target label is correct for each avr.
    Then Current Volume: current volume is displayed for each AVR.
    Then Current Payout: current payout is displayed for each AVR.
    Then Target Reached: target reached label is displayed for each AVR.
    Then Payout (%): or Current Rebate (%): is displayed for each AVR.
    Then Diff to next Target: is displayed for AVR if Target is applicable.
    Then Next target (%): is displayed if Target applicable.
    Then Calculator with Customer's Projection*: and Projection Payout: is displayed if Target is applicable.
    Then Projection Payout is calculated correctly on the fly and user can save this value.

    Examples:
      | infoMessage                                                                                                                                        | settlementMessage                                                                         |
      | Disclaimer: The amount and calculations displayed on this page are for informational purposes only. Actual amounts owed are subject to validation. | Some Volume Rebate details may be not displayed, check settlement partner account instead |

  Scenario Outline: Check that internal user can't see Volume Rebate menu item if appropriate toggle is turned of to the user.
    And Select account 9003084.
    And Click on chosen account.
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets externalUser1 email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    And Expand Change an empower Privilege/Role in I want to block.
    Then Volume Rebate toggle is not displayed for external user.
    And Sets <sso> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    And Expand Change an empower Privilege/Role in I want to block.
    When Admin turn off Volume Rebate toggle.
    And Clicks on Assign button.
    Given Switch to Storefront as thirdInternalUser.
    And Refresh page.
    And Dashboard page is opened.
    When Click on Skip button.
    And Close cookies pop-up.
    Then VOLUME REBATE AVR section is not displayed in the header menu.
    Given Switch to Storefront as secondEmpAdmin.
    And Manage Users page is opened.
    And Refresh page.
    When Admin opens Users tab.
    And Sets <sso> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    And Expand Change an empower Privilege/Role in I want to block.
    When Admin turn on Volume Rebate toggle.
    And Clicks on Assign button.
    Given Switch to Storefront as thirdInternalUser.
    And Dashboard page is opened.
    And Refresh page.
    Then VOLUME REBATE AVR section is displayed in the header menu.

    Examples:
      | sso       |
      | 503089727 |

  Scenario: Check that dashboard AVR widget is not displayed and appropriate No AVR title is displayed on the Volume rebate page if no AVR data available.
    And Select account 9000131.
    And Click on chosen account.
    And Dashboard page is opened.
    When Click on Skip button.
    And Close cookies pop-up.
    Then VOLUME REBATE AVR section is displayed in the header menu.
    Then AVR widget is not displayed on the Dashboard page.
    When User clicks on VOLUME REBATE section in header menu.
    Then There are no Volume Rebates available for this account. No AVR message is displayed on the Volume rebates page.