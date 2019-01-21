Feature: Some actions on Account Management page as admin

  Background:
    Given Switch to Storefront as empAdmin.
    And User is logged in to Storefront.

  Scenario: Check that user able to choose appropriate account
    And Account management page is opened.
    Then Is Favorites tab displayed by Default on Account Management page.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    When Click on Skip button.
    Then Check that Dashboard page is opened.
    Then Chosen account is displayed in account box on Dashboard page.

  Scenario: Check that admin is able to mark any account as favorite and find it in dropdown on Dashboard page.
    And Account management page is opened.
    And Count of Favorites accounts is stored to the threadVarsHashMap.
    And User switch to Approved Accounts tab on Account management page.
    When User marks some account as favorite.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    When User opens account info dropdown.
    Then Correct count of favorite accounts is displayed in the account info dropdown.
    Then Previously marked account is displayed in account info dropdown.
    And Account management page is opened.
    And Previously marked account is unmarked by user.
    Then Correct count of favorite account is displayed in Favorites tab.

  Scenario: Check that user is able to go into the favorite account.
    And Account management page is opened.
    And User switch to Favorites Accounts tab on Account management page.
    When User selects random favorites account.
    Then Dashboard page is opened.
    Then Previously chosen account is displayed on the account info dropdown.

  Scenario Outline: Check that account with stopbook value Z9 contains correct icon with tooltip and message in account drop-down.
    And Account management page is opened.
    When Choose North_America region.
    And Select account 2057V01.
    When User hover mouse over red certificate icon.
    Then Is tooltip text <tooltipText> displayed in stopship/stopbook tooltip.
    And Click on account with USS1 sales division.
    And Dashboard page is opened.
    When Click on Skip button.
    Then Is red triangle icon displayed near account no.
    When User opens account info dropdown.
    Then Is account info drop down message <accountPopUpMessage> displayed in red block.
    When User clicks on HERE link.
    Then Is title Expired TAX Certificate in expired tax pop up displayed.
    Then Is header text <headerText>, middle text <middleText> and bottom text <bottomText> displayed in expired TAX Certificate pop up.
    When User clicks on Dismiss button.
    Then Is expired tax pop up not displayed.

    Examples:
      | tooltipText                                | accountPopUpMessage                               | headerText                                                                                                                                                                                                                  | middleText                                                               | bottomText                                                                 |
      | Expired TAX Certificate: Click for details | TAX Certificate expired - Click HERE for details. | A tax exemption certificate is required on your account. Please send a properly signed and dated exemption certificate for every state you ship to (for which you plan to claim exemption status) to US-EPISTaxTeam@abb.com | For GEIS United States accounts - The certificate should be made out to: | For Zenith United States accounts - The certificate should be made out to: |

  Scenario Outline: Check that account with stopbook any value except Z9 contains correct icon with tooltip and message in account drop-down.
    And Account management page is opened.
    When Choose ASIA region.
    And Select account 1000202.
    When User hover mouse over red triangle icon.
    Then Is tooltip text <tooltipText> displayed in stopship/stopbook tooltip.
    And Click on account with CNS1 sales division.
    And Dashboard page is opened.
    When Click on Skip button.
    Then Is red triangle icon displayed near account no.
    When User opens account info dropdown.
    Then Is account info drop down message <accountPopUpMessage> displayed in red block.

    Examples:
      | tooltipText                                                                                            | accountPopUpMessage                                                                                    |
      | This account is on Order Block: pricing and ordering are unavailable. Please contact customer service. | This account is on Order Block, pricing and ordering are unavailable. Please contact customer service. |

  Scenario Outline: Check that account with not empty stopship value contains correct icon with tooltip and message in account drop-down.
    And Account management page is opened.
    When Choose EMEA region.
    And Select account 9000131.
    When User hover mouse over red triangle icon.
    Then Is tooltip text <tooltipText> displayed in stopship/stopbook tooltip.
    And Click on account with TRS1 sales division.
    And Dashboard page is opened.
    When Click on Skip button.
    Then Is red triangle icon displayed near account no.
    When User opens account info dropdown.
    Then Is account info drop down message <accountPopUpMessage> displayed in red block.

    Examples:
      | tooltipText                                                                                                                       | accountPopUpMessage                                                                                                               |
      | This account is on Delivery Block: pricing and ordering are allowed, but shipments will be held. Please contact customer service. | This account is on Delivery Block, pricing and ordering are allowed, but shipments will be held. Please contact customer service. |

  Scenario Outline: Check that user can search account by name and name with character &
    And Account management page is opened.
    When Choose North_America region.
    And Select account <accountName>.
    Then Is account name <accountName> displayed in the table.
    And Select account <accountName2>.
    Then Is account name <accountName2> displayed in the table.

    Examples:
      | accountName                     | accountName2                     |
      | YOKOGAWA CORPORATION OF AMERICA | WOMACK ELECTRIC & SUPPLY CO, INC |