Feature: Create Rebate manually/ via file uploading, Save for later, Edit saved rebate, Delete saved rebate.

  Background:
    Given Switch to Storefront as empAdmin.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Rebates page is opened.

  Scenario: Check that Empower regional manager and Regional Account view users are able to see the same count of rebates.
    And Admin see all the rebates.
    Given Switch to Storefront as regionalView.
    And User is logged in to Storefront.
    And Rebates page is opened.
    Then Regional view see the same count of rebates as admin.

  Scenario: Check that user able to open Rebates page and correct header title is displayed.
    Then Rebates title is displayed on Rebates page.

  Scenario: Check that quantity of All Rebate box is displayed correctly.
    Then All Rebates quantity box is the sum of In Process and Complete quantity boxes.

  Scenario: Check that external user can see less quantity of Rebates than admin.
    And Admin see all the rebates.
    Given Switch to Storefront as externalUser2.
    And User is logged in to Storefront.
    And Rebates page is opened.
    Then External user can see less quantity of All Rebates than admin.

  Scenario Outline: Check that user is able to place rebate manually.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    When User chooses Manual Entry option.
    When User hover mouse over top Next button on Rebate Creation 1 page.
    Then Is <tooltipNextButton1and2page> text displayed in the Next button tooltip on Rebate Creation 1 page.
    And Sets account for chosen region to the Account No. field.
    When Click on Search Agreement No icon.
    And Hover mouse over Apply button in Special Pricing Lookup pop-up.
    Then Is <applyButtonTooltipText> text is displayed in Apply tooltip button.
    And Chooses random SPA No. from Special Pricing Lookup list for the appropriate Account.
    Given Select test product for chosen region.
    When User sets appropriate Catalog No. for appropriate account to the Catalog No. field.
    When Click on Search End Customer Account No icon.
    And Hover mouse over Apply button in End Customer Account No pop-up.
    Then Is <applyButtonTooltipText> text is displayed in Apply tooltip button.
    And Chooses random End Customer Account No. from End Customer Account No. list.
    And Sets correct End Customer Invoice Date.
    And Sets random Distributor Invoice No.
    And Sets random Qty. Sold.
    When User hover mouse over question icon on Rebate Creation 1 page.
    Then Is <questionIconTooltipText> text displayed in question icon tooltip on Rebate Creation 1 page.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    Then All data has been replaced correctly from first to second step.
    When User clicks on the Next top button on the second rebate creation step.
    Then Request summary step is opened.
    Then All data has been replaced correctly from second to third step.
    When User clicks on the Submit rebate button.
    And Users accepts Terms and Conditions for Rebates popup.
    Then Request Submission Successful pop-up is displayed.
    And Rebate is created with all parameters.
    Then Rebates title is displayed on Rebates page.
    Then Created rebate is appeared on the All Rebates page.

    Examples:
      | tooltipNextButton1and2page               | questionIconTooltipText                                           | applyButtonTooltipText        |
      | Required data is missing or is incorrect | Assign an ID# or name to this rebate request for your own records | Please make a selection first |

  Scenario: Check that user is able to place rebate via file uploading.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    And Upload test rebate file with name rebate2.xlsx.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    And Spa No. and Catalog No. are stored to the threadVarsHashMap.
    When User clicks on the Next top button on the second rebate creation step.
    Then Request summary step is opened.
    When User clicks on the Submit rebate button.
    And Users accepts Terms and Conditions for Rebates popup.
    Then Request Submission Successful pop-up is displayed.
    And Rebate is created with all parameters.
    Then Rebates title is displayed on Rebates page.
    Then Created rebate is appeared on the All Rebates page.

  Scenario: Check validation message for End Customer Invoice Date > Current date via file uploading.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    And Upload test rebate file with name futureDate-rebate2.xlsx.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    Then Validation message Date should not be more than current date is displayed under the End Customer Invoice Date field.
    Then Error message is displayed Invalid invoice dates: 12/01/2020 in the top of Rebate Second step page.
    When User hover mouse over top Next button on Rebate Creation 2 page.
    Then Is Required data is missing or is incorrect text displayed in the Next button tooltip on Rebate Creation 2 page.

  Scenario: Check validation message for Current date < 90 days via file uploading.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    And Upload test rebate file with name pastDate-rebate2.xlsx.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    Then Validation message Date should not be more than 90 days prior to current date is displayed under the End Customer Invoice Date field.
    Then Error message is displayed Invalid invoice dates: 01/01/2017 in the top of Rebate Second step page.

  Scenario: Check that user is able to save Rebate for later and then post it.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    When User chooses Manual Entry option.
    And Sets account for chosen region to the Account No. field.
    When Click on Search Agreement No icon.
    And Chooses random SPA No. from Special Pricing Lookup list for the appropriate Account.
    Given Select test product for chosen region.
    When User sets appropriate Catalog No. for appropriate account to the Catalog No. field.
    When Click on Search End Customer Account No icon.
    And Chooses random End Customer Account No. from End Customer Account No. list.
    And Sets correct End Customer Invoice Date.
    And Sets random Distributor Invoice No.
    And Sets random Qty. Sold.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    When User clicks on Save for later button.
    Then Save to Rebates List with title Save to Rebates List pop-up is appeared.
    Then Save for later pop-up contains Please enter a new rebates list name header.
    When User sets random name to the list name input.
    And User clicks on Save button in Save for later pop-up.
    Then Rebates title is displayed on Rebates page.
    When User opens Saved credit request tab.
    Then The rebate with appropriate name is displayed on the Saved credit request tab.
    When User clicks on Edit saved rebate icon.
    Then Second step is opened.
    Then All data has been replaced correctly from first to second step.
    When User clicks on the Next top button on the second rebate creation step.
    Then Request summary step is opened.
    Then All data has been replaced correctly from second to third step.
    When User clicks on the Submit rebate button.
    And Users accepts Terms and Conditions for Rebates popup.
    Then Request Submission Successful pop-up is displayed.
    And Rebate is created with all parameters.
    Then Rebates title is displayed on Rebates page.
    Then Created rebate is appeared on the All Rebates page.

  Scenario: Check that user is able to save Rebate for later and then delete it.
    When Users click on the Create Rebate button on the All Rebates page.
    Then First step of rebate creation process is opened.
    When User chooses Manual Entry option.
    And Sets account for chosen region to the Account No. field.
    When Click on Search Agreement No icon.
    And Chooses random SPA No. from Special Pricing Lookup list for the appropriate Account.
    Given Select test product for chosen region.
    When User sets appropriate Catalog No. for appropriate account to the Catalog No. field.
    When Click on Search End Customer Account No icon.
    And Chooses random End Customer Account No. from End Customer Account No. list.
    And Sets correct End Customer Invoice Date.
    And Sets random Distributor Invoice No.
    And Sets random Qty. Sold.
    When User clicks on the Next top button on the first rebate creation step.
    Then Second step is opened.
    When User clicks on Save for later button.
    Then Save to Rebates List with title Save to Rebates List pop-up is appeared.
    Then Save for later pop-up contains Please enter a new rebates list name header.
    When User sets random name to the list name input.
    And User clicks on Save button in Save for later pop-up.
    Then Rebates title is displayed on Rebates page.
    When User opens Saved credit request tab.
    And Delete just saved rebate.
    And Refresh page.
    When User opens Saved credit request tab.
    Then The rebate with appropriate name is not displayed on the Saved credit request tab.

  Scenario Outline: Check that user is not able to see Rebates section and page response is 403 if appropriate toggle is turned of to the user.
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets <sso> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    And Expand Change an empower Privilege/Role in I want to block.
    When Admin turn off Rebate Access toggle.
    And Clicks on Assign button.
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose North_America region.
    And Select account 2244411.
    And Click on chosen account.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    Then Rebates section is not displayed on the Header menu.
    And Rebates page is opened.
    Then User sees Access Denied page.
    Given Switch to Storefront as empAdmin.
    And Manage Users page is opened.
    And Refresh page.
    When Admin opens Users tab.
    And Sets <sso> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    And Expand Change an empower Privilege/Role in I want to block.
    When Admin turn on Rebate Access toggle.
    And Clicks on Assign button.
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    Then Rebates section is displayed on the Header menu.

    Examples:
      | sso           |
      | romanlessonly |